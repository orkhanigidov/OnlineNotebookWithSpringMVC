package notebook.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import notebook.model.Note;

@Component
public class NoteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Note.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
				"title", 
				"required.title", 
				"Title can not be empty");
		
	}

}
