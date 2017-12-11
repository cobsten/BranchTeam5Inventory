package sg.edu.iss.inventory.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.inventory.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "userId", "error.user.userid.empty");
		ValidationUtils.rejectIfEmpty(errors, "userName", "error.user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		System.out.println(u.toString());
	}
}
