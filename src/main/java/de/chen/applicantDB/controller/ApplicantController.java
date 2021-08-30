package de.chen.applicantDB.controller;

import de.chen.applicantDB.entity.Applicant;
import de.chen.applicantDB.repo.ApplicantRepo;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/Applicant")
public class ApplicantController {

    private final ApplicantRepo applicantRepo;

    public ApplicantController(ApplicantRepo applicantRepo) {

        this.applicantRepo = applicantRepo;

    }

    @GetMapping(path = "/all")
    public List<Applicant> getAll() {

        return applicantRepo.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody Applicant addNewApplicant(@RequestParam String firstName, @RequestParam String lastName,
                                                @RequestParam String email, @RequestParam long phoneNumber,
                                                @RequestParam String desiredPosition, @RequestParam String jobStatus,
                                                @RequestParam long desiredSalary, @RequestParam String applicationStatus) {

        Applicant n = new Applicant();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setEmail(email);
        n.setPhoneNumber(phoneNumber);
        n.setDesiredPosition(desiredPosition);
        n.setJobStatus(jobStatus);
        n.setDesiredSalary(desiredSalary);
        n.setApplicationStatus(applicationStatus);
        return applicantRepo.save(n);

    }

    @PostMapping(path = "/update")
    public @ResponseBody Applicant updateApplicant(Applicant applicant) {

        Applicant existingApplicant = applicantRepo.findById(applicant.getId()).orElse(null);
        assert existingApplicant != null;
        existingApplicant.setFirstName(applicant.getFirstName());
        existingApplicant.setLastName((applicant.getLastName()));
        existingApplicant.setEmail(applicant.getEmail());
        existingApplicant.setPhoneNumber(applicant.getPhoneNumber());
        existingApplicant.setDesiredPosition(applicant.getDesiredPosition());
        existingApplicant.setJobStatus(applicant.getJobStatus());
        existingApplicant.setDesiredSalary(applicant.getDesiredSalary());
        existingApplicant.setApplicationStatus(applicant.getApplicationStatus());
        return applicantRepo.save(existingApplicant);

    }

}
