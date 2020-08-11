package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.MaskingJob;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutMaskingJob extends PutApiCall {

    private static final String Post_MASKING_JOB_PATH = "masking-jobs/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, MaskingJob.class).getMaskingJobId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_MASKING_JOB_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutMaskingJob(MaskingJob maskingjob) {
        body = Utils.getJSONFromClass(maskingjob);
        name = maskingjob.getJobName();
        id = maskingjob.getMaskingJobId().toString();
            }
}
