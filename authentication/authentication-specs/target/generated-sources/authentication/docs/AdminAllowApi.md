# AdminAllowApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](AdminAllowApi.md#createUser) | **POST** /users | 
[**deleteUser**](AdminAllowApi.md#deleteUser) | **DELETE** /users/{e_mail} | 
[**updateUser**](AdminAllowApi.md#updateUser) | **PUT** /users/{e_mail} | 


<a name="createUser"></a>
# **createUser**
> createUser(user)



create a user

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.AdminAllowApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AdminAllowApi apiInstance = new AdminAllowApi(defaultClient);
    User user = new User(); // User | 
    try {
      apiInstance.createUser(user);
    } catch (ApiException e) {
      System.err.println("Exception when calling AdminAllowApi#createUser");
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
 **user** | [**User**](User.md)|  |

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
**401** | Access token is missing or invalid |  -  |

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(eMail)



deletes a single user based on the e_mail supplied

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.AdminAllowApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AdminAllowApi apiInstance = new AdminAllowApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      apiInstance.deleteUser(eMail);
    } catch (ApiException e) {
      System.err.println("Exception when calling AdminAllowApi#deleteUser");
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
 **eMail** | **String**|  |

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
**401** | Access token is missing or invalid |  -  |

<a name="updateUser"></a>
# **updateUser**
> User updateUser(eMail)



updates a single user based on the e_mail supplied

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.AdminAllowApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AdminAllowApi apiInstance = new AdminAllowApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      User result = apiInstance.updateUser(eMail);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AdminAllowApi#updateUser");
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
 **eMail** | **String**|  |

### Return type

[**User**](User.md)

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

