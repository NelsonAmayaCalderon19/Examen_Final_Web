package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({ "/infoBasica/" })
public class infoBasicaController {

	/*@PostMapping({ "/registrarEstudiante" })
    public String registrarUsuario(@ModelAttribute(value="estudiante") Estudiante computador ,HttpServletRequest request, Model modelo) {


		//Inventario inv = new Inventario();

        //estudianterepository.save(computador);
        /*inv.setIdComputador(computador.getId());
        inv.setCantidad(0);
        inventariorepository.save(inv);*/
        //modelo.addAttribute("computador", computadorrepository.findAll());
        /*return "redirect:/compu/listado";
    }*/
}
