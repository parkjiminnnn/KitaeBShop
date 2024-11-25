package inhatc.cse.kitaebshop.resume.controller;

import inhatc.cse.kitaebshop.resume.dto.ResumeDto;
import inhatc.cse.kitaebshop.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/add")
    public String showResumeForm(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        return "resume/resumeForm"; // 템플릿 파일명 (resumeForm.html)
    }

    @PostMapping("/add")
    public String saveResume(@ModelAttribute ResumeDto resumeDto) {
        resumeService.saveResume(resumeDto);
        return "redirect:/resume/list";
    }

    // 이력서 목록 페이지
    @GetMapping("/list")
    public String listResumes(Model model) {
        model.addAttribute("resumes", resumeService.getAllResumes());
        return "resume/myResumes";
    }

    // 이력서 수정 폼 페이지
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        ResumeDto resumeDto = resumeService.getResumeById(id);
        model.addAttribute("resume", resumeDto);
        return "resume/editResumeForm"; // 수정 폼 템플릿 (editResumeForm.html)
    }

    // 이력서 수정 처리
    @PostMapping("/edit/{id}")
    public String updateResume(@PathVariable("id") Long id, @ModelAttribute ResumeDto resumeDto) {
        resumeService.updateResume(id, resumeDto);
        return "redirect:/resume/list"; // 수정 후 목록으로 리다이렉트
    }

    // 이력서 삭제 처리
    @PostMapping("/delete/{id}")
    public String deleteResume(@PathVariable("id") Long id) {
        resumeService.deleteResume(id);
        return "redirect:/resume/list"; // 삭제 후 목록으로 리다이렉트
    }
}