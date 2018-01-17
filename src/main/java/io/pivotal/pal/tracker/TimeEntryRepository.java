package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(long id);
    public TimeEntry update(TimeEntry timeEntry);
    // added 01/17
    public TimeEntry update(long lng, TimeEntry timeEntry);

    public void delete(long id);
    public List<TimeEntry> list();
}
