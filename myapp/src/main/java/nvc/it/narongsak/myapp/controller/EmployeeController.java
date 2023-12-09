package nvc.it.narongsak.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("")
    @ResponseBody
    public String employee(){
        return "Employee Page";
    }

     @GetMapping( "/{id}")
    @ResponseBody
    public String employee(@PathVariable int id) {
        return "Employee ID. " + id;
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public String employeeName(@PathVariable String name) {
        return "Employee Name: " + name;
    }
}
