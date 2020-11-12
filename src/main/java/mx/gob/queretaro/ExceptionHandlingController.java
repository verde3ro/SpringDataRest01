package mx.gob.queretaro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.gob.queretaro.response.ConstraintViolationResponse;

@ControllerAdvice
public class ExceptionHandlingController {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public @ResponseBody Map<String, Object> handleConstraintViolation(
			HttpServletRequest req, ConstraintViolationException exception) {
		Map<String, Object> errores = new HashMap<>();
		List<ConstraintViolationResponse> lista = new ArrayList<>();

		exception.getConstraintViolations().forEach(violation ->
		lista.add(new ConstraintViolationResponse(violation.getPropertyPath().toString(),
				violation.getMessage(), violation.getInvalidValue())));


		errores.put("estado", "error");
		errores.put("errores", lista);

		return errores;
	}

}
