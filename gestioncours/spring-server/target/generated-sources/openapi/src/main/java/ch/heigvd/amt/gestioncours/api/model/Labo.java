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
 * Labo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-14T00:43:06.459+01:00[Europe/Zurich]")

public class Labo   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("labo_name")
  private String laboName;

  @JsonProperty("ponderation")
  private Long ponderation;

  public Labo id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Labo laboName(String laboName) {
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

  public Labo ponderation(Long ponderation) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Labo labo = (Labo) o;
    return Objects.equals(this.id, labo.id) &&
        Objects.equals(this.laboName, labo.laboName) &&
        Objects.equals(this.ponderation, labo.ponderation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, laboName, ponderation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Labo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    laboName: ").append(toIndentedString(laboName)).append("\n");
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

