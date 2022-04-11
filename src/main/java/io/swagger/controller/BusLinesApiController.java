package io.swagger.controller;

import io.swagger.model.BusLine;
import io.swagger.model.ErrorMessage;
import io.swagger.service.BusLineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class BusLinesApiController {

    @Autowired
    private BusLineService busLineService;

    @Operation(summary = "Create a bus line", description = "Creates a bus line with given name and bus stops.", tags = {"LineMangagment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a bus line dto with fullfilled id field", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BusLine.class))),

            @ApiResponse(responseCode = "400", description = "One of the given bus stops do not exist.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @RequestMapping(value = "/bus-lines",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> createBusLine(@Parameter(in = ParameterIn.DEFAULT, description = "A new bus line object with name and list of bus stops.", schema = @Schema()) @Valid @RequestBody BusLine body) {
        return busLineService.add(body);
    }

    @Operation(summary = "Get all bus lines with given filters.", description = "Queries all bus lines with given optional name, busStopId and limit filters.", tags = {"LineMangagment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a list of bus stops which fullfill query params.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BusLine.class))))})
    @RequestMapping(value = "/bus-lines",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<BusLine>> readBusLines(
            @Min(1) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "The numbers of items to return.", schema = @Schema(allowableValues = {}, minimum = "1", maximum = "50"
            , defaultValue = "20"))
            @Valid @RequestParam(value = "maxResults", required = false, defaultValue = "20") Integer maxResults, @Parameter(in = ParameterIn.QUERY, description = "Optional parameter to filter bus lines by partial name.", schema = @Schema()) @Valid @RequestParam(value = "name", required = false) String name,
            @Parameter(in = ParameterIn.QUERY, description = "Optional parameter to filter bus lines by bus stops.", schema = @Schema()) @Valid @RequestParam(value = "busStopId", required = false) Integer busStopId) {
        return busLineService.getBusLines(maxResults, name, busStopId);
    }

}
