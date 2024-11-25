package inhatc.cse.kitaebshop.resume.service;

import inhatc.cse.kitaebshop.resume.dto.ResumeDto;
import inhatc.cse.kitaebshop.resume.entity.Resume;
import inhatc.cse.kitaebshop.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public void saveResume(ResumeDto resumeDto) {
        // DTO를 Entity로 변환
        Resume resume = new Resume();
        resume.setName(resumeDto.getName());
        resume.setEmail(resumeDto.getEmail());
        resume.setPhone(resumeDto.getPhone());
        resume.setExperience(resumeDto.getExperience());
        resume.setEducation(resumeDto.getEducation());
        resume.setSkills(resumeDto.getSkills());

        // 데이터베이스에 저장
        resumeRepository.save(resume);
    }

    public List<ResumeDto> getAllResumes() {
        // 모든 이력서 조회 후 DTO로 변환
        return resumeRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ResumeDto getResumeById(Long id) {
        // ID로 특정 이력서 조회 후 DTO로 변환
        Optional<Resume> resume = resumeRepository.findById(id);
        return resume.map(this::convertToDto).orElse(null);
    }

    public void updateResume(Long id, ResumeDto resumeDto) {
        // 이력서 업데이트
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid resume ID:" + id));
        resume.setId(resume.getId());  // id 설정 추가
        resume.setName(resumeDto.getName());
        resume.setEmail(resumeDto.getEmail());
        resume.setPhone(resumeDto.getPhone());
        resume.setExperience(resumeDto.getExperience());
        resume.setEducation(resumeDto.getEducation());
        resume.setSkills(resumeDto.getSkills());
        resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        // 이력서 삭제
        resumeRepository.deleteById(id);
    }

    private ResumeDto convertToDto(Resume resume) {
        // Resume 엔티티를 ResumeDto로 변환
        ResumeDto dto = new ResumeDto();
        dto.setId(resume.getId());
        dto.setName(resume.getName());
        dto.setEmail(resume.getEmail());
        dto.setPhone(resume.getPhone());
        dto.setExperience(resume.getExperience());
        dto.setEducation(resume.getEducation());
        dto.setSkills(resume.getSkills());
        return dto;
    }
}