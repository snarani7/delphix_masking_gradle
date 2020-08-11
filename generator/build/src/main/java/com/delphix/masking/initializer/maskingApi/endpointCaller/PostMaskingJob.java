package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.MaskingJob;
import java.util.List;

public class PostMaskingJob extends PostApiCall {

    private static final String Post_MASKING_JOB_PATH = "masking-jobs";
    private MaskingJob maskingjob;

    @Override
    public void setResponse(String responseBody) {
        this.maskingjob.setMaskingJobId(Utils.getClassFromJson(responseBody, MaskingJob.class).getMaskingJobId());
        id = this.maskingjob.getMaskingJobId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_MASKING_JOB_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetMaskingJobs getMaskingJobs = new GetMaskingJobs();
        apiCallDriver.makeGetCall(getMaskingJobs);
        for (MaskingJob maskingjob: getMaskingJobs.getMaskingJobs()) {
            if (!maskingjob.getJobName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!maskingjob.getRulesetId().equals(parentId)) {
                continue;
            }
            id = maskingjob.getMaskingJobId().toString();
            this.maskingjob.setMaskingJobId(maskingjob.getMaskingJobId());
            if (replace) {
                MaskingJob tmp = Utils.getClassFromJson(body, MaskingJob.class);
                tmp.setMaskingJobId(maskingjob.getMaskingJobId());
                PutMaskingJob putMaskingJob = new PutMaskingJob(tmp);
                apiCallDriver.makePutCall(putMaskingJob);
            }
        }
    }
    public PostMaskingJob(MaskingJob maskingjob, Integer parentId) {
        maskingjob.setRulesetId(parentId);
        this.parentId = parentId;
        this.maskingjob = maskingjob;

        body = Utils.getJSONFromClass(maskingjob);
        name = maskingjob.getJobName();


    }
}
