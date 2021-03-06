package cl.springboot.form.app.controllers;

import java.util.Hashtable;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cl.springboot.form.app.models.domain.Usuario;
import cl.springboot.form.app.validador.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador usuarioValidador;

	/*para registar la clase de validaciones de atributos de un objetos*/
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(usuarioValidador);
//	}

	@GetMapping("/form")
	public  String form(Model model) {
		model.addAttribute("titulo", "Formulario");
		model.addAttribute("usuario", new Usuario("123456789","Juan Daniel", "Muñoz Queupul"));
		return "form";
	}
	
// video de 50 de spring	
//	@PostMapping("/form")
//	public String procesar(Model model, 
//			@RequestParam(name = "username") String username,
//			@RequestParam String password,
//			@RequestParam String email) {
//		
//		Usuario usuario = new Usuario();
//		usuario.setEmail(email);
//		usuario.setPassword(password);
//		usuario.setUsername(username);
//		
//		model.addAttribute("titulo", "Resultado desde Fromulario");
//		model.addAttribute("usuario", usuario);
//	
//		return "resultado";
//		
//	}

// video 51 de pasar objetos mapeados.	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult results, Model model, SessionStatus status) {
		
		/*aca vamos o estamos validando de forma explicita*/
		usuarioValidador.validate(usuario,results);
		
		model.addAttribute("titulo", "Resultado desde Fromulario");
		
		if(results.hasErrors()) {
			Map<String, String> errores = new Hashtable<String, String>();
			results.getFieldErrors().forEach(error -> {
				errores.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
			} );
			
			model.addAttribute("error", errores);
			return "form";
		}
		
		model.addAttribute("titulo", "Resultado desde Fromulario");
		model.addAttribute("usuario", usuario);
		status.setComplete();
		
	
		return "resultado";
		
	}

}
