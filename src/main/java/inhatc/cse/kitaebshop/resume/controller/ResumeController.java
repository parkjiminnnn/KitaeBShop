package inhatc.cse.kitaebshop.resume.controller;

import inhatc.cse.kitaebshop.resume.dto.ResumeDto;
import inhatc.cse.kitaebshop.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // 이력서 등록 폼 페이지
    @GetMapping("/resume/add")
    public String showResumeForm(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        return "resume/resumeForm"; // 템플릿 파일명 (resumeForm.html)
    }

    // 이력서 등록 처리
    @PostMapping("/resume/add")
    public String submitResume(ResumeDto resumeDto) {
        resumeService.saveResume(resumeDto);
        return "redirect:/resume/success"; // 성공 페이지로 리다이렉트
    }
}
