package com.ssafy.lasttable.menu.entity;

public class Menu {
	private Long menuId;
	private String name;
	private String category;
	private int price;
	private boolean isActive;
	private String img;
	private String description; // 짧은 설명
	private String longDescription; // 긴 설명
	private String sushiPieces; // 초밥 개수 (예: 광어1 참치1 연어2)

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getSushiPieces() {
		return sushiPieces;
	}

	public void setSushiPieces(String sushiPieces) {
		this.sushiPieces = sushiPieces;
	}
}
