package inhatc.cse.kitaebshop.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class SpellCheckerService {

    private final RestTemplate restTemplate;
    private static final String API_URL = "https://mora-bot.kr/api/v1/grammar";

    public SpellCheckerService() {
        this.restTemplate = new RestTemplate();
    }

    public String checkGrammar(String inputText) {
        // URI 구성
        String uri = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("string", inputText)
                .toUriString();

        // API 호출
        Map<String, Object> response = restTemplate.getForObject(uri, Map.class);

        // JSON 응답에서 원하는 데이터 추출 (예: "result" 키)
        if (response != null && response.containsKey("result")) {
            return response.get("result").toString();
        } else {
            return "문법 검사 결과를 가져올 수 없습니다.";
        }
    }
}
