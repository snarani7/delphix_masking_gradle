package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfileSet;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutProfileSet extends PutApiCall {

    private static final String Post_PROFILE_SET_PATH = "profile-sets/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, ProfileSet.class).getProfileSetId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_PROFILE_SET_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutProfileSet(ProfileSet profileSet) {
        body = Utils.getJSONFromClass(profileSet);
        name = profileSet.getProfileSetName();
        id = profileSet.getProfileSetId().toString();
            }
}
