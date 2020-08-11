package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Application;
import com.delphix.masking.initializer.pojo.ApplicationList;

import java.util.ArrayList;
import lombok.Setter;

public class GetApplications extends GetApiCall {

    private static final String GET_APPLICATION_PATH = "applications";
    private ApplicationList applicationList;
    private ArrayList applicationArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (applicationArray == null) {
           applicationArray = new ArrayList<>();
        }

        applicationList = Utils.getClassFromJson(responseBody, ApplicationList.class);
        applicationArray.addAll(applicationList.getResponseList());
        currentSize = applicationArray.size();
        if (total == null) {
            total = applicationList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_APPLICATION_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<Application> getApplications() {
        return applicationArray;
    }
}