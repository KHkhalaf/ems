package com.energymanagementsystem.ems.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "dataset")
@Setter
@Getter
public class dataset {

    @Id
    @Column(name = "dataset_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long voltage;
    private Long ampere;
    private String catchTime;
    private int userId;

}
