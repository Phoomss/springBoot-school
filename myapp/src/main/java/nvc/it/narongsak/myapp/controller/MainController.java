package nvc.it.narongsak.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private String path = "page/";

    @GetMapping("/")
    public String index(ModelMap model) {
        String name = "Narongsak P.";
        model.addAttribute("loginName", name);
        model.addAttribute("age", 20);
        return path + "/index";
    }

    @GetMapping("/about")
    public String about() {
        return path + "/about";
    }

    @GetMapping("/contract")
    public String contract(ModelMap model) {
        String tel = "0888888888";
        String email = "narongsak05n@gamil.com";
        String address = "Bang Len";
        model.addAttribute("Tel", tel);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        return path + "/contract";
    }
}
