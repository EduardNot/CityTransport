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

    public ResponseEntity<Object> add(Bus body) {
        if (body.getLicenceNumber() == null || body.getBusLineId() == null) {
            return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
        }
        for (Bus bus : busList) {
            if (bus.getLicenceNumber().equals(body.getLicenceNumber())) {
                return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
            }
        }
        Bus newBus = new Bus(body.getLicenceNumber(), body.getBusLineId());
        this.busList.add(newBus);
        return new ResponseEntity<>(newBus, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteById(Integer busId) {
        for (Bus bus : busList) {
            if (bus.getId().equals(busId)) {
                this.busList.remove(bus);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(new ErrorMessage("Not Found", 404, "Bus with given ID not found error."), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Bus>> getAll() {
        return new ResponseEntity<>(this.busList, HttpStatus.OK);
    }

    public ResponseEntity<Object> update(Integer busId, Bus body) {
        if (body.getLicenceNumber() == null || body.getBusLineId() == null) {
            return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
        }
        int posOfFoundBus = -1;
        for (Bus bus : busList) {
            if (bus.getLicenceNumber().equals(body.getLicenceNumber())) {
                return new ResponseEntity<>(new ErrorMessage("Bad request.", 400, "Invalid request body content."), HttpStatus.BAD_REQUEST);
            }
            if (bus.getId().equals(busId)) {
                posOfFoundBus = this.busList.indexOf(bus);
            }
        }
        if (posOfFoundBus != -1) {
            Bus bus = this.busList.get(posOfFoundBus);
            bus.setLicenceNumber(body.getLicenceNumber());
            bus.setBusLineId(body.getBusLineId());
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorMessage("Not Found", 404, "Bus with given ID not found error."), HttpStatus.NOT_FOUND);
    }
}
