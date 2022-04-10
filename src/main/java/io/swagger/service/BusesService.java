package io.swagger.service;

import io.swagger.model.Bus;
import io.swagger.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BusesService {

    List<Bus> busList;

    public BusesService(List<Bus> busList) {
        this.busList = busList;
        this.busList.addAll(Arrays.asList(
                new Bus("111AAA", 0),
                new Bus("543TER", 0),
                new Bus("976MNB", 0)
        ));
    }

    // Add Bus to the list
    public ResponseEntity<Object> add(Bus body) {
        // Check if body content is valid, if not code 400
        if (body.getLicenceNumber() == null || body.getBusLineId() == null) {
            return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
        }
        // Iter through list and check if there is a bus with the same licence number as in request body
        for (Bus bus : busList) {
            if (bus.getLicenceNumber().equals(body.getLicenceNumber())) {
                return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
            }
        }
        // Adding new bus to the list and retuning code 200
        Bus newBus = new Bus(body.getLicenceNumber(), body.getBusLineId());
        this.busList.add(newBus);
        return new ResponseEntity<>(newBus, HttpStatus.OK);
    }

    // Delete a bus by its ID
    public ResponseEntity<Object> deleteById(Integer busId) {
        //Iter through bus list and check for same bus ID
        for (Bus bus : busList) {
            if (bus.getId().equals(busId)) {
                //If found delete it and return code 204
                this.busList.remove(bus);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        //Else return code 404
        return new ResponseEntity<>(new ErrorMessage("Not Found", 404, "Bus with given ID not found error."), HttpStatus.NOT_FOUND);
    }

    //Returning bus list
    public ResponseEntity<List<Bus>> getAll() {
        return new ResponseEntity<>(this.busList, HttpStatus.OK);
    }

    //Update a bus object with a new request body
    public ResponseEntity<Object> update(Integer busId, Bus body) {
        // Check if body content is in valid form
        if (body.getLicenceNumber() == null || body.getBusLineId() == null) {
            return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
        }

        int posOfFoundBus = -1;
        //Iter through bus list and if it finds a bus with given ID, saves that object position
        for (Bus bus : busList) {
            if (bus.getId().equals(busId)) {
                posOfFoundBus = this.busList.indexOf(bus);
            } else if (bus.getLicenceNumber().equals(body.getLicenceNumber())) { //checks if there is a bus with same licence number
                return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
            }
        }
        //If found a given bus ID, updates it
        if (posOfFoundBus != -1) {
            Bus bus = this.busList.get(posOfFoundBus);
            bus.setLicenceNumber(body.getLicenceNumber());
            bus.setBusLineId(body.getBusLineId());
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
        //Else return code 400
        return new ResponseEntity<>(new ErrorMessage("Not Found", 404, "Bus with given ID not found error."), HttpStatus.NOT_FOUND);
    }
}
