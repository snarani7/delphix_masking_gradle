package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.User;
import com.delphix.masking.initializer.pojo.UserList;

import java.util.ArrayList;
import lombok.Setter;

public class GetUsers extends GetApiCall {

    private static final String GET_USER_PATH = "users";
    private UserList userList;
    private ArrayList userArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (userArray == null) {
           userArray = new ArrayList<>();
        }

        userList = Utils.getClassFromJson(responseBody, UserList.class);
        userArray.addAll(userList.getResponseList());
        currentSize = userArray.size();
        if (total == null) {
            total = userList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_USER_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<User> getUsers() {
        return userArray;
    }
}