package br.com.phc.personapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import br.com.phc.personapi.dto.PersonDTO;
import br.com.phc.personapi.entity.Person;

@Service
public class PersonMapper {

	private final String FORMAT_DATE = "dd/MM/yyyy";
	
	public Person toModel(PersonDTO personDTO) {
		Person person = new Person();
		person.setId(personDTO.getId());
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastname());
		person.setCpf(personDTO.getCpf());
		person.setPhones(personDTO.getPhones());
		person.setBirthDate(this.convertStringInLocalDate(personDTO.getBirthDate()));
		
		return person;
	}

    public PersonDTO toDTO(Person person) {
    	PersonDTO personDTO = new PersonDTO();
    	personDTO.setId(person.getId());
    	personDTO.setFirstName(person.getFirstName());
    	personDTO.setLastname(person.getLastName());
    	personDTO.setCpf(person.getCpf());
    	personDTO.setBirthDate(this.convertLocalDateInString(person.getBirthDate()));
    	personDTO.setPhones(person.getPhones());
    	
    	return personDTO;
    }
    
    private LocalDate convertStringInLocalDate(String date) {
    	return LocalDate.parse(date, DateTimeFormatter.ofPattern(FORMAT_DATE));
    }
    
    private String convertLocalDateInString(LocalDate date) {
    	return date.format(DateTimeFormatter.ofPattern(FORMAT_DATE));
    }
}
