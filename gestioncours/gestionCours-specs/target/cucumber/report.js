$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("enrollement.feature");
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
  "name": "there is a Enrollments server",
  "keyword": "Given "
});
formatter.match({
  "location": "EnrollmentSteps.there_is_a_Enrollments_server()"
});
formatter.result({
  "duration": 1187002374,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "create a enrollment",
  "description": "",
  "id": "creation-of-subjects;create-a-enrollment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I have a enrollment payload",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I POST it to the /enrollments endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "EnrollmentSteps.i_have_a_enrollment_payload()"
});
formatter.result({
  "duration": 182741,
  "status": "passed"
});
formatter.match({
  "location": "EnrollmentSteps.i_POST_it_to_the_enrollments_endpoint()"
});
formatter.result({
  "duration": 768299491,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 12
    }
  ],
  "location": "CreationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 3697531,
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c0\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\n\tat org.junit.Assert.assertEquals(Assert.java:645)\n\tat org.junit.Assert.assertEquals(Assert.java:631)\n\tat ch.heigvd.amt.gestioncours.spec.steps.CreationSteps.i_receive_a_status_code(CreationSteps.java:63)\n\tat ✽.Then I receive a 201 status code(enrollement.feature:9)\n",
  "status": "failed"
});
});