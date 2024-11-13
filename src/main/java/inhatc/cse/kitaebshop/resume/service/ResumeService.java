package inhatc.cse.kitaebshop.resume.service;

import inhatc.cse.kitaebshop.resume.constant.ResumeStatus;
import inhatc.cse.kitaebshop.resume.dto.ResumeDto;
import inhatc.cse.kitaebshop.resume.entity.Resume;
import inhatc.cse.kitaebshop.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Transactional
    public Resume saveResume(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setName(resumeDto.getName());
        resume.setEmail(resumeDto.getEmail());
        resume.setPhone(resumeDto.getPhone());
        resume.setExperience(resumeDto.getExperience());
        resume.setEducation(resumeDto.getEducation());
        resume.setSkills(resumeDto.getSkills());
        resume.setStatus(ResumeStatus.REGISTERED);  // 기본 상태로 등록
        return resumeRepository.save(resume);
    }
}
