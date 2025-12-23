package com.ssafy.lasttable.reservation.entity;

public class ReservationCreateRequest {
	private String userId;
	private Long menuId;
	private String reservedAt;
	private int depositAmount;
	private int peopleCount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getReservedAt() {
		return reservedAt;
	}

	public void setReservedAt(String reservedAt) {
		this.reservedAt = reservedAt;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

}
