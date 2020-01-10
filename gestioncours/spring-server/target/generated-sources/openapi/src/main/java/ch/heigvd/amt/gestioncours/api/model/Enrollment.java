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
<<<<<<< HEAD
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-06T11:13:13.088+01:00[Europe/Zurich]")
=======
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-09T14:49:11.383+01:00[Europe/Zurich]")
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5

public class Enrollment   {
  @JsonProperty("subject_id")
  private Long subjectId;

<<<<<<< HEAD
  @JsonProperty("student_email")
  private String studentEmail;
=======
  @JsonProperty("user_email")
  private String userEmail;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5

  public Enrollment subjectId(Long subjectId) {
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

<<<<<<< HEAD
  public Enrollment studentEmail(String studentEmail) {
    this.studentEmail = studentEmail;
=======
  public Enrollment userEmail(String userEmail) {
    this.userEmail = userEmail;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
    return this;
  }

  /**
<<<<<<< HEAD
   * Get studentEmail
   * @return studentEmail
=======
   * Get userEmail
   * @return userEmail
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


<<<<<<< HEAD
  public String getStudentEmail() {
    return studentEmail;
  }

  public void setStudentEmail(String studentEmail) {
    this.studentEmail = studentEmail;
=======
  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
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
<<<<<<< HEAD
        Objects.equals(this.studentEmail, enrollment.studentEmail);
=======
        Objects.equals(this.userEmail, enrollment.userEmail);
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
  }

  @Override
  public int hashCode() {
<<<<<<< HEAD
    return Objects.hash(subjectId, studentEmail);
=======
    return Objects.hash(subjectId, userEmail);
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Enrollment {\n");
    
    sb.append("    subjectId: ").append(toIndentedString(subjectId)).append("\n");
<<<<<<< HEAD
    sb.append("    studentEmail: ").append(toIndentedString(studentEmail)).append("\n");
=======
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
>>>>>>> 63dd7b6021b3903ddab9bf1535649138ff826dc5
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

