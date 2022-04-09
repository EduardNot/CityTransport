package io.swagger.api;

import io.swagger.model.BusStop;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-07T09:02:41.194Z[GMT]")
@RestController
public class BusStopsApiController implements BusStopsApi {

    private static final Logger log = LoggerFactory.getLogger(BusStopsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BusStopsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BusStop> createBusStop(@Parameter(in = ParameterIn.DEFAULT, description = "A new bus stop object with name and coordanites.", schema=@Schema()) @Valid @RequestBody BusStop body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BusStop>(objectMapper.readValue("{\n  \"latitude\" : \"58.385787\",\n  \"name\" : \"Vene\",\n  \"id\" : 0,\n  \"longitude\" : \"26.726408\"\n}", BusStop.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BusStop>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BusStop>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<BusStop>> readBusStops(@Min(1) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "The numbers of items to return." ,schema=@Schema(allowableValues={  }, minimum="1", maximum="50"
, defaultValue="20")) @Valid @RequestParam(value = "maxResults", required = false, defaultValue="20") Integer maxResults,@Parameter(in = ParameterIn.QUERY, description = "Optional parameter to filter bus stops by partial name." ,schema=@Schema()) @Valid @RequestParam(value = "name", required = false) String name) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<BusStop>>(objectMapper.readValue("[ {\n  \"latitude\" : \"58.385787\",\n  \"name\" : \"Vene\",\n  \"id\" : 0,\n  \"longitude\" : \"26.726408\"\n}, {\n  \"latitude\" : \"58.385787\",\n  \"name\" : \"Vene\",\n  \"id\" : 0,\n  \"longitude\" : \"26.726408\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<BusStop>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<BusStop>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
