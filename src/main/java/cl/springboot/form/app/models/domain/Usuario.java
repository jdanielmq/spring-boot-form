package cl.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario {
	
	private String id;
	
	@NotEmpty(message = "el nombre viene vacio.")
	private String nombre;
	@NotEmpty(message = "el apellido viene vacio.")
	private String apellido;
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String username;
	@NotEmpty
	@Size(min = 8, max = 20)
	private String password;
	
	@NotEmpty(message = "el correo no corresponde al formato")
	@Email
	private String email;
	
	public Usuario(String id, @NotEmpty String nombre, @NotEmpty String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	
}
