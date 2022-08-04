package com.energymanagementsystem.ems.service;

import com.energymanagementsystem.ems.model.Statistics;
import com.energymanagementsystem.ems.model.dataset;
import com.energymanagementsystem.ems.repository.DatasetRepository;
import com.energymanagementsystem.ems.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private DatasetRepository datasetRepository;

    public ArrayList<dataset> getStatisticsByUserId(int id){
        ArrayList<dataset> statistics = new ArrayList<>();
        datasetRepository.findAll().forEach((s -> { if(s.getUserId() == id) statistics.add(s); }));
        return statistics;
    }
}
