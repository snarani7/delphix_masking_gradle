package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Environment;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutEnvironment extends PutApiCall {

    private static final String Post_ENVIRONMENT_PATH = "environments/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, Environment.class).getEnvironmentId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_ENVIRONMENT_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutEnvironment(Environment environment) {
        body = Utils.getJSONFromClass(environment);
        name = environment.getEnvironmentName();
        id = environment.getEnvironmentId().toString();
            }
}
