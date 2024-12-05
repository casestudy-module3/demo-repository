package com.example.casestudy.service;

import java.util.Map;

public interface IStatisticService<T> {
    T getStatistic();

    Map<String, Integer> getStatisticsMap();


}
