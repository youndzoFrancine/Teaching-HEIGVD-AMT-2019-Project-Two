# DefaultApi

All URIs are relative to *https://localhost:8080/gestionCours*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEnrollment**](DefaultApi.md#createEnrollment) | **POST** /enrollments | 
[**createLabo**](DefaultApi.md#createLabo) | **POST** /Labo | 
[**createSubject**](DefaultApi.md#createSubject) | **POST** /subjects | 
[**deleteEnrollment**](DefaultApi.md#deleteEnrollment) | **DELETE** /enrollments/{id} | 
[**deleteSubject**](DefaultApi.md#deleteSubject) | **DELETE** /subjects/{id} | 
[**findEnrollmentById**](DefaultApi.md#findEnrollmentById) | **GET** /enrollments/{id} | 
[**getASubject**](DefaultApi.md#getASubject) | **GET** /subjects/{id} | 
[**getEnrollments**](DefaultApi.md#getEnrollments) | **GET** /enrollments | 
[**getLabos**](DefaultApi.md#getLabos) | **GET** /Labo | 
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

<a name="createLabo"></a>
# **createLabo**
> createLabo(labo)



create a Labo

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
    Labo labo = new Labo(); // Labo | 
    try {
      apiInstance.createLabo(labo);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createLabo");
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
 **labo** | [**Labo**](Labo.md)|  |

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

<a name="deleteEnrollment"></a>
# **deleteEnrollment**
> deleteEnrollment(id)



delete a single enrollment on the ID supplied

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
    Integer id = 56; // Integer | 
    try {
      apiInstance.deleteEnrollment(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteEnrollment");
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
 **id** | **Integer**|  |

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
**204** | enrollment deleted |  -  |
**0** | unexpected error |  -  |

<a name="deleteSubject"></a>
# **deleteSubject**
> deleteSubject(id)



delete a single subject on the ID

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
    Integer id = 56; // Integer | 
    try {
      apiInstance.deleteSubject(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteSubject");
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
 **id** | **Integer**|  |

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
**204** | subject deleted |  -  |
**0** | unexpected error |  -  |

<a name="findEnrollmentById"></a>
# **findEnrollmentById**
> Enrollment findEnrollmentById(id)



Returns an enrollment based on a single ID

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
    Integer id = 56; // Integer | ID of enrollment to fetch
    try {
      Enrollment result = apiInstance.findEnrollmentById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#findEnrollmentById");
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
 **id** | **Integer**| ID of enrollment to fetch |

### Return type

[**Enrollment**](Enrollment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | enrollment response |  -  |
**0** | unexpected error |  -  |

<a name="getASubject"></a>
# **getASubject**
> SubjectList getASubject(id)



gets a single subject based on the ID supplied

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
    Long id = 56L; // Long | 
    try {
      SubjectList result = apiInstance.getASubject(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getASubject");
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
 **id** | **Long**|  |

### Return type

[**SubjectList**](SubjectList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | unexpected error |  -  |
**403** | forbidden |  -  |
**404** | not found |  -  |

<a name="getEnrollments"></a>
# **getEnrollments**
> List&lt;EnrollmentList&gt; getEnrollments()



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
    try {
      List<EnrollmentList> result = apiInstance.getEnrollments();
      System.out.println(result);
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
This endpoint does not need any parameter.

### Return type

[**List&lt;EnrollmentList&gt;**](EnrollmentList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | unexpected error |  -  |

<a name="getLabos"></a>
# **getLabos**
> List&lt;Labo&gt; getLabos()



get the list of all the Labo

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
    try {
      List<Labo> result = apiInstance.getLabos();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getLabos");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Labo&gt;**](Labo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | unexpected error |  -  |

<a name="getSubjects"></a>
# **getSubjects**
> List&lt;SubjectList&gt; getSubjects()



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
    try {
      List<SubjectList> result = apiInstance.getSubjects();
      System.out.println(result);
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
This endpoint does not need any parameter.

### Return type

[**List&lt;SubjectList&gt;**](SubjectList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | unexpected error |  -  |

