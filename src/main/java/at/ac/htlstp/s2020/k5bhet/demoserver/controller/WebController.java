package at.ac.htlstp.s2020.k5bhet.demoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="")
public class WebController {

    @GetMapping("")
    public String test(Model model) {
        model.addAttribute("name","Deimel");
        return "testview";
    }
}
