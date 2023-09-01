package com.nunam.service;
import java.util.TimerTask;

import com.nunam.exception.AllException;

public class DailyTaskUpdater extends TimerTask {
    VehicleStatisticsService vss;

    // Constructor to inject the VehicleStatisticsService
    public DailyTaskUpdater(VehicleStatisticsService vss) {
        this.vss = vss;
    }

    @Override
    public void run() {
        try {
            // When the task runs, it invokes the addVehicleStatistics method of the injected service
            vss.addVehicleStatistics();
        } catch (AllException e) {
            // Handle any exceptions that might occur during the task execution
            e.printStackTrace();
        }
    }
}
