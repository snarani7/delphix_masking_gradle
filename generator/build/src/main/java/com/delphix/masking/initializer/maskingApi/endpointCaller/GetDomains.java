package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Domain;
import com.delphix.masking.initializer.pojo.DomainList;

import java.util.ArrayList;
import lombok.Setter;

public class GetDomains extends GetApiCall {

    private static final String GET_DOMAIN_PATH = "domains";
    private DomainList domainList;
    private ArrayList domainArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (domainArray == null) {
           domainArray = new ArrayList<>();
        }

        domainList = Utils.getClassFromJson(responseBody, DomainList.class);
        domainArray.addAll(domainList.getResponseList());
        currentSize = domainArray.size();
        if (total == null) {
            total = domainList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_DOMAIN_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<Domain> getDomains() {
        return domainArray;
    }
}