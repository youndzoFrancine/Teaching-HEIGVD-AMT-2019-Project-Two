package ch.heigvd.amt.authentication.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdatePswrd
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-14T15:21:16.587+01:00[Europe/Berlin]")

public class UpdatePswrd   {
  @JsonProperty("old_pswrd")
  private String oldPswrd;

  @JsonProperty("new_pswrd")
  private String newPswrd;

  @JsonProperty("email")
  private String email;

  public UpdatePswrd oldPswrd(String oldPswrd) {
    this.oldPswrd = oldPswrd;
    return this;
  }

  /**
   * Get oldPswrd
   * @return oldPswrd
  */
  @ApiModelProperty(value = "")


  public String getOldPswrd() {
    return oldPswrd;
  }

  public void setOldPswrd(String oldPswrd) {
    this.oldPswrd = oldPswrd;
  }

  public UpdatePswrd newPswrd(String newPswrd) {
    this.newPswrd = newPswrd;
    return this;
  }

  /**
   * Get newPswrd
   * @return newPswrd
  */
  @ApiModelProperty(value = "")


  public String getNewPswrd() {
    return newPswrd;
  }

  public void setNewPswrd(String newPswrd) {
    this.newPswrd = newPswrd;
  }

  public UpdatePswrd email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePswrd updatePswrd = (UpdatePswrd) o;
    return Objects.equals(this.oldPswrd, updatePswrd.oldPswrd) &&
        Objects.equals(this.newPswrd, updatePswrd.newPswrd) &&
        Objects.equals(this.email, updatePswrd.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oldPswrd, newPswrd, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePswrd {\n");
    
    sb.append("    oldPswrd: ").append(toIndentedString(oldPswrd)).append("\n");
    sb.append("    newPswrd: ").append(toIndentedString(newPswrd)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

