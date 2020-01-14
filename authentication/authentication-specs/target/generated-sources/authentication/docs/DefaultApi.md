# DefaultApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**blockUser**](DefaultApi.md#blockUser) | **PATCH** /users/{e_mail}/block | 
[**createUser**](DefaultApi.md#createUser) | **POST** /users | 
[**deleteUser**](DefaultApi.md#deleteUser) | **DELETE** /users/{e_mail} | 
[**getUsers**](DefaultApi.md#getUsers) | **GET** /users | 
[**login**](DefaultApi.md#login) | **POST** /login | 
[**unblockUser**](DefaultApi.md#unblockUser) | **PATCH** /users/{e_mail}/unblock | 
[**updateUser**](DefaultApi.md#updateUser) | **PUT** /users/{e_mail} | 


<a name="blockUser"></a>
# **blockUser**
> blockUser(eMail)



the admin block a user

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      apiInstance.blockUser(eMail);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#blockUser");
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
**401** | Access token is missing or is invalid |  -  |

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
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    User user = new User(); // User | 
    try {
      apiInstance.createUser(user);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createUser");
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
**401** | Access token is missing or is invalid |  -  |

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
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      apiInstance.deleteUser(eMail);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteUser");
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
**401** | Access token is missing or is invalid |  -  |

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
import ch.heigvd.amt.authentication.auth.*;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure API key authorization: bearerAuth
    ApiKeyAuth bearerAuth = (ApiKeyAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //bearerAuth.setApiKeyPrefix("Token");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<User> result = apiInstance.getUsers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getUsers");
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

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |

<a name="login"></a>
# **login**
> login(credentials)



have access to ressources

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Credentials credentials = new Credentials(); // Credentials | 
    try {
      apiInstance.login(credentials);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#login");
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
**401** | Access token is missing or is invalid |  -  |

<a name="unblockUser"></a>
# **unblockUser**
> unblockUser(eMail)



the admin block a user

### Example
```java
// Import classes:
import ch.heigvd.amt.authentication.ApiClient;
import ch.heigvd.amt.authentication.ApiException;
import ch.heigvd.amt.authentication.Configuration;
import ch.heigvd.amt.authentication.models.*;
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      apiInstance.unblockUser(eMail);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#unblockUser");
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
**401** | Access token is missing or is invalid |  -  |

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
import ch.heigvd.amt.authentication.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String eMail = "eMail_example"; // String | 
    try {
      User result = apiInstance.updateUser(eMail);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateUser");
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
**401** | Access token is missing or is invalid |  -  |

