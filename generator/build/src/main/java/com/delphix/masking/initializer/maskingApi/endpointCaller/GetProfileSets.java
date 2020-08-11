package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfileSet;
import com.delphix.masking.initializer.pojo.ProfileSetList;

import java.util.ArrayList;
import lombok.Setter;

public class GetProfileSets extends GetApiCall {

    private static final String GET_PROFILE_SET_PATH = "profile-sets";
    private ProfileSetList profileSetList;
    private ArrayList profileSetArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (profileSetArray == null) {
           profileSetArray = new ArrayList<>();
        }

        profileSetList = Utils.getClassFromJson(responseBody, ProfileSetList.class);
        profileSetArray.addAll(profileSetList.getResponseList());
        currentSize = profileSetArray.size();
        if (total == null) {
            total = profileSetList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_PROFILE_SET_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<ProfileSet> getProfileSets() {
        return profileSetArray;
    }
}