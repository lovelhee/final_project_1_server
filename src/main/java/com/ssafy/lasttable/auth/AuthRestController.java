package com.ssafy.lasttable.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.ssafy.lasttable.auth.dto.AuthResponse;
import com.ssafy.lasttable.auth.dto.GoogleLoginRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final String googleWebClientId;
    private final JwtProvider jwtProvider;

    public AuthRestController(
            @Value("${google.web-client-id}") String googleWebClientId,
            JwtProvider jwtProvider
    ) {
        this.googleWebClientId = googleWebClientId;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody GoogleLoginRequest request) throws Exception {
        String idTokenString = request.getIdToken();
        if (idTokenString == null || idTokenString.isBlank()) {
            return ResponseEntity.badRequest().body("idToken is required");
        }

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                new NetHttpTransport(),
                GsonFactory.getDefaultInstance()
        )
                .setAudience(Collections.singletonList(googleWebClientId))
                .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken == null) {
            return ResponseEntity.status(401).body("Invalid Google ID Token");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();

        String email = payload.getEmail();
        String name = (String) payload.get("name");
        String picture = (String) payload.get("picture");

        // TODO(선택): 여기서 DB에 회원 없으면 자동 가입 처리 (UserMapper 연결)
        // 지금은 로그인 성공 자체만 먼저!

        String jwt = jwtProvider.createToken(email);

        return ResponseEntity.ok(new AuthResponse(jwt, email, name, picture));
    }
}