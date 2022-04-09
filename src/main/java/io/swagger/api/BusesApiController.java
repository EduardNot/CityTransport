package io.swagger.api;

import io.swagger.model.Bus;
import io.swagger.model.ErrorMessage;
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
public class BusesApiController implements BusesApi {

    private static final Logger log = LoggerFactory.getLogger(BusesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BusesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Bus> createBus(@Parameter(in = ParameterIn.DEFAULT, description = "Information about new bus.", schema=@Schema()) @Valid @RequestBody Bus body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Bus>(objectMapper.readValue("{\n  \"licenceNumber\" : \"460TNP\",\n  \"id\" : 0,\n  \"busLineId\" : 0\n}", Bus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Bus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Bus>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteBus(@Parameter(in = ParameterIn.PATH, description = "Common ID parameter of bus.", required=true, schema=@Schema()) @PathVariable("busId") Integer busId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Bus>> readBuses() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Bus>>(objectMapper.readValue("[ {\n  \"licenceNumber\" : \"460TNP\",\n  \"id\" : 0,\n  \"busLineId\" : 0\n}, {\n  \"licenceNumber\" : \"460TNP\",\n  \"id\" : 0,\n  \"busLineId\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Bus>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Bus>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Bus> updateBus(@Parameter(in = ParameterIn.PATH, description = "Common ID parameter of bus.", required=true, schema=@Schema()) @PathVariable("busId") Integer busId,@Parameter(in = ParameterIn.DEFAULT, description = "Information about bus.", required=true, schema=@Schema()) @Valid @RequestBody Bus body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Bus>(objectMapper.readValue("{\n  \"licenceNumber\" : \"460TNP\",\n  \"id\" : 0,\n  \"busLineId\" : 0\n}", Bus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Bus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Bus>(HttpStatus.NOT_IMPLEMENTED);
    }

}
