package io.swagger.controller;

import io.swagger.model.Bus;
import io.swagger.model.ErrorMessage;
import io.swagger.service.BusesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class BusesApiController {

    @Autowired
    private BusesService busesService;


    @Operation(summary = "Insert a new bus.", description = "Creates a new bus bus object and save it into database.", tags = {"BusMangagment"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Returned a new bus object with fullfilled id field from database.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bus.class))),

            @ApiResponse(
                    responseCode = "400", description = "Invalid request body content.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @RequestMapping(value = "/buses",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> createBus(@Parameter(in = ParameterIn.DEFAULT, description = "Information about new bus.", schema = @Schema()) @Valid @RequestBody Bus body) {
        return busesService.add(body);
    }

    @Operation(summary = "Deletes a bus.", description = "Searches for a specific bus with given id and deletes it from database.", tags = {"BusMangagment"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204", description = "Bus with given ID deleted successfully."),

            @ApiResponse(
                    responseCode = "404", description = "Bus with given ID not found error.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @RequestMapping(value = "/buses/{busId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBus(@Parameter(in = ParameterIn.PATH, description = "Common ID parameter of bus.", required = true, schema = @Schema()) @PathVariable("busId") Integer busId) {
        return busesService.deleteById(busId);
    }

    @Operation(summary = "Query a list of buses.", description = "Collects all the buses in databases and returnes them as a list.", tags = {"BusMangagment"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Returned a list of buses.",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Bus.class))))})
    @RequestMapping(value = "/buses",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Bus>> readBuses() {
        return busesService.getAll();
    }

    @Operation(summary = "Updates bus information.", description = "Searches for a specific bus with given id and updates its data.", tags = {"BusMangagment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a updated bus object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bus.class))),

            @ApiResponse(responseCode = "400", description = "Invalid request body content.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),

            @ApiResponse(responseCode = "404", description = "Bus with given ID not found error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @RequestMapping(value = "/buses/{busId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBus(@Parameter(in = ParameterIn.PATH, description = "Common ID parameter of bus.", required = true, schema = @Schema()) @PathVariable("busId") Integer busId, @Parameter(in = ParameterIn.DEFAULT, description = "Information about bus.", required = true, schema = @Schema()) @Valid @RequestBody Bus body) {
        return busesService.update(busId, body);
    }

}
