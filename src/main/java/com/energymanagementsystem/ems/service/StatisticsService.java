package com.energymanagementsystem.ems.service;

import com.energymanagementsystem.ems.model.Statistics;
import com.energymanagementsystem.ems.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getStatisticsByUserId(int id){
        List<Statistics> statistics = new ArrayList<>();
        statisticsRepository.findAll().forEach((s -> { if(s.getUser().getId() == id) statistics.add(s); }));
        return statistics;
    }
}
