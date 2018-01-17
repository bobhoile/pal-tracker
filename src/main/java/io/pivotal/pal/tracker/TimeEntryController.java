package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry){
        TimeEntry timeEntry1 = timeEntryRepository.create(timeEntry);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<TimeEntry>(timeEntry1, HttpStatus.CREATED);
        return responseEntity;
    }

    // added 01/17
    @PutMapping("/{id}")
    public  ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        ResponseEntity<TimeEntry> responseEntity;
        TimeEntry timeEntry1 = timeEntryRepository.update(id, timeEntry);
        if(timeEntry1==null) {
            responseEntity = new ResponseEntity<TimeEntry>(timeEntry1, HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity<TimeEntry>(timeEntry1, HttpStatus.OK);
        }

        return responseEntity;
    }
    @GetMapping("/{id}")
    public  ResponseEntity<TimeEntry>  read(@PathVariable Long id){
        ResponseEntity<TimeEntry> responseEntity;
        TimeEntry timeEntry1 = timeEntryRepository.find(id);
            if(timeEntry1==null) {
                responseEntity  = new ResponseEntity<TimeEntry>(timeEntry1, HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<TimeEntry>(timeEntry1, HttpStatus.OK);
            }

            return responseEntity;
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<TimeEntry>  delete(@PathVariable Long id){
            timeEntryRepository.delete(id);
            ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<TimeEntry>(new TimeEntry(), HttpStatus.NO_CONTENT);
            return responseEntity;
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list(){
            List<TimeEntry> timeEntryList = timeEntryRepository.list();
            ResponseEntity<List<TimeEntry>>  responseEntityList = new ResponseEntity<List<TimeEntry>>(timeEntryList, HttpStatus.OK);
            return responseEntityList;
    }

}
