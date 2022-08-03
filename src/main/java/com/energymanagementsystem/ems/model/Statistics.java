package com.energymanagementsystem.ems.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "statistics")
@Setter
@Getter
public class Statistics {

    @Id
    @Column(name = "statistics_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long voltage;
    private Long ampere;
    private String catchTime;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

}
