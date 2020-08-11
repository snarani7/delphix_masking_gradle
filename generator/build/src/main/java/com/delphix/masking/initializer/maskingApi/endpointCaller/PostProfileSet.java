package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfileSet;
import com.delphix.masking.initializer.pojo.ProfileExpression;
import java.util.List;

public class PostProfileSet extends PostApiCall {

    private static final String Post_PROFILE_SET_PATH = "profile-sets";
    private ProfileSet profileSet;

    @Override
    public void setResponse(String responseBody) {
        this.profileSet.setProfileSetId(Utils.getClassFromJson(responseBody, ProfileSet.class).getProfileSetId());
        id = this.profileSet.getProfileSetId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_PROFILE_SET_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetProfileSets getProfileSets = new GetProfileSets();
        apiCallDriver.makeGetCall(getProfileSets);
        for (ProfileSet profileSet: getProfileSets.getProfileSets()) {
            if (!profileSet.getProfileSetName().equalsIgnoreCase(name)) {
                continue;
            }
            id = profileSet.getProfileSetId().toString();
            this.profileSet.setProfileSetId(profileSet.getProfileSetId());
            if (replace) {
                ProfileSet tmp = Utils.getClassFromJson(body, ProfileSet.class);
                tmp.setProfileSetId(profileSet.getProfileSetId());
                PutProfileSet putProfileSet = new PutProfileSet(tmp);
                apiCallDriver.makePutCall(putProfileSet);
            }
        }
    }
    public PostProfileSet(ProfileSet profileSet) {
        this.profileSet = profileSet;
        List<ProfileExpression> profileExpressions = profileSet.getProfileExpressions();
                        profileSet.setProfileExpressions(null);
                List<String> profileExpressionNames = profileSet.getProfileExpressionNames();
                        profileSet.setProfileExpressionNames(null);
        
        body = Utils.getJSONFromClass(profileSet);
        name = profileSet.getProfileSetName();

        profileSet.setProfileExpressions(profileExpressions);
        profileSet.setProfileExpressionNames(profileExpressionNames);

    }
}
