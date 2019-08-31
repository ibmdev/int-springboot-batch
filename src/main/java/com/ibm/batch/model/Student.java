package com.ibm.batch.model;

import javax.persistence.*;

/**
 * Created by karim on 26/08/2019.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name = "FIRST_NAME")
    private String firstname;
    // @Column(name = "LAST_NAME")
    private String lastname;
}
