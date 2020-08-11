package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ExecutionComponent;
import com.delphix.masking.initializer.pojo.ExecutionComponentList;

import java.util.ArrayList;
import lombok.Setter;

public class GetExecutionComponents extends GetApiCall {

    private static final String GET_EXECUTION_COMPONENT_PATH = "execution-components";
    private ExecutionComponentList executionComponentList;
    private ArrayList executionComponentArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (executionComponentArray == null) {
           executionComponentArray = new ArrayList<>();
        }

        executionComponentList = Utils.getClassFromJson(responseBody, ExecutionComponentList.class);
        executionComponentArray.addAll(executionComponentList.getResponseList());
        currentSize = executionComponentArray.size();
        if (total == null) {
            total = executionComponentList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_EXECUTION_COMPONENT_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<ExecutionComponent> getExecutionComponents() {
        return executionComponentArray;
    }
}