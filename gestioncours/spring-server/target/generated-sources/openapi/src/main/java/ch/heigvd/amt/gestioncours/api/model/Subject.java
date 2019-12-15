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
 * Subject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-15T21:22:24.651+01:00[Europe/Berlin]")

public class Subject   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("credits_etcs")
  private Long creditsEtcs;

  public Subject name(String name) {
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

  public Subject creditsEtcs(Long creditsEtcs) {
    this.creditsEtcs = creditsEtcs;
    return this;
  }

  /**
   * Get creditsEtcs
   * @return creditsEtcs
  */
  @ApiModelProperty(value = "")


  public Long getCreditsEtcs() {
    return creditsEtcs;
  }

  public void setCreditsEtcs(Long creditsEtcs) {
    this.creditsEtcs = creditsEtcs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subject subject = (Subject) o;
    return Objects.equals(this.name, subject.name) &&
        Objects.equals(this.creditsEtcs, subject.creditsEtcs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, creditsEtcs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subject {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creditsEtcs: ").append(toIndentedString(creditsEtcs)).append("\n");
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

