package io.swagger.api;

import io.swagger.model.BusStop;
import io.swagger.service.BusStopsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class BusStopsApiController {

    @Autowired
    private BusStopsService busStopsService;

    @Operation(summary = "Create a bus stop", description = "Creates a bus stop with given name and location and stores it in the database.", tags = {"LineMangagment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned bus stop object with fullfilled id field from database.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BusStop.class)))})
    @RequestMapping(value = "/bus-stops",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<BusStop> createBusStop(@Parameter(in = ParameterIn.DEFAULT, description = "A new bus stop object with name and coordanites.", schema = @Schema()) @Valid @RequestBody BusStop body) {
        return busStopsService.add(body);
    }

    @Operation(summary = "Gets all bus stops with given filters.", description = "Queries all bus stops with given optional name and limit filters.", tags = {"LineMangagment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a list of bus stops which fullfill query params.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BusStop.class))))})
    @RequestMapping(value = "/bus-stops",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<BusStop>> readBusStops(
            @Min(1) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "The numbers of items to return.", schema = @Schema(allowableValues = {}, minimum = "1", maximum = "50", defaultValue = "20"))
            @Valid @RequestParam(value = "maxResults", required = false, defaultValue = "20") Integer maxResults,
            @Parameter(in = ParameterIn.QUERY, description = "Optional parameter to filter bus stops by partial name.", schema = @Schema())
            @Valid @RequestParam(value = "name", required = false) String name) {
        return busStopsService.getAll(maxResults, name);
    }

}
