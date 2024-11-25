package inhatc.cse.kitaebshop.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolsController {

    @GetMapping("/tools/char-counter")
    public String showCharCounter() {
        return "tools/char-counter"; // tools/char-counter.html 페이지로 연결
    }
}