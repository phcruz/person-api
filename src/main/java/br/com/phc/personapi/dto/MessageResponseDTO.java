package br.com.phc.personapi.dto;

import java.io.Serializable;

public class MessageResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	public MessageResponseDTO() {
	}

	public MessageResponseDTO(String message) {
		this.message = message;
	}

	public static MessageResponseDTO builder(String message) {
		return new MessageResponseDTO(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
