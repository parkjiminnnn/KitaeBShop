package inhatc.cse.kitaebshop.hello.controller;

import inhatc.cse.kitaebshop.hello.dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model){
        return "test/test";
    }
}
