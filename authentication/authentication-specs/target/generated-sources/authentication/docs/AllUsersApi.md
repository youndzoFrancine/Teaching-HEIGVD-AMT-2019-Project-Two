# AllUsersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authenticate**](AllUsersApi.md#authenticate) | **POST** /login | 
[**getUsers**](AllUsersApi.md#getUsers) | **GET** /users | 


<a name="authenticate"></a>
# **authenticate**
> Token authenticate(credentials)



have access to ressources

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.AllUsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AllUsersApi apiInstance = new AllUsersApi(defaultClient);
    Credentials credentials = new Credentials(); // Credentials | 
    try {
      Token result = apiInstance.authenticate(credentials);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllUsersApi#authenticate");
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
 **credentials** | [**Credentials**](Credentials.md)|  | [optional]

### Return type

[**Token**](Token.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |

<a name="getUsers"></a>
# **getUsers**
> List&lt;User&gt; getUsers()



get the list of users

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.AllUsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AllUsersApi apiInstance = new AllUsersApi(defaultClient);
    try {
      List<User> result = apiInstance.getUsers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllUsersApi#getUsers");
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

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**401** | Access token is missing or invalid |  -  |

