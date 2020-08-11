package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfileExpression;
import java.util.List;

public class PostProfileExpression extends PostApiCall {

    private static final String Post_PROFILE_EXPRESSION_PATH = "profile-expressions";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, ProfileExpression.class).getProfileExpressionId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_PROFILE_EXPRESSION_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetProfileExpressions getProfileExpressions = new GetProfileExpressions();
        apiCallDriver.makeGetCall(getProfileExpressions);
        for (ProfileExpression profileExpression: getProfileExpressions.getProfileExpressions()) {
            if (!profileExpression.getExpressionName().equalsIgnoreCase(name)) {
                continue;
            }
            id = profileExpression.getProfileExpressionId().toString();
            if (replace) {
                ProfileExpression tmp = Utils.getClassFromJson(body, ProfileExpression.class);
                tmp.setProfileExpressionId(profileExpression.getProfileExpressionId());
                PutProfileExpression putProfileExpression = new PutProfileExpression(tmp);
                apiCallDriver.makePutCall(putProfileExpression);
            }
        }
    }
    public PostProfileExpression(ProfileExpression profileExpression) {


        body = Utils.getJSONFromClass(profileExpression);
        name = profileExpression.getExpressionName();


    }
}
