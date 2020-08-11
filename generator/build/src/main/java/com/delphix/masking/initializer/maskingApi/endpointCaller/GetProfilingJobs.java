package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ProfilingJob;
import com.delphix.masking.initializer.pojo.ProfilingJobList;

import java.util.ArrayList;
import lombok.Setter;

public class GetProfilingJobs extends GetApiCall {

    private static final String GET_PROFILING_JOB_PATH = "profile-jobs";
    private ProfilingJobList profilingjobList;
    private ArrayList profilingjobArray;

          @Setter Integer environment_id;
    
    @Override
    protected void setResponse(String responseBody) {
        if (profilingjobArray == null) {
           profilingjobArray = new ArrayList<>();
        }

        profilingjobList = Utils.getClassFromJson(responseBody, ProfilingJobList.class);
        profilingjobArray.addAll(profilingjobList.getResponseList());
        currentSize = profilingjobArray.size();
        if (total == null) {
            total = profilingjobList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_PROFILING_JOB_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (environment_id != null) {
            path += "&&environment_id=" + environment_id;
          }
                return path;
    }

    public ArrayList<ProfilingJob> getProfilingJobs() {
        return profilingjobArray;
    }
}