package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfilingJob;
import java.util.List;

public class PostProfilingJob extends PostApiCall {

    private static final String Post_PROFILING_JOB_PATH = "profile-jobs";
    private ProfilingJob profilingjob;

    @Override
    public void setResponse(String responseBody) {
        this.profilingjob.setProfileJobId(Utils.getClassFromJson(responseBody, ProfilingJob.class).getProfileJobId());
        id = this.profilingjob.getProfileJobId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_PROFILING_JOB_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetProfilingJobs getProfilingJobs = new GetProfilingJobs();
        apiCallDriver.makeGetCall(getProfilingJobs);
        for (ProfilingJob profilingjob: getProfilingJobs.getProfilingJobs()) {
            if (!profilingjob.getJobName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!profilingjob.getRulesetId().equals(parentId)) {
                continue;
            }
            id = profilingjob.getProfileJobId().toString();
            this.profilingjob.setProfileJobId(profilingjob.getProfileJobId());
            if (replace) {
                ProfilingJob tmp = Utils.getClassFromJson(body, ProfilingJob.class);
                tmp.setProfileJobId(profilingjob.getProfileJobId());
                PutProfilingJob putProfilingJob = new PutProfilingJob(tmp);
                apiCallDriver.makePutCall(putProfilingJob);
            }
        }
    }
    public PostProfilingJob(ProfilingJob profilingjob, Integer parentId) {
        profilingjob.setRulesetId(parentId);
        this.parentId = parentId;
        this.profilingjob = profilingjob;

        body = Utils.getJSONFromClass(profilingjob);
        name = profilingjob.getJobName();


    }
}
