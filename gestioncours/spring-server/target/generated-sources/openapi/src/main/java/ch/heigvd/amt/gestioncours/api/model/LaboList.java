package ch.heigvd.amt.gestioncours.api.model;

import java.util.Objects;
import ch.heigvd.amt.gestioncours.api.model.Labo;
import ch.heigvd.amt.gestioncours.api.model.LaboListAllOf;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LaboList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-13T10:11:48.299+01:00[Europe/Berlin]")

public class LaboList   {
  @JsonProperty("labo_name")
  private String laboName;

  @JsonProperty("ponderation")
  private Long ponderation;

  @JsonProperty("name")
  private String name;

  public LaboList laboName(String laboName) {
    this.laboName = laboName;
    return this;
  }

  /**
   * Get laboName
   * @return laboName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLaboName() {
    return laboName;
  }

  public void setLaboName(String laboName) {
    this.laboName = laboName;
  }

  public LaboList ponderation(Long ponderation) {
    this.ponderation = ponderation;
    return this;
  }

  /**
   * Get ponderation
   * @return ponderation
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getPonderation() {
    return ponderation;
  }

  public void setPonderation(Long ponderation) {
    this.ponderation = ponderation;
  }

  public LaboList name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaboList laboList = (LaboList) o;
    return Objects.equals(this.laboName, laboList.laboName) &&
        Objects.equals(this.ponderation, laboList.ponderation) &&
        Objects.equals(this.name, laboList.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(laboName, ponderation, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LaboList {\n");
    
    sb.append("    laboName: ").append(toIndentedString(laboName)).append("\n");
    sb.append("    ponderation: ").append(toIndentedString(ponderation)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

