package de.chen.applicantDB.repo;

import de.chen.applicantDB.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ApplicantRepo extends JpaRepository<Applicant, Long> {

    /**
     * Find the email address of an applicant
     */
    List<Applicant> findByEmail(String email);

    @Override
    Optional<Applicant> findById(Long id);
}
