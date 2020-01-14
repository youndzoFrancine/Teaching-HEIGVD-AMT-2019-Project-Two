# RigthUserApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**updateUser**](RigthUserApi.md#updateUser) | **PUT** /users/{e_mail} | 


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
import ch.heigvd.amt.authentication.api.RigthUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    RigthUserApi apiInstance = new RigthUserApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      User result = apiInstance.updateUser(eMail);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RigthUserApi#updateUser");
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

