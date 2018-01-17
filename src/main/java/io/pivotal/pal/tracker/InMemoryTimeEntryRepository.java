package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    HashMap<Long, TimeEntry> repo = new HashMap<Long, TimeEntry>();

    private long id = 0;
    @Override
    public TimeEntry create(TimeEntry timeEntry){
        ++id;
       /*
        if(timeEntry.getId()==0) {
            timeEntry.setId(repo.size() + 1);
        }*/
        timeEntry.setId(id);
        repo.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return repo.get(id);
    }

    @Override
    public TimeEntry update(TimeEntry timeEntry) {
        repo.put(timeEntry.getId(),timeEntry);
        return repo.get(timeEntry.getId());
    }

    @Override
    public TimeEntry update(long lng, TimeEntry timeEntry) {
        timeEntry.setId(lng);
        repo.put(lng,timeEntry);
        return repo.get(lng);
    }

    @Override
    public void delete(long id) {
        repo.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
         List<TimeEntry> repoList = new ArrayList(repo.values());
         return repoList;
    }
}
