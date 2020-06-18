package web.controller;

import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.entities.*;
import web.entities.Usuario;
import web.repository.*;
import web.util.PasswordGenerator;
import web.util.ZXingHelper;

//import web.repository.ComputadorRepository;

@Controller
@RequestMapping({ "/perfil/" })
public class loginController {
	@Autowired
	UsuarioRepository usuariorepository;

	@Autowired
	TipoRepository tiporepository;
	
	@Autowired
	EpsRepository epsrepository;
	
	@Autowired
	ModalidadRepository modalidadrepository;
	
	//@Autowired
	//ComputadorRepository computadorrepository;
	@GetMapping({"/"})
    public String perfil(Model modelo) {
       // modelo.addAttribute("computador", computadorrepository.findAll());
        return "menu";
    }
	@PostMapping({"/login"})
    public String home(HttpServletRequest request, Model modelo, Model imprimir) {
		PasswordGenerator p = new PasswordGenerator();
		Optional<Usuario> empleadoOpt = usuariorepository.findById(Integer.parseInt(request.getParameter("username")));
		if(!empleadoOpt.isPresent()) {
			return "redirect:/iniciar";
		}else {
		Usuario empleado = empleadoOpt.get();
		//JOptionPane.showMessageDialog(null, dato);
		if(empleado.getClave().equalsIgnoreCase(request.getParameter("password"))){
			//modelo.addAttribute("usuario", empleado.getNombre());
			//imprimir.addAttribute("computador", computadorrepository.findAll());
		return "menu";
		
	}else {
		return "redirect:/iniciar";
		}
	}
		       
    }
	
	@GetMapping({"/ingresoQR/{codigo}"})
    public String QR(Model modelo, @PathVariable String codigo) {
        modelo.addAttribute("persona", codigo);
        return "ingresoQR";
    }
	
	@GetMapping({"/infoBasica"})
    public String infoBasica(Model modelo) {
		modelo.addAttribute("persona", new Basico());
		modelo.addAttribute("tipos", tiporepository.findAll());
		modelo.addAttribute("seguros", epsrepository.findAll());
		modelo.addAttribute("modalidades", modalidadrepository.findAll());
        return "infoBasica";
        
    }
	
	@GetMapping({"/infoPersonas"})
    public String personas(Model modelo) {
       // modelo.addAttribute("computador", computadorrepository.findAll());
        return "personas";
    }
	
	@GetMapping({"/comorbilidades"})
    public String comorbilidades(Model modelo) {
       // modelo.addAttribute("computador", computadorrepository.findAll());
        return "comorbilidades";
    }
	
	@GetMapping({"/ingreso"})
    public String ingreso(Model modelo) {
       // modelo.addAttribute("computador", computadorrepository.findAll());
        return "ingreso";
    }
	
	@RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}
}
