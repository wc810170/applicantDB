package de.chen.applicantDB.controller;

import de.chen.applicantDB.entity.Applicant;
import de.chen.applicantDB.repo.ApplicantRepo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This method contains functions to show, create and modify applicant data.
 * @Author Weihao Chen
 */
@RestController
@RequestMapping("/Applicant")
public class ApplicantController {

    private final ApplicantRepo applicantRepo;

    public ApplicantController(ApplicantRepo applicantRepo) {

        this.applicantRepo = applicantRepo;

    }

    /**
     * Lists all data in the database.
     * @return Every entry in the database in json format.
     */
    @GetMapping(path = "/all")
    public List<Applicant> getAll() {

        return applicantRepo.findAll();
    }

    /**
     * Creates a new applicant entry in the database.
     * @param firstName Vorname
     * @param lastName  Nachname
     * @param email E-Mail-Adresse
     * @param phoneNumber Telefonnummer
     * @param desiredPosition gewünschte Position
     * @param jobStatus Beschäftigungsart (Vollzeit/Teilzeit/Azubi/Werkstudent)
     * @param desiredSalary Gehaltswunsch (pro Jahr, €)
     * @param applicationStatus Status im Bewerbungsprozess (Neu/Erstgespräch/Zweitgespräch/Angebot-Gemacht/Eingestellt)
     * @return A newly created applicant, saved in the database.
     */
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

    /**
     * Updates existing applicant's information, by finding them in the first place with findById()
     * @param applicant
     * @return Existing applicant with newly edited information.
     */
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
