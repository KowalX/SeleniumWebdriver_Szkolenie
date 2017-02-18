package SeleniumWorkshop.converters;

import SeleniumWorkshop.annotationObjects.User;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

/**
 * Created by JIT on 18-Feb-17.
 */
public class UserConverter extends AbstractConverter<User> {

    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String EMAIL_ADDRESS = "emailAddress";
    private static final String COUNTRY = "country";
    private static final String ADDRESS_FIRST_LINE = "addressFirstLine";
    private static final String ADDRESS_SECOND_LINE = "addressSecondLine";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String POSTAL_CODE = "postalCode";

    public User convert(Map<String, Object> convertFrom) {
        if(convertFrom == null){
            throw new IllegalArgumentException("Can't convert from not existing map");
        }

        User user = new User();
        user.setUserName((String) convertFrom.get(USERNAME));
        user.setPassword((String) convertFrom.get(PASSWORD));
        user.setFirstName((String) convertFrom.get(FIRST_NAME));
        user.setLastName((String) convertFrom.get(LAST_NAME));
        user.setPhoneNumber((String) convertFrom.get(PHONE_NUMBER));
        user.setEmailAddress((String) convertFrom.get(EMAIL_ADDRESS));
        user.setCountry((String) convertFrom.get(COUNTRY));
        user.setAddressFirstLine((String) convertFrom.get(ADDRESS_FIRST_LINE));
        user.setAddressSecondLine((String) convertFrom.get(ADDRESS_SECOND_LINE));
        user.setCity((String) convertFrom.get(CITY));
        user.setState((String) convertFrom.get(STATE));
        user.setPostalCode((String) convertFrom.get(POSTAL_CODE));
        return user;
    }
}
