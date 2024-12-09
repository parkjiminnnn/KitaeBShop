package inhatc.cse.kitaebshop.resume.service;

import inhatc.cse.kitaebshop.resume.dto.ResumeDto;
import inhatc.cse.kitaebshop.resume.entity.Resume;
import inhatc.cse.kitaebshop.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public void saveResume(ResumeDto resumeDto, MultipartFile photoFile) {
        // DTO를 Entity로 변환
        Resume resume = new Resume();
        resume.setName(resumeDto.getName());
        resume.setEmail(resumeDto.getEmail());
        resume.setPhone(resumeDto.getPhone());
        resume.setExperience(resumeDto.getExperience());
        resume.setEducation(resumeDto.getEducation());
        resume.setSkills(resumeDto.getSkills());
        resume.setPhotoPath(resumeDto.getPhotoPath());

        // 사진 파일 처리
        if (photoFile != null && !photoFile.isEmpty()) {
            String photoPath = savePhotoFile(photoFile); // 사진 저장
            resume.setPhotoPath(photoPath); // 경로 설정
        }

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

    public void updateResume(Long id, ResumeDto resumeDto, MultipartFile photoFile) {
        // 이력서 업데이트
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid resume ID: " + id));
        resume.setName(resumeDto.getName());
        resume.setEmail(resumeDto.getEmail());
        resume.setPhone(resumeDto.getPhone());
        resume.setExperience(resumeDto.getExperience());
        resume.setEducation(resumeDto.getEducation());
        resume.setSkills(resumeDto.getSkills());
//        resume.setPhotoPath(resumeDto.getPhotoPath());

        // 사진 파일 처리
        if (photoFile != null && !photoFile.isEmpty()) {
            String photoPath = savePhotoFile(photoFile); // 새 파일 저장
            resume.setPhotoPath(photoPath);             // 새 경로 설정
        } else {
            resume.setPhotoPath(resume.getPhotoPath()); // 기존 경로 유지
        }

        resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        // 이력서 삭제
        resumeRepository.deleteById(id);
    }

    private String savePhotoFile(MultipartFile photoFile) {
        String uploadDir = "/Users/parkjimin/JavaSpring_ws/JiminShop/src/main/resources/static/uploads"; // 외부 경로
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 디렉토리가 없으면 생성
        }

        String fileName = photoFile.getOriginalFilename();
        String filePath = uploadDir + File.separator + fileName;

        try {
            photoFile.transferTo(new File(filePath)); // 파일 저장
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + e.getMessage(), e);
        }

        // URL 반환
        return fileName;
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
        dto.setPhotoPath(resume.getPhotoPath()); // 사진 경로 추가
        return dto;
    }
}