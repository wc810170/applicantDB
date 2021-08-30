package de.chen.applicantDB.repo;

import de.chen.applicantDB.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
}
