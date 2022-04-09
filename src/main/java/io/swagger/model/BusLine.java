package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BusLine
 */
@Validated


public class BusLine {
    @JsonProperty("id")
    private Integer id = null;

    private static Integer autoIncrement = 0;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("busStopIds")
    @Valid
    private List<Integer> busStopIds = new ArrayList<Integer>();

    public BusLine() {
    }

    public BusLine(String name, List<Integer> busStopIds) {
        this.id = autoIncrement;
        autoIncrement += 1;
        this.name = name;
        this.busStopIds = busStopIds;
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

    public BusLine name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Bus line name
     *
     * @return name
     **/
    @Schema(example = "Kummeli - Ringtee", required = true, description = "Bus line name")
    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BusLine busStopIds(List<Integer> busStopIds) {
        this.busStopIds = busStopIds;
        return this;
    }

    public BusLine addBusStopIdsItem(Integer busStopIdsItem) {
        this.busStopIds.add(busStopIdsItem);
        return this;
    }

    /**
     * Ordered bus stop ids from line start to finish
     *
     * @return busStopIds
     **/
    @Schema(required = true, description = "Ordered bus stop ids from line start to finish")
    @NotNull

    public List<Integer> getBusStopIds() {
        return busStopIds;
    }

    public void setBusStopIds(List<Integer> busStopIds) {
        this.busStopIds = busStopIds;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusLine busLine = (BusLine) o;
        return Objects.equals(this.id, busLine.id) &&
                Objects.equals(this.name, busLine.name) &&
                Objects.equals(this.busStopIds, busLine.busStopIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, busStopIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusLine {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    busStopIds: ").append(toIndentedString(busStopIds)).append("\n");
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
