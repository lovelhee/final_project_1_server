package com.ssafy.lasttable.last_table.entity;

public class LastTableResponse {

	private Long reservationId;
	private String reservedAt;
	private Integer peopleCount;
	private Integer depositAmount;

	private Long menuId;
	private String menuName;
	private int menuPrice;
	private String menuImg;
    private String menuDescription;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservedAt() {
		return reservedAt;
	}

	public void setReservedAt(String reservedAt) {
		this.reservedAt = reservedAt;
	}

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Integer getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Integer depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	
	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

}