package br.com.phc.personapi.dto;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.phc.personapi.enums.PhoneType;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	@NotEmpty
	@Size(min = 2, max = 3)
	private String ddd;
	@NotEmpty
	@Size(min = 8, max = 9)
	private String number;

	public PhoneDTO() {
	}

	public PhoneDTO(Long id, PhoneType type, String ddd, String number) {
		this.id = id;
		this.type = type;
		this.ddd = ddd;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
