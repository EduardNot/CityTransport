package io.swagger.service;

import io.swagger.model.BusLine;
import io.swagger.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BusLineService {

    @Autowired
    private BusStopsService busStopsService;

    private List<BusLine> busLines;

    public BusLineService() {
        this.busLines = new ArrayList<>();
        this.busLines.add(new BusLine("Kummeli - Ringtee", Collections.singletonList(0)));
    }

    //Add a bus line to list
    public ResponseEntity<Object> add(BusLine body) {
        List<Integer> busStopIds = body.getBusStopIds();
        //Check if given bus stop ids are in database
        if (!Collections.disjoint(busStopIds, this.busStopsService.getBusStopIds())) {
            BusLine busLine = new BusLine(body.getName(), body.getBusStopIds());
            this.busLines.add(busLine);
            return new ResponseEntity<>(busLine, HttpStatus.OK);
        }
        // One of the given bus stops does not exist, return code 400
        return new ResponseEntity<>(new ErrorMessage("Bad Request", 400, "One of the given bus stops do not exist."), HttpStatus.BAD_REQUEST);
    }

    //Get bus lines with filters
    public ResponseEntity<List<BusLine>> getBusLines(Integer maxResults, String name, Integer busStopId) {
        List<BusLine> returnList = new ArrayList<>();
        // Case when name and bus stops are given
        if (name != null && busStopId != null) {
            for (BusLine busLine : busLines) {
                if (busLine.getName().toLowerCase().contains(name.toLowerCase()) && busLine.getBusStopIds().contains(busStopId)) {
                    returnList.add(busLine);
                }
                if (returnList.size() >= maxResults) {
                    break;
                }
            }
            return new ResponseEntity<>(returnList, HttpStatus.OK);
        } else if (name != null) { // Case when only name is given
            for (BusLine busLine : busLines) {
                if (busLine.getName().toLowerCase().contains(name.toLowerCase())) {
                    returnList.add(busLine);
                }
                if (returnList.size() >= maxResults) {
                    break;
                }
            }
            return new ResponseEntity<>(returnList, HttpStatus.OK);
        } else if (busStopId != null) { // Case when only bus stop ids are given
            for (BusLine busLine : busLines) {
                if (busLine.getBusStopIds().contains(busStopId)) {
                    returnList.add(busLine);
                }
                if (returnList.size() >= maxResults) {
                    break;
                }
            }
            return new ResponseEntity<>(returnList, HttpStatus.OK);
        }
        // Case when name or bus stop ids are not given
        for (BusLine busLine : busLines) {
            returnList.add(busLine);
            if (returnList.size() >= maxResults) {
                break;
            }
        }
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }
}
