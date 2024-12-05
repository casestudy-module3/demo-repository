package com.example.casestudy.service.implement;

import com.example.casestudy.model.Statistic;
import com.example.casestudy.repo.StatisticRepo;
import com.example.casestudy.service.IStatisticService;

import java.util.Map;

public class StatisticService implements IStatisticService {
    private StatisticRepo statisticRepo =new StatisticRepo();
    public Statistic getStatistic() {
         return statisticRepo.getStatistics();
    }
    public Map<String, Integer> getStatisticsMap() {
        return statisticRepo.getStatisticsMap();
    }
}
