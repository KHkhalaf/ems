package com.energymanagementsystem.ems.dto;

import com.energymanagementsystem.ems.model.Statistics;

import java.util.ArrayList;

public class StatisticsDto {
    public String catchDate;
    public Integer ampere;
    public Integer voltage;

//    public StatisticsDto(ArrayList<Statistics> statistics) {
//        for (Statistics s: statistics) {
//            catchDate.add(s.getCatchTime());
//            ampere.add(s.getAmpere());
//            voltage.add(s.getVoltage());
//        }
//    }
}
