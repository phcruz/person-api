package br.com.phc.personapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.phc.personapi.dto.MessageResponseDTO;
import br.com.phc.personapi.dto.PersonDTO;
import br.com.phc.personapi.entity.Person;
import br.com.phc.personapi.exception.NotFoundException;
import br.com.phc.personapi.mapper.PersonMapper;
import br.com.phc.personapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonMapper personMapper;

	public MessageResponseDTO save(PersonDTO personDTO) {
		Person person = personMapper.toModel(personDTO);
		personRepository.save(person);
		
		return MessageResponseDTO.builder("Created person with ID = " + person.getId());
	}

	public PersonDTO getPersonById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isEmpty()) {
			throw new NotFoundException("No resources found. Check the given id and try again");
		}
		return personMapper.toDTO(person.get());
	}
	
	public Page<PersonDTO> listPerson(Pageable pageable) {
		Page<Person> allPerson = personRepository.findAll(pageable);
		if (allPerson.isEmpty()) {
			throw new NotFoundException("No resources registered");
		}
		List<PersonDTO> list = allPerson.stream().map(personMapper::toDTO).collect(Collectors.toList());
		return new PageImpl<PersonDTO>(list, pageable, list.size()); 
	}

	public void delete(Long id) {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

	private Person verifyIfExists(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No resources registered"));
    }
	
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) {
        verifyIfExists(id);
        personDTO.setId(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return MessageResponseDTO.builder("Updated person with ID = " + updatedPerson.getId());
    }
}
