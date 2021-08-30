package de.chen.applicantDB.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotBlank
    @NotNull
    private String firstName;

    @NotEmpty
    @NotBlank
    @NotNull
    private String lastName;

    @NotEmpty
    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    @NotNull
    private long phoneNumber;

    @NotEmpty
    @NotBlank
    @NotNull
    private String desiredPosition;

    @NotEmpty
    @NotBlank
    @NotNull
    private String jobStatus;

    @NotEmpty
    @NotBlank
    @NotNull
    private long desiredSalary;

    @NotEmpty
    @NotBlank
    @NotNull
    private String applicationStatus;

    public long getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(String desiredPosition) {
        this.desiredPosition = desiredPosition;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public long getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(long desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

}
