package de.chen.applicantDB.controller;

import de.chen.applicantDB.object.Applicant;
import de.chen.applicantDB.repo.ApplicantRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Applicant")
public class ApplicantController {

    private ApplicantRepo applicantRepo;

    public ApplicantController(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    @GetMapping("")
    public List<Applicant> showAll() {
        return applicantRepo.findAll();
    }
}
