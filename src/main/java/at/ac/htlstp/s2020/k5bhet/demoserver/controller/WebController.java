package at.ac.htlstp.s2020.k5bhet.demoserver.controller;

import at.ac.htlstp.s2020.k5bhet.demoserver.config.Endpoints;
import at.ac.htlstp.s2020.k5bhet.demoserver.model.FormModel;
import at.ac.htlstp.s2020.k5bhet.demoserver.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Für die Kommunikation von Webbrowser mit Server
 */
@Controller
public class WebController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

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

    @RequestMapping(Endpoints.login)
    public String login(Model model) {
        return "login";
    }

    @GetMapping(Endpoints.logout)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:"+Endpoints.login;
    }

}
