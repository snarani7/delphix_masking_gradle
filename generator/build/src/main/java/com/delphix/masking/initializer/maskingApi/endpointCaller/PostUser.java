package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.User;
import java.util.List;

public class PostUser extends PostApiCall {

    private static final String Post_USER_PATH = "users";
    private User user;

    @Override
    public void setResponse(String responseBody) {
        this.user.setUserId(Utils.getClassFromJson(responseBody, User.class).getUserId());
        id = this.user.getUserId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_USER_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetUsers getUsers = new GetUsers();
        apiCallDriver.makeGetCall(getUsers);
        for (User user: getUsers.getUsers()) {
            if (!user.getUserName().equalsIgnoreCase(name)) {
                continue;
            }
            id = user.getUserId().toString();
            this.user.setUserId(user.getUserId());
        }
    }
    public PostUser(User user) {
        this.user = user;

        body = Utils.getJSONFromClass(user);
        name = user.getUserName();


    }
}
