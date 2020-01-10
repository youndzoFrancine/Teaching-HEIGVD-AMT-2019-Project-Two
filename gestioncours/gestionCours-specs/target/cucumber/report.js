$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("enrollment.feature");
formatter.feature({
  "line": 1,
  "name": "Creation of enrollments",
  "description": "",
  "id": "creation-of-enrollments",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "create a enrollment",
  "description": "",
  "id": "creation-of-enrollments;create-a-enrollment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have a enrollment payload",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I POST it to the /enrollments endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "EnrollmentSteps.i_have_a_enrollment_payload()"
});
formatter.result({
  "duration": 6367390900,
  "status": "passed"
});
formatter.match({
  "location": "EnrollmentSteps.i_POST_it_to_the_enrollments_endpoint()"
});
formatter.result({
  "duration": 4336602500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 12
    }
  ],
  "location": "EnrollmentSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 15151100,
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c0\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat ch.heigvd.amt.gestioncours.spec.steps.EnrollmentSteps.i_receive_a_status_code(EnrollmentSteps.java:67)\r\n\tat ✽.Then I receive a 201 status code(enrollment.feature:6)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 8,
  "name": "Delete enrollment",
  "description": "",
  "id": "creation-of-enrollments;delete-enrollment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "there exists a enrollment",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I delete the enrollment",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I get a \u0027OK\u0027 response",
  "keyword": "Then "
});
formatter.match({
  "location": "EnrollmentSteps.there_exists_a_user()"
});
formatter.result({
  "duration": 4040170100,
  "status": "passed"
});
formatter.match({
  "location": "EnrollmentSteps.i_delete_the_user()"
});
formatter.result({
  "duration": 755700,
  "error_message": "java.lang.NullPointerException\r\n\tat ch.heigvd.amt.gestioncours.spec.steps.EnrollmentSteps.i_delete_the_user(EnrollmentSteps.java:92)\r\n\tat ✽.When I delete the enrollment(enrollment.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "EnrollmentSteps.i_get_a_OK_response()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("subject.feature");
formatter.feature({
  "line": 1,
  "name": "Creation of subjects",
  "description": "",
  "id": "creation-of-subjects",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "there is a Subjects server",
  "keyword": "Given "
});
formatter.match({
  "location": "SubjectSteps.there_is_a_Subjects_server()"
});
formatter.result({
  "duration": 1910200,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "create a subject",
  "description": "",
  "id": "creation-of-subjects;create-a-subject",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I have a subject payload",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I POST it to the /subjects endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "SubjectSteps.i_have_a_subject_payload()"
});
formatter.result({
  "duration": 641000,
  "status": "passed"
});
formatter.match({
  "location": "SubjectSteps.i_POST_it_to_the_subjects_endpoint()"
});
formatter.result({
  "duration": 4024784600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 12
    }
  ],
  "location": "EnrollmentSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 1164200,
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c0\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat ch.heigvd.amt.gestioncours.spec.steps.EnrollmentSteps.i_receive_a_status_code(EnrollmentSteps.java:67)\r\n\tat ✽.Then I receive a 201 status code(subject.feature:9)\r\n",
  "status": "failed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "there is a Subjects server",
  "keyword": "Given "
});
formatter.match({
  "location": "SubjectSteps.there_is_a_Subjects_server()"
});
formatter.result({
  "duration": 2308800,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Get subject",
  "description": "",
  "id": "creation-of-subjects;get-subject",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "I  GET an existing subject",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I get a subject",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I receive  200 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "SubjectSteps.i_GET_an_existing_subject()"
});
formatter.result({
  "duration": 4028617600,
  "status": "passed"
});
formatter.match({
  "location": "SubjectSteps.i_get_a_subject()"
});
formatter.result({
  "duration": 4021216400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 11
    }
  ],
  "location": "SubjectsCRUDSteps.i_receive_status_code(int)"
});
formatter.result({
  "duration": 7990400,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat ch.heigvd.amt.gestioncours.spec.steps.SubjectsCRUDSteps.i_receive_status_code(SubjectsCRUDSteps.java:64)\r\n\tat ✽.Then I receive  200 status code(subject.feature:14)\r\n",
  "status": "pending"
});
formatter.uri("subjectCRUD.feature");
formatter.feature({
  "line": 1,
  "name": "Test CRUD methods in subject",
  "description": "",
  "id": "test-crud-methods-in-subject",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get subject",
  "description": "",
  "id": "test-crud-methods-in-subject;get-subject",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I Set GET subject service api endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I Set request HEADER",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Send GET HTTP request",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I receive  200 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "SubjectsCRUDSteps.i_Set_GET_subject_service_api_endpoint()"
});
formatter.result({
  "duration": 2398900,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat ch.heigvd.amt.gestioncours.spec.steps.SubjectsCRUDSteps.i_Set_GET_subject_service_api_endpoint(SubjectsCRUDSteps.java:46)\r\n\tat ✽.Given I Set GET subject service api endpoint(subjectCRUD.feature:4)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "SubjectsCRUDSteps.i_Set_request_HEADER()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SubjectsCRUDSteps.send_GET_HTTP_request()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 11
    }
  ],
  "location": "SubjectsCRUDSteps.i_receive_status_code(int)"
});
formatter.result({
  "status": "skipped"
});
});