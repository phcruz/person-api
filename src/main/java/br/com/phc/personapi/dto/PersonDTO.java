package br.com.phc.personapi.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.phc.personapi.entity.Phone;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty
	@Size(min = 3, max = 100)
	private String firstName;
	@NotEmpty
	@Size(min = 3, max = 100)
	private String lastname;
	@NotEmpty
	@CPF
	private String cpf;
	private String birthDate;
	@Valid
	@NotEmpty
	private List<Phone> phones;

	public PersonDTO() {
	}

	public PersonDTO(Long id, String firstName, String lastname, String cpf, String birthDate, List<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phones = phones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
