package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Application;
import com.delphix.masking.initializer.pojo.Environment;
import java.util.List;

public class PostApplication extends PostApiCall {

    private static final String Post_APPLICATION_PATH = "applications";
    private Application application;

    @Override
    public void setResponse(String responseBody) {
        this.application.setApplicationId(Utils.getClassFromJson(responseBody, Application.class).getApplicationId());
        id = this.application.getApplicationId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_APPLICATION_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetApplications getApplications = new GetApplications();
        apiCallDriver.makeGetCall(getApplications);
        for (Application application: getApplications.getApplications()) {
            if (!application.getApplicationName().equalsIgnoreCase(name)) {
                continue;
            }
            id = application.getApplicationId().toString();
            this.application.setApplicationId(application.getApplicationId());
        }
    }
    public PostApplication(Application application) {
        this.application = application;
        List<Environment> environments = application.getEnvironments();
                        application.setEnvironments(null);
                List<String> environmentFiles = application.getEnvironmentFiles();
                        application.setEnvironmentFiles(null);
        
        body = Utils.getJSONFromClass(application);
        name = application.getApplicationName();

        application.setEnvironments(environments);
        application.setEnvironmentFiles(environmentFiles);

    }
}
