package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.MaskingJob;
import com.delphix.masking.initializer.pojo.MaskingJobList;

import java.util.ArrayList;
import lombok.Setter;

public class GetMaskingJobs extends GetApiCall {

    private static final String GET_MASKING_JOB_PATH = "masking-jobs";
    private MaskingJobList maskingjobList;
    private ArrayList maskingjobArray;

          @Setter Integer environment_id;
    
    @Override
    protected void setResponse(String responseBody) {
        if (maskingjobArray == null) {
           maskingjobArray = new ArrayList<>();
        }

        maskingjobList = Utils.getClassFromJson(responseBody, MaskingJobList.class);
        maskingjobArray.addAll(maskingjobList.getResponseList());
        currentSize = maskingjobArray.size();
        if (total == null) {
            total = maskingjobList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_MASKING_JOB_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (environment_id != null) {
            path += "&&environment_id=" + environment_id;
          }
                return path;
    }

    public ArrayList<MaskingJob> getMaskingJobs() {
        return maskingjobArray;
    }
}