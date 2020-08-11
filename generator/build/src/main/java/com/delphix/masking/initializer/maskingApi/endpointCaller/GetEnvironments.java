package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Environment;
import com.delphix.masking.initializer.pojo.EnvironmentList;

import java.util.ArrayList;
import lombok.Setter;

public class GetEnvironments extends GetApiCall {

    private static final String GET_ENVIRONMENT_PATH = "environments";
    private EnvironmentList environmentList;
    private ArrayList environmentArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (environmentArray == null) {
           environmentArray = new ArrayList<>();
        }

        environmentList = Utils.getClassFromJson(responseBody, EnvironmentList.class);
        environmentArray.addAll(environmentList.getResponseList());
        currentSize = environmentArray.size();
        if (total == null) {
            total = environmentList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_ENVIRONMENT_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<Environment> getEnvironments() {
        return environmentArray;
    }
}