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
 * Enrollment
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-16T15:25:55.881+01:00[Europe/Berlin]")

public class Enrollment   {
  @JsonProperty("subject_id")
  private Long subjectId;

  @JsonProperty("e_mail")
  private String eMail;

  public Enrollment subjectId(Long subjectId) {
    this.subjectId = subjectId;
    return this;
  }

  /**
   * Get subjectId
   * @return subjectId
  */
  @ApiModelProperty(value = "")


  public Long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Long subjectId) {
    this.subjectId = subjectId;
  }

  public Enrollment eMail(String eMail) {
    this.eMail = eMail;
    return this;
  }

  /**
   * Get eMail
   * @return eMail
  */
  @ApiModelProperty(value = "")


  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Enrollment enrollment = (Enrollment) o;
    return Objects.equals(this.subjectId, enrollment.subjectId) &&
        Objects.equals(this.eMail, enrollment.eMail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subjectId, eMail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Enrollment {\n");
    
    sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
    sb.append("    eMail: ").append(toIndentedString(eMail)).append("\n");
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

