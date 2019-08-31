package com.ibm.batch.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by karim on 28/08/2019.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "SALARY")
    private Long salary;

}
