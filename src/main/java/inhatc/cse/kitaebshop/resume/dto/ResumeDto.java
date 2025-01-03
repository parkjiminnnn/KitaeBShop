package inhatc.cse.kitaebshop.resume.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String experience;
    private String education;
    private String skills;
    private String photoPath;

}