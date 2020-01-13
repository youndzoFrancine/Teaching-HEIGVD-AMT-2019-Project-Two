package ch.heigvd.amt.gestioncours.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LaboListAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-13T16:54:23.418+01:00[Europe/Berlin]")

public class LaboListAllOf   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("ponderation")
  private Long ponderation;

  public LaboListAllOf name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LaboListAllOf ponderation(Long ponderation) {
    this.ponderation = ponderation;
    return this;
  }

  /**
   * Get ponderation
   * @return ponderation
  */
  @ApiModelProperty(value = "")


  public Long getPonderation() {
    return ponderation;
  }

  public void setPonderation(Long ponderation) {
    this.ponderation = ponderation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaboListAllOf laboListAllOf = (LaboListAllOf) o;
    return Objects.equals(this.name, laboListAllOf.name) &&
        Objects.equals(this.ponderation, laboListAllOf.ponderation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ponderation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LaboListAllOf {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ponderation: ").append(toIndentedString(ponderation)).append("\n");
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

