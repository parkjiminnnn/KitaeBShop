package inhatc.cse.kitaebshop.tools.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값은 무시
public class GrammarResponseDto {
    @JsonProperty("message")
    private String message;       // 메시지

    @JsonProperty("license")
    private String license;       // 라이선스 정보

    @JsonProperty("status")
    private int status;           // 상태 코드

    @JsonProperty("original")
    private String original;      // 원본 문장

    @JsonProperty("wrong")
    private String wrong;         // 틀린 부분

    @JsonProperty("suggestions")
    private List<String> suggestions; // 추천 문장 (배열)

    @JsonProperty("more")
    private String more;          // 추가 해설

    @JsonProperty("errnum")
    private int errnum;           // 오류 개수

    @JsonProperty("success")
    private boolean success;      // 성공 여부
}