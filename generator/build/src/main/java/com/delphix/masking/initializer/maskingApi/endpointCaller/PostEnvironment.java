package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Environment;
import com.delphix.masking.initializer.pojo.DatabaseConnector;
import com.delphix.masking.initializer.pojo.FileConnector;
import java.util.List;

public class PostEnvironment extends PostApiCall {

    private static final String Post_ENVIRONMENT_PATH = "environments";
    private Environment environment;

    @Override
    public void setResponse(String responseBody) {
        this.environment.setEnvironmentId(Utils.getClassFromJson(responseBody, Environment.class).getEnvironmentId());
        id = this.environment.getEnvironmentId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_ENVIRONMENT_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetEnvironments getEnvironments = new GetEnvironments();
        apiCallDriver.makeGetCall(getEnvironments);
        for (Environment environment: getEnvironments.getEnvironments()) {
            if (!environment.getEnvironmentName().equalsIgnoreCase(name)) {
                continue;
            }
            id = environment.getEnvironmentId().toString();
            this.environment.setEnvironmentId(environment.getEnvironmentId());
            if (replace) {
                Environment tmp = Utils.getClassFromJson(body, Environment.class);
                tmp.setEnvironmentId(environment.getEnvironmentId());
                PutEnvironment putEnvironment = new PutEnvironment(tmp);
                apiCallDriver.makePutCall(putEnvironment);
            }
        }
    }
    public PostEnvironment(Environment environment) {
        this.environment = environment;
        List<DatabaseConnector> databaseConnectors = environment.getDatabaseConnectors();
                        environment.setDatabaseConnectors(null);
                List<FileConnector> fileConnectors = environment.getFileConnectors();
                        environment.setFileConnectors(null);
        
        body = Utils.getJSONFromClass(environment);
        name = environment.getEnvironmentName();

        environment.setDatabaseConnectors(databaseConnectors);
        environment.setFileConnectors(fileConnectors);

    }
}
