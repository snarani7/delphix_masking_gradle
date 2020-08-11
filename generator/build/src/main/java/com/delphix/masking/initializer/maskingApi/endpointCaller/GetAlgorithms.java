package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Algorithm;
import com.delphix.masking.initializer.pojo.AlgorithmList;

import java.util.ArrayList;
import lombok.Setter;

public class GetAlgorithms extends GetApiCall {

    private static final String GET_ALGORITHM_PATH = "algorithms";
    private AlgorithmList algorithmList;
    private ArrayList algorithmArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (algorithmArray == null) {
           algorithmArray = new ArrayList<>();
        }

        algorithmList = Utils.getClassFromJson(responseBody, AlgorithmList.class);
        algorithmArray.addAll(algorithmList.getResponseList());
        currentSize = algorithmArray.size();
        if (total == null) {
            total = algorithmList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_ALGORITHM_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<Algorithm> getAlgorithms() {
        return algorithmArray;
    }
}