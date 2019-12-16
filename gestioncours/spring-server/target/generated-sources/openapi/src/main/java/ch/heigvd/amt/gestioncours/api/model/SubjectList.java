package ch.heigvd.amt.gestioncours.api.model;

import java.util.Objects;
import ch.heigvd.amt.gestioncours.api.model.Subject;
import ch.heigvd.amt.gestioncours.api.model.SubjectListAllOf;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubjectList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-16T15:25:55.881+01:00[Europe/Berlin]")

public class SubjectList   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("credits_etcs")
  private Long creditsEtcs;

  @JsonProperty("id")
  private Long id;

  public SubjectList name(String name) {
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

  public SubjectList creditsEtcs(Long creditsEtcs) {
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

  public SubjectList id(Long id) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectList subjectList = (SubjectList) o;
    return Objects.equals(this.name, subjectList.name) &&
        Objects.equals(this.creditsEtcs, subjectList.creditsEtcs) &&
        Objects.equals(this.id, subjectList.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, creditsEtcs, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubjectList {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creditsEtcs: ").append(toIndentedString(creditsEtcs)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

