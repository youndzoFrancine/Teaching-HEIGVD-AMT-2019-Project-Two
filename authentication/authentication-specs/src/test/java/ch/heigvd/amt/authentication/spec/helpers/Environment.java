package ch.heigvd.amt.authentication.spec.helpers;



import ch.heigvd.amt.authentication.api.RigthUserApi;
import ch.heigvd.amt.authentication.api.AdminAllowApi;
import ch.heigvd.amt.authentication.api.AllUsersApi;


import java.io.IOException;
import java.util.Properties;

/**
 * Created by Olivier Liechti on 24/06/17.
 */
public class Environment {

    private AdminAllowApi AdminApi = new AdminAllowApi();
    private AllUsersApi AllUserApi = new AllUsersApi();
    private RigthUserApi RightUserApi = new RigthUserApi();

    public Environment() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
        String url = properties.getProperty("ch.heigvd.amt.authentication");
        AdminApi.getApiClient().setBasePath(url);
        AllUserApi.getApiClient().setBasePath(url);
        RightUserApi.getApiClient().setBasePath(url);



    }

    public AdminAllowApi getAdminApi(){return AdminApi;}
    public AllUsersApi getAllUserApi(){return AllUserApi;}
    public RigthUserApi getRightUserApi(){return RightUserApi;}


}
