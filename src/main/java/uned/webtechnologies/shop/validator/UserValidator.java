package uned.webtechnologies.shop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "common.empty");

        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "register.username.length");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "register.username.used");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "common.empty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "register.password.length");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "register.password.confirm");
        }
    }


}