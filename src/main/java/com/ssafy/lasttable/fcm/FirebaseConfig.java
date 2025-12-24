package com.ssafy.lasttable.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import jakarta.annotation.PostConstruct;

import java.io.FileNotFoundException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

	@PostConstruct
    public void initialize() {
        try {
            String path = "firebase/lasttable-d3e0f-firebase-adminsdk-fbsvc-a571bbea81.json";
            ClassPathResource resource = new ClassPathResource(path);
            
            if (!resource.exists()) {
                // 여기가 실행된다면 파일이 실제 해당 경로에 없는 것입니다.
                throw new FileNotFoundException("Firebase JSON 파일을 찾을 수 없습니다. 경로를 확인하세요: " + path);
            }

            InputStream serviceAccount = resource.getInputStream();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("FCM 초기화 성공!");
            }
        } catch (Exception e) {
            System.err.println("=== Firebase 초기화 에러 상세 로깅 ===");
            e.printStackTrace(); 
        }
	}
}