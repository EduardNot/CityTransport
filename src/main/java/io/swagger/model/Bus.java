package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Bus
 */
@Validated

public class Bus {
    @JsonProperty("id")
    private Integer id;

    private static Integer autoIncrement = 0;

    @JsonProperty("licenceNumber")
    private String licenceNumber = null;

    @JsonProperty("busLineId")
    private Integer busLineId = null;

    public Bus() {
    }

    public Bus(String licenceNumber, Integer busLineId) {
        this.id = autoIncrement;
        autoIncrement += 1;
        this.licenceNumber = licenceNumber;
        this.busLineId = busLineId;
    }

    /**
     * Id given by database, undefined in request body.
     *
     * @return id
     **/
    @Schema(example = "0", description = "Id given by database, undefined in request body.")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus licenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
        return this;
    }

    /**
     * Licence plate number
     *
     * @return licenceNumber
     **/
    @Schema(example = "460TNP", required = true, description = "Licence plate number")
    @NotNull

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Bus busLineId(Integer busLineId) {
        this.busLineId = busLineId;
        return this;
    }

    /**
     * Bus line which bus is serving.
     *
     * @return busLineId
     **/
    @Schema(example = "0", description = "Bus line which bus is serving.")

    public Integer getBusLineId() {
        return busLineId;
    }

    public void setBusLineId(Integer busLineId) {
        this.busLineId = busLineId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bus bus = (Bus) o;
        return Objects.equals(this.id, bus.id) &&
                Objects.equals(this.licenceNumber, bus.licenceNumber) &&
                Objects.equals(this.busLineId, bus.busLineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licenceNumber, busLineId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bus {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    licenceNumber: ").append(toIndentedString(licenceNumber)).append("\n");
        sb.append("    busLineId: ").append(toIndentedString(busLineId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
