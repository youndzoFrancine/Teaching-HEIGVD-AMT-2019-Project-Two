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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-14T00:43:06.459+01:00[Europe/Zurich]")

public class Subject   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("credits_etcs")
  private Long creditsEtcs;

  public Subject id(Long id) {
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

  public Subject name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


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
  @ApiModelProperty(required = true, value = "")
  @NotNull


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
    return Objects.equals(this.id, subject.id) &&
        Objects.equals(this.name, subject.name) &&
        Objects.equals(this.creditsEtcs, subject.creditsEtcs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, creditsEtcs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subject {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

