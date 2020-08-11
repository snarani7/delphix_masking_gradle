package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfilingJob;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutProfilingJob extends PutApiCall {

    private static final String Post_PROFILING_JOB_PATH = "profile-jobs/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, ProfilingJob.class).getProfileJobId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_PROFILING_JOB_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutProfilingJob(ProfilingJob profilingjob) {
        body = Utils.getJSONFromClass(profilingjob);
        name = profilingjob.getJobName();
        id = profilingjob.getProfileJobId().toString();
            }
}
