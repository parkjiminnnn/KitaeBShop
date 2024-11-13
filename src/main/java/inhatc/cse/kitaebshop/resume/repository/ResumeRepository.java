package inhatc.cse.kitaebshop.resume.repository;

import inhatc.cse.kitaebshop.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
