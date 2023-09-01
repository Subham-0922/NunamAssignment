package com.nunam;
import java.util.Calendar;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nunam.service.DailyTaskUpdater;
import com.nunam.service.VehicleStatisticsService;

@SpringBootApplication
public class NunamTestApplication implements CommandLineRunner {
    @Autowired
    VehicleStatisticsService vehicleStatisticsService;

    public static void main(String[] args) {
        SpringApplication.run(NunamTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Timer timer = new Timer();

        // Get the current time
        Calendar now = Calendar.getInstance();

        // Calculate the time until 23:59
        int delay = (23 - now.get(Calendar.HOUR_OF_DAY)) * 3600 * 1000; // Hours
        delay += (59 - now.get(Calendar.MINUTE)) * 60 * 1000; // Minutes

        // Schedule the task to run at 23:59 and repeat every 24 hours
        timer.scheduleAtFixedRate(new DailyTaskUpdater(vehicleStatisticsService), delay, 24 * 60 * 60 * 1000);
    }
}
