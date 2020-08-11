package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Domain;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutDomain extends PutApiCall {

    private static final String Post_DOMAIN_PATH = "domains/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, Domain.class).getDomainName().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_DOMAIN_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutDomain(Domain domain) {
        body = Utils.getJSONFromClass(domain);
        name = domain.getDomainName();
        id = domain.getDomainName().toString();
            }
}
