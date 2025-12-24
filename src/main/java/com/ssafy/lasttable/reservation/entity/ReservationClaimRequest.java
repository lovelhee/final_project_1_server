package com.ssafy.lasttable.reservation.entity;

public class ReservationClaimRequest {
	private String userId;
	private int depositAmount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

}
