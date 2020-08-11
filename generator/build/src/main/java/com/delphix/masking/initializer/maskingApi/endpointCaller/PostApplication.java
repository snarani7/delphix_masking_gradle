package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Application;
import com.delphix.masking.initializer.pojo.Environment;
import java.util.List;

public class PostApplication extends PostApiCall {

    private static final String Post_APPLICATION_PATH = "applications";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, Application.class).getApplicationName().toString();
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
            id = application.getApplicationName().toString();
        }
    }
    public PostApplication(Application application) {

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
