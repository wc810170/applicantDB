package de.chen.applicantDB.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private long phoneNumber;

    private String desiredPosition;

    private String jobStatus;

    private long desiredSalary;

    private String applicationStatus;
}
