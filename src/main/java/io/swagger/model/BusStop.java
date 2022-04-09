package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BusStop
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-07T09:02:41.194Z[GMT]")


public class BusStop   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("latitude")
  private String latitude = null;

  @JsonProperty("longitude")
  private String longitude = null;

  public BusStop id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Id given by database, undefined in request body.
   * @return id
   **/
  @Schema(example = "0", description = "Id given by database, undefined in request body.")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BusStop name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of bus stop
   * @return name
   **/
  @Schema(example = "Vene", required = true, description = "Name of bus stop")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BusStop latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Bus stop location latitude
   * @return latitude
   **/
  @Schema(example = "58.385787", required = true, description = "Bus stop location latitude")
      @NotNull

    public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public BusStop longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Bus stop location latitude
   * @return longitude
   **/
  @Schema(example = "26.726408", required = true, description = "Bus stop location latitude")
      @NotNull

    public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusStop busStop = (BusStop) o;
    return Objects.equals(this.id, busStop.id) &&
        Objects.equals(this.name, busStop.name) &&
        Objects.equals(this.latitude, busStop.latitude) &&
        Objects.equals(this.longitude, busStop.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, latitude, longitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusStop {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
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
