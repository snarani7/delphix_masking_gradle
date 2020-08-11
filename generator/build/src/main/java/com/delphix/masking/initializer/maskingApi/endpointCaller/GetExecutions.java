package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Execution;
import com.delphix.masking.initializer.pojo.ExecutionList;

import java.util.ArrayList;
import lombok.Setter;

public class GetExecutions extends GetApiCall {

    private static final String GET_EXECUTION_PATH = "executions";
    private ExecutionList executionList;
    private ArrayList executionArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (executionArray == null) {
           executionArray = new ArrayList<>();
        }

        executionList = Utils.getClassFromJson(responseBody, ExecutionList.class);
        executionArray.addAll(executionList.getResponseList());
        currentSize = executionArray.size();
        if (total == null) {
            total = executionList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_EXECUTION_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<Execution> getExecutions() {
        return executionArray;
    }
}