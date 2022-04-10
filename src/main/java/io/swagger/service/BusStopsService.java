package io.swagger.service;

import io.swagger.model.BusStop;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BusStopsService {

    private List<BusStop> busStops;

    public BusStopsService() {
        this.busStops = new ArrayList<>();
        this.busStops.add(new BusStop("Vene", "58.385787", "26.726408"));
        sort();
    }

    //Sort bus stop list by ID
    public void sort() {
        this.busStops.sort(Comparator.comparing(BusStop::getId));
    }

    //Adding a bus stop to the list
    public ResponseEntity<BusStop> add(BusStop body) {
        BusStop busStop = new BusStop(body.getName(), body.getLatitude(), body.getLongitude());
        this.busStops.add(busStop);
        sort();
        return new ResponseEntity<>(busStop, HttpStatus.OK);
    }

    //Get maxResults amount of bus stops
    //If name is given filter by it
    public ResponseEntity<List<BusStop>> getAll(Integer maxResults, String name) {
        //Checking maxResults boundaries
        if (maxResults < 1) {
            maxResults = 1;
        } else if (maxResults > 50) {
            maxResults = 50;
        }

        List<BusStop> returnList = new ArrayList<>();
        if (name != null) { //If name is given
            for (BusStop busStop : busStops) {
                if (busStop.getName().contains(name)) {
                    returnList.add(busStop);
                }
                if (returnList.size() >= maxResults) {
                    return new ResponseEntity<>(returnList, HttpStatus.OK);
                }
            }
        } else { //If name is not given
            for (BusStop busStop : busStops) {
                returnList.add(busStop);
                if (returnList.size() >= maxResults) {
                    break;
                }
            }
        }
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }
}
