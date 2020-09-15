package br.com.phc.personapi.enums;

public enum PhoneType {

	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");

	private String description;

	private PhoneType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
