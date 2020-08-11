package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfileExpression;
import com.delphix.masking.initializer.pojo.ProfileExpressionList;

import java.util.ArrayList;
import lombok.Setter;

public class GetProfileExpressions extends GetApiCall {

    private static final String GET_PROFILE_EXPRESSION_PATH = "profile-expressions";
    private ProfileExpressionList profileExpressionList;
    private ArrayList profileExpressionArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (profileExpressionArray == null) {
           profileExpressionArray = new ArrayList<>();
        }

        profileExpressionList = Utils.getClassFromJson(responseBody, ProfileExpressionList.class);
        profileExpressionArray.addAll(profileExpressionList.getResponseList());
        currentSize = profileExpressionArray.size();
        if (total == null) {
            total = profileExpressionList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_PROFILE_EXPRESSION_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<ProfileExpression> getProfileExpressions() {
        return profileExpressionArray;
    }
}