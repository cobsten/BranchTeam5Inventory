package sg.edu.iss.inventory.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sg.edu.iss.inventory.model.Product;
@Component
public class ProductValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return Product.class.isAssignableFrom(arg0);

	}
	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		ValidationUtils.rejectIfEmpty(errors, "partNo", "error.product.partNo.empty");
		ValidationUtils.rejectIfEmpty(errors, "carDealer", "error.product.carDealer.empty");
		ValidationUtils.rejectIfEmpty(errors, "partDescription", "error.product.partDescription.empty");
		ValidationUtils.rejectIfEmpty(errors, "color", "error.product.color.empty");
	    System.out.println(product.toString());
	}
}
