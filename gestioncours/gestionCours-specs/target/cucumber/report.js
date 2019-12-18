$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("creation.feature");
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
  "location": "CreationSteps.there_is_a_Subjects_server()"
});
formatter.result({
  "duration": 3297919900,
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
  "location": "CreationSteps.i_have_a_subject_payload()"
});
formatter.result({
  "duration": 237100,
  "status": "passed"
});
formatter.match({
  "location": "CreationSteps.i_POST_it_to_the_subjects_endpoint()"
});
formatter.result({
  "duration": 81615800,
  "error_message": "java.lang.IllegalArgumentException: Expected URL scheme \u0027http\u0027 or \u0027https\u0027 but no colon was found\r\n\tat okhttp3.HttpUrl$Builder.parse$okhttp(HttpUrl.kt:1257)\r\n\tat okhttp3.HttpUrl$Companion.get(HttpUrl.kt:1630)\r\n\tat okhttp3.Request$Builder.url(Request.kt:184)\r\n\tat ch.heigvd.amt.gestioncours.ApiClient.buildRequest(ApiClient.java:1024)\r\n\tat ch.heigvd.amt.gestioncours.ApiClient.buildCall(ApiClient.java:999)\r\n\tat ch.heigvd.amt.gestioncours.api.DefaultApi.createSubjectCall(DefaultApi.java:208)\r\n\tat ch.heigvd.amt.gestioncours.api.DefaultApi.createSubjectValidateBeforeCall(DefaultApi.java:220)\r\n\tat ch.heigvd.amt.gestioncours.api.DefaultApi.createSubjectWithHttpInfo(DefaultApi.java:255)\r\n\tat ch.heigvd.amt.gestioncours.spec.steps.CreationSteps.i_POST_it_to_the_subjects_endpoint(CreationSteps.java:49)\r\n\tat ✽.When I POST it to the /subjects endpoint(creation.feature:8)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
});