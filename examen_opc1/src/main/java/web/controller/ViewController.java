package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import web.entities.Usuario;
import web.repository.UsuarioRepository;
import web.util.PasswordGenerator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
@Controller

public class ViewController {
	@Autowired
	UsuarioRepository usuariorepository;

	@GetMapping("/{nombre}")
	public String vista(Model modelo,@PathVariable String nombre){	
		modelo.addAttribute("empresa", nombre);

		return "login";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo, Model model){	

		return "home";
	}
	
	@GetMapping("/registrar")
	public String registrar(){	
		return "registrarpc";
	}
	
	@GetMapping({"/iniciar"})
    public String iniciarSesion(Model modelo) {
		modelo.addAttribute("empresa", "null");
        return "login";
    }

	
	
	
	/*
	@GetMapping("/login")
	public String login(){
		return "index";
	}
	
	@GetMapping("/adios")
	public String adios(){
		
		Optional<Empleado> empleadoOpt = empleadorepository.findById(17374);
		
		Empleado empleado = empleadoOpt.get();
		return "Adios con Spring Boot por GET "+ empleado.getNombre();
	}
	
	@GetMapping("/get/{codigo}")
	public String ver(@PathVariable Integer codigo){
		
		Optional<Empleado> clienteOpt = empleadorepository.findById(codigo);
		if(!clienteOpt.isPresent()) {
			return "El Código "+codigo+" de Cliente - No Existe";
		}else {
		Empleado cliente = clienteOpt.get();
		return "Adios con Spring Boot por GET "+ cliente.getNombre();
		}
	}
	*/
	
	
}
