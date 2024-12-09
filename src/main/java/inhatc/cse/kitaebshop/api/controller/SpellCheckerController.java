//package inhatc.cse.kitaebshop.api.controller;
//
//
//import inhatc.cse.kitaebshop.api.dto.SpellCheckerDto;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class SpellCheckerController {
//
//    @Value("https://mora-bot.kr/api/v1/grammar")
//    private String spellCheckApiUrl;
//
//    @GetMapping("/tools/spell-checker")
//    public String spellCheck(@RequestParam("text") String text, Model model) {
//        // API 호출
//        RestTemplate restTemplate = new RestTemplate();
//        String apiUrl = spellCheckApiUrl + "?string=" + text;
//
//        ResponseEntity<SpellCheckerDto> response = restTemplate.getForEntity(apiUrl, SpellCheckerDto.class);
//        SpellCheckerDto result = response.getBody();
//
//        if (result != null && result.isSuccess()) {
//            model.addAttribute("original", result.getOriginal());
//            model.addAttribute("message", result.getMessage());
//        } else {
//            model.addAttribute("original", text);
//            model.addAttribute("message", "오류가 발생했습니다.");
//        }
//
//        return "spellcheckResult"; // 결과를 렌더링할 HTML 파일
//    }
//}