package ch.heigvd.amt.gestioncours.api.model;

import java.util.Objects;
import ch.heigvd.amt.gestioncours.api.model.Enrollment;
import ch.heigvd.amt.gestioncours.api.model.SubjectListAllOf;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EnrollmentList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-07T15:18:16.508+01:00[Europe/Berlin]")

public class EnrollmentList   {
  @JsonProperty("subject_id")
  private Long subjectId;

  @JsonProperty("student_email")
  private String studentEmail;

  @JsonProperty("id")
  private Long id;

  public EnrollmentList subjectId(Long subjectId) {
    this.subjectId = subjectId;
    return this;
  }

  /**
   * Get subjectId
   * @return subjectId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Long subjectId) {
    this.subjectId = subjectId;
  }

  public EnrollmentList studentEmail(String studentEmail) {
    this.studentEmail = studentEmail;
    return this;
  }

  /**
   * Get studentEmail
   * @return studentEmail
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStudentEmail() {
    return studentEmail;
  }

  public void setStudentEmail(String studentEmail) {
    this.studentEmail = studentEmail;
  }

  public EnrollmentList id(Long id) {
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
    EnrollmentList enrollmentList = (EnrollmentList) o;
    return Objects.equals(this.subjectId, enrollmentList.subjectId) &&
        Objects.equals(this.studentEmail, enrollmentList.studentEmail) &&
        Objects.equals(this.id, enrollmentList.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subjectId, studentEmail, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrollmentList {\n");
    
    sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
    sb.append("    studentEmail: ").append(toIndentedString(studentEmail)).append("\n");
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

