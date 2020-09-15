package br.com.phc.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import br.com.phc.personapi.dto.PersonDTO;
import br.com.phc.personapi.entity.Person;

public class PersonUtils {

	private static final String FIRST_NAME = "Paulo Henrique";
	private static final String LAST_NAME = "da Cruz";
	private static final String CPF_NUMBER = "369.333.878-79";
	private static final long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(1990, 2, 8);

	public static PersonDTO createFakeDTO() {
		return new PersonDTO(PERSON_ID, FIRST_NAME, LAST_NAME, CPF_NUMBER, "08/02/1990",
				Collections.singletonList(PhoneUtils.createFakeEntity()));
	}

	public static Person createFakeEntity() {
		return new Person(PERSON_ID, FIRST_NAME, LAST_NAME, CPF_NUMBER, BIRTH_DATE,
				Collections.singletonList(PhoneUtils.createFakeEntity()));
	}
}
