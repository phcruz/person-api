package br.com.phc.personapi.utils;

import br.com.phc.personapi.dto.PhoneDTO;
import br.com.phc.personapi.entity.Phone;
import br.com.phc.personapi.enums.PhoneType;

public class PhoneUtils {

	private static final String PHONE_DDD = "016";
    private static final String PHONE_NUMBER = "999999999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return new PhoneDTO(PHONE_ID, PHONE_TYPE, PHONE_DDD, PHONE_NUMBER);
    }

    public static Phone createFakeEntity() {
        return new Phone(PHONE_ID, PHONE_TYPE, PHONE_DDD, PHONE_NUMBER);
    }
}
