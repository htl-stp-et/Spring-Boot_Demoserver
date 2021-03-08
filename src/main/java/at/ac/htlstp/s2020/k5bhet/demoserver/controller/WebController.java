package at.ac.htlstp.s2020.k5bhet.demoserver.controller;

import at.ac.htlstp.s2020.k5bhet.demoserver.model.FormModel;
import at.ac.htlstp.s2020.k5bhet.demoserver.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Für die Kommunikation von Webbrowser mit Server
 */
@Controller
@RequestMapping(path="")
public class WebController {

    @Autowired
    private AdressService adressService;

    @RequestMapping("/a")
    public String forma(Model model) {
        model.addAttribute("adressen",adressService);
        return "a";
    }

    @GetMapping("")
    public String test(Model model) {
        model.addAttribute("name","Deimel");
        return "testview";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        return "form";
    }

    @RequestMapping("/formeval")
    public String formEvaluate(@ModelAttribute FormModel formModel, Model model) {
        model.addAttribute("v1",formModel.getVariable1());
        return "form";
    }

}
