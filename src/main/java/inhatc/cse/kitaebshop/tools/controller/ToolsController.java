package inhatc.cse.kitaebshop.tools.controller;

import inhatc.cse.kitaebshop.tools.dto.GrammarResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/tools")
public class ToolsController {

    private static final String SPELL_CHECK_API_URL = "https://mora-bot.kr/api/v1/grammar?";

    @GetMapping("/char-counter")
    public String showCharCounter() {
        return "tools/char-counter";
    }

    @GetMapping("/spell-checker")
    public String spellCheck(@RequestParam("text") String text, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = UriComponentsBuilder
                .fromHttpUrl(SPELL_CHECK_API_URL)
                .queryParam("string", text)
                .build(false)
                .toUriString();

        try {
            ResponseEntity<GrammarResponseDto> response = restTemplate.getForEntity(apiUrl, GrammarResponseDto.class);
            GrammarResponseDto grammarResponse = response.getBody();

            if (grammarResponse != null && grammarResponse.isSuccess()) {
                model.addAttribute("original", grammarResponse.getOriginal());
                model.addAttribute("message", grammarResponse.getMessage());
                model.addAttribute("wrong", grammarResponse.getWrong() != null ? grammarResponse.getWrong() : "틀린 부분 없음");
                model.addAttribute("suggestions", grammarResponse.getSuggestions() != null ? grammarResponse.getSuggestions() : List.of("추천 문장 없음"));
                model.addAttribute("more", grammarResponse.getMore() != null ? grammarResponse.getMore() : "해설 없음");
            } else {
                model.addAttribute("result", "API 응답에서 오류가 발생했습니다.");
            }
        } catch (Exception e) {
            model.addAttribute("result", "API 요청 중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        return "tools/spell-checker";
    }
}
