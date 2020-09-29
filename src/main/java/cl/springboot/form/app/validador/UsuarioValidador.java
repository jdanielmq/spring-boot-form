package cl.springboot.form.app.validador;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		
		/*los mensajes de error sales del messages.properties*/
		//ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.usuario.nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre");
		
		/*validación de atributos de forma personalizada.*/
		if(usuario.getId().matches("Expresion regular") == false) {
			errors.rejectValue("id", "validar.usuario.id");
		}
		
		
		
	}

}
