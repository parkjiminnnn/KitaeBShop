package inhatc.cse.kitaebshop.resume.controller;

import inhatc.cse.kitaebshop.resume.dto.ResumeDto;
import inhatc.cse.kitaebshop.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        return "resume/resumeForm"; // 템플릿 파일명
    }

    @PostMapping("/add")
    public String saveResume(@ModelAttribute ResumeDto resumeDto,
                             @RequestParam("photo") MultipartFile photoFile) {
        try {
            // 파일이 제대로 전달되었는지 확인
            if (photoFile != null && !photoFile.isEmpty()) {
                System.out.println("Uploaded file name: " + photoFile.getOriginalFilename());
            } else {
                System.out.println("No file uploaded or file is empty.");
            }

            // 사진 파일 저장 및 DTO 처리
            resumeService.saveResume(resumeDto, photoFile);
            return "redirect:/resume/list";

        } catch (Exception e) {
            e.printStackTrace();
            return "resume/resumeForm";
        }
    }

    @GetMapping("/list")
    public String listResumes(Model model) {
        model.addAttribute("resumes", resumeService.getAllResumes());
        return "resume/myResumes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        ResumeDto resumeDto = resumeService.getResumeById(id);
        model.addAttribute("resume", resumeDto);
        return "resume/editResumeForm";
    }

    @PostMapping("/edit/{id}")
    public String updateResume(@PathVariable("id") Long id,
                               @ModelAttribute ResumeDto resumeDto,
                               @RequestParam("photo") MultipartFile file) {
        // ResumeService의 updateResume 호출
        resumeService.updateResume(id, resumeDto, file);
        return "redirect:/resume/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteResume(@PathVariable("id") Long id) {
        resumeService.deleteResume(id);
        return "redirect:/resume/list";
    }
}