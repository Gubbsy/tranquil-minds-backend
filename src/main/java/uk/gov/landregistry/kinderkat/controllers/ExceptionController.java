package uk.gov.landregistry.kinderkat.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exception Controller
 * ~~~~~~~~~~~~~~~~~~~~~
 * Handles all exception responses back to the user, for custom exceptions and request validation.
 *
 */
@ControllerAdvice // Apply to ALL controllers
@RestController
public class ExceptionController {

    /**
     * Validation exception handler
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * For all request validation a 400 is returned and a JSON list of either default or custom validation 
     * message to the user.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return ex.getBindingResult()
			.getAllErrors().stream()
			.map(ObjectError::getDefaultMessage)
			.collect(Collectors.toList());
    }

    
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "The information supplied wont work") //409
    static class DataIntegrityException extends RuntimeException {
        private static final long serialVersionUID = -4851127252963711526L;
        public DataIntegrityException() {
            super("The information supplied wont work. Null value?");
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Email already exists") //409
    static class EmailExistsException extends RuntimeException {
        private static final long serialVersionUID = 615063575993624524L;
        public EmailExistsException(String email) {
            super("The email '" + email + "' is already being used.");
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "User already exists") //409
    static class UserExistsException extends RuntimeException {
        private static final long serialVersionUID = -8130987429877238568L;
        public UserExistsException(String userId) {
            super("The userId '" + userId + "' is already being used.");
        }
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found") //404
    static class UserNotFoundException extends RuntimeException {
        private static final long serialVersionUID = -1069217206194490060L;
        public UserNotFoundException(String userId) {
            super("Could not find user '" + userId + "'.");
        }
    }



}