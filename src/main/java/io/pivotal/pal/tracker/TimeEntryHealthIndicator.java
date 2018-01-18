package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private static final int MAX_TIME_ENTRIES = 5;
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryHealthIndicator(TimeEntryRepository teRepo) {
        this.timeEntryRepository = teRepo;
    }


    @Override
    public Health health() {
        Health.Builder healthBuilder = new Health.Builder();
        if (timeEntryRepository.list().size() < MAX_TIME_ENTRIES) {
            healthBuilder.up();
        } else {
            healthBuilder.down();
        }
        return healthBuilder.build();
    }
}
