package web.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.util.ZXingHelper;

//import web.repository.ComputadorRepository;

@Controller
@RequestMapping({ "/perfil/" })
public class loginController {

	//@Autowired
	//ComputadorRepository computadorrepository;
	
	@GetMapping({"/"})
    public String inicio(Model modelo) {
       // modelo.addAttribute("computador", computadorrepository.findAll());
        return "menu";
    }
	
	@GetMapping({"/ingresoQR/{codigo}"})
    public String QR(Model modelo, @PathVariable String codigo) {
        modelo.addAttribute("persona", codigo);
        return "ingresoQR";
    }
	
	@GetMapping({"/infoBasica"})
    public String infoBasica(Model modelo) {
		//modelo.addAttribute("estudiante", new Estudiante());
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
