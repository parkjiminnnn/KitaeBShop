package inhatc.cse.kitaebshop.resume.entity;

import inhatc.cse.kitaebshop.resume.constant.ResumeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    private String email;

    @NotBlank(message = "연락처를 입력해주세요.")
    private String phone;

    @Size(max = 1000)
    private String experience;

    @Size(max = 500)
    private String education;

    @Size(max = 500)
    private String skills;

    @Enumerated(EnumType.STRING)
    private ResumeStatus status;  // 이력서 상태 (REGISTERED, APPROVED 등)
}