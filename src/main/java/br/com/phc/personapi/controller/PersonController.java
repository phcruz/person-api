package br.com.phc.personapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phc.personapi.dto.MessageResponseDTO;
import br.com.phc.personapi.dto.PersonDTO;
import br.com.phc.personapi.exception.StandardError;
import br.com.phc.personapi.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Api of person")
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "Create person")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = MessageResponseDTO.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@ApiImplicitParams({@ApiImplicitParam(name = "x-transaction-id", paramType = "header",
			defaultValue = "MDowOjA6MDowOjA6MDoxOndlYi1hcHBsaWNhdGlvbjoxMi8wOS8yMDIwIDE4OjE3OjA4", required = true) })
	@PostMapping
	public ResponseEntity<MessageResponseDTO> createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personDTO));
	}
	
	@ApiOperation(value = "Find person by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = PersonDTO.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@ApiImplicitParams({@ApiImplicitParam(name = "x-transaction-id", paramType = "header",
			defaultValue = "MDowOjA6MDowOjA6MDoxOndlYi1hcHBsaWNhdGlvbjoxMi8wOS8yMDIwIDE4OjE3OjA4", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(personService.getPersonById(id));
	}
	
	@ApiOperation(value = "Find all person")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Page.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@ApiImplicitParams({@ApiImplicitParam(name = "x-transaction-id", paramType = "header",
			defaultValue = "MDowOjA6MDowOjA6MDoxOndlYi1hcHBsaWNhdGlvbjoxMi8wOS8yMDIwIDE4OjE3OjA4", required = true) })
	@GetMapping
	public Page<PersonDTO> listPerson(@RequestBody Pageable pageable) {
		return personService.listPerson(pageable);
	}
	
	@ApiOperation(value = "Update person by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = MessageResponseDTO.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@ApiImplicitParams({@ApiImplicitParam(name = "x-transaction-id", paramType = "header",
			defaultValue = "MDowOjA6MDowOjA6MDoxOndlYi1hcHBsaWNhdGlvbjoxMi8wOS8yMDIwIDE4OjE3OjA4", required = true) })
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponseDTO> updateById(@PathVariable Long id,
    		@RequestBody @Valid PersonDTO personDTO) {
        return ResponseEntity.ok().body(personService.updateById(id, personDTO));
    }
	
	@ApiOperation(value = "Delete person by id")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content"),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@ApiImplicitParams({@ApiImplicitParam(name = "x-transaction-id", paramType = "header",
			defaultValue = "MDowOjA6MDowOjA6MDoxOndlYi1hcHBsaWNhdGlvbjoxMi8wOS8yMDIwIDE4OjE3OjA4", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
