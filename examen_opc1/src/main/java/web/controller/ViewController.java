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


import web.util.PasswordGenerator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
@Controller

public class ViewController {

	//@Autowired
	//EmpleadoRepository empleadorepository;

//	@Autowired
	//ComputadorRepository computadorrepository;

	@GetMapping("/{nombre}")
	public String vista(Model modelo,@PathVariable String nombre){	
		modelo.addAttribute("instituto", nombre);

		return "login";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo, Model model){	
		//modelo.addAttribute("computador", computadorrepository.findAll());
		//model.addAttribute("empleado", empleadorepository.findAll());
		return "home";
	}
	
	@GetMapping("/registrar")
	public String registrar(){	
		return "registrarpc";
	}
	
	@GetMapping({"/iniciar"})
    public String iniciarSesion(Model modelo) {
		modelo.addAttribute("instituto", "null");
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
	
	@PostMapping({"/home"})
    public String home(HttpServletRequest request, Model modelo, Model imprimir) {
		PasswordGenerator p = new PasswordGenerator();
		Optional<Empleado> empleadoOpt = empleadorepository.findById(Integer.parseInt(request.getParameter("cedula")));
		if(!empleadoOpt.isPresent()) {
			return "index";
		}else {
		Empleado empleado = empleadoOpt.get();
		String dato = p.encriptador(request.getParameter("clave"));
		System.out.println(dato);
		//JOptionPane.showMessageDialog(null, dato);
		if(empleado.getClave().equalsIgnoreCase(request.getParameter("clave"))){
			modelo.addAttribute("empleado", empleado.getNombre());
			imprimir.addAttribute("computador", computadorrepository.findAll());
		return "home";
		
	}else {
		return "index";
		}
	}
		       
    }*/
	
}
