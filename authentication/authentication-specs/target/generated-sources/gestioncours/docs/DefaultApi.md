# DefaultApi

All URIs are relative to *https://localhost:8080/gestionCours*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEnrollment**](DefaultApi.md#createEnrollment) | **POST** /enrollments | 
[**createSubject**](DefaultApi.md#createSubject) | **POST** /subjects | 
[**getEnrollments**](DefaultApi.md#getEnrollments) | **GET** /enrollments | 
[**getSubjects**](DefaultApi.md#getSubjects) | **GET** /subjects | 


<a name="createEnrollment"></a>
# **createEnrollment**
> createEnrollment(enrollment)



create an Enrollment

### Example
```java
// Import classes:
import ch.heigvd.amt.gestioncours.ApiClient;
import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.Configuration;
import ch.heigvd.amt.gestioncours.models.*;
import ch.heigvd.amt.gestioncours.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080/gestionCours");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Enrollment enrollment = new Enrollment(); // Enrollment | 
    try {
      apiInstance.createEnrollment(enrollment);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createEnrollment");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enrollment** | [**Enrollment**](Enrollment.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | created |  -  |
**401** | unexpected error |  -  |
**403** | forbidden |  -  |
**404** | not found |  -  |

<a name="createSubject"></a>
# **createSubject**
> createSubject(subject)



create a subject

### Example
```java
// Import classes:
import ch.heigvd.amt.gestioncours.ApiClient;
import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.Configuration;
import ch.heigvd.amt.gestioncours.models.*;
import ch.heigvd.amt.gestioncours.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080/gestionCours");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Subject subject = new Subject(); // Subject | 
    try {
      apiInstance.createSubject(subject);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createSubject");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | [**Subject**](Subject.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | created |  -  |
**401** | unexpected error |  -  |
**403** | forbidden |  -  |
**404** | not found |  -  |

<a name="getEnrollments"></a>
# **getEnrollments**
> getEnrollments(allEnrollemnts)



get the list of all enrollments

### Example
```java
// Import classes:
import ch.heigvd.amt.gestioncours.ApiClient;
import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.Configuration;
import ch.heigvd.amt.gestioncours.models.*;
import ch.heigvd.amt.gestioncours.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080/gestionCours");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    List<EnrollmentList> allEnrollemnts = Arrays.asList(); // List<EnrollmentList> | 
    try {
      apiInstance.getEnrollments(allEnrollemnts);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getEnrollments");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **allEnrollemnts** | [**List&lt;EnrollmentList&gt;**](EnrollmentList.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | unexpected error |  -  |

<a name="getSubjects"></a>
# **getSubjects**
> getSubjects(allSujects)



get the list of all subjects

### Example
```java
// Import classes:
import ch.heigvd.amt.gestioncours.ApiClient;
import ch.heigvd.amt.gestioncours.ApiException;
import ch.heigvd.amt.gestioncours.Configuration;
import ch.heigvd.amt.gestioncours.models.*;
import ch.heigvd.amt.gestioncours.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080/gestionCours");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    List<SubjectList> allSujects = Arrays.asList(); // List<SubjectList> | 
    try {
      apiInstance.getSubjects(allSujects);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getSubjects");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **allSujects** | [**List&lt;SubjectList&gt;**](SubjectList.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | unexpected error |  -  |

