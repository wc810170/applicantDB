package de.chen.applicantDB.controller;

import de.chen.applicantDB.entity.Applicant;
import de.chen.applicantDB.repo.ApplicantRepo;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
     * If an applicant already exists in the database, throw exception.
     * This is done by checking, whether the email address already exists.
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
    public @ResponseBody String addNewApplicant(@RequestParam String firstName, @RequestParam String lastName,
                                                @RequestParam String email, @RequestParam long phoneNumber,
                                                @RequestParam String desiredPosition, @RequestParam String jobStatus,
                                                @RequestParam long desiredSalary, @RequestParam String applicationStatus) throws Exception {

        if(!applicantRepo.findByEmail(email).isEmpty()) {
            throw new Exception("Email/Bewerber existiert bereits.");
        }

        Applicant n = new Applicant();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setEmail(email);
        n.setPhoneNumber(phoneNumber);
        n.setDesiredPosition(desiredPosition);
        n.setJobStatus(jobStatus);
        n.setDesiredSalary(desiredSalary);
        n.setApplicationStatus(applicationStatus);
        applicantRepo.save(n);
        return "Bewerber hinzugefügt.";

    }

    /**
     * Updates existing applicant's information, by finding them in the first place with findById()
     * @param applicant Existing applicant
     * @return Existing applicant with newly edited information.
     */
    @PutMapping(path = "/update")
    public String updateApplicant(Applicant applicant, long id) {

        Applicant existingApplicant = applicantRepo.findById(id).orElse(null);
        existingApplicant.setFirstName(applicant.getFirstName());
        existingApplicant.setLastName((applicant.getLastName()));
        existingApplicant.setEmail(applicant.getEmail());
        existingApplicant.setPhoneNumber(applicant.getPhoneNumber());
        existingApplicant.setDesiredPosition(applicant.getDesiredPosition());
        existingApplicant.setJobStatus(applicant.getJobStatus());
        existingApplicant.setDesiredSalary(applicant.getDesiredSalary());
        existingApplicant.setApplicationStatus(applicant.getApplicationStatus());
        applicantRepo.save(existingApplicant);
        return "Bewerberdaten geändert.";

    }

    /**
     * Delete the applicant by giving the Id.
     * @param id Id of the "to be deleted" applicant.
     * @return Delete conformation.
     */
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteApplicant(@RequestParam long id) {
        applicantRepo.deleteById(id);
        return "Bewerber entfernt.";
    }

}
