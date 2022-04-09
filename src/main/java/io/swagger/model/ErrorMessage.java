package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorMessage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-07T09:02:41.194Z[GMT]")


public class ErrorMessage   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("statusCode")
  private Integer statusCode = null;

  @JsonProperty("detail")
  private String detail = null;

  public ErrorMessage title(String title) {
    this.title = title;
    return this;
  }

  /**
   * A short summary about the error type.
   * @return title
   **/
  @Schema(example = "Service Unavailable", description = "A short summary about the error type.")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorMessage statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * The HTTP status code generated by the origin server for this occurrence of the problem.
   * minimum: 100
   * maximum: 600
   * @return statusCode
   **/
  @Schema(example = "418", description = "The HTTP status code generated by the origin server for this occurrence of the problem.")
  
  @Min(100) @Max(600)   public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public ErrorMessage detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human readable explanation specific to this occurrence of the problem.
   * @return detail
   **/
  @Schema(example = "Connection to database timed out", description = "A human readable explanation specific to this occurrence of the problem.")
  
    public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.title, errorMessage.title) &&
        Objects.equals(this.statusCode, errorMessage.statusCode) &&
        Objects.equals(this.detail, errorMessage.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, statusCode, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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