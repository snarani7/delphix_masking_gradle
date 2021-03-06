package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.Domain;
import java.util.List;

public class PostDomain extends PostApiCall {

    private static final String Post_DOMAIN_PATH = "domains";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, Domain.class).getDomainName().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_DOMAIN_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetDomains getDomains = new GetDomains();
        apiCallDriver.makeGetCall(getDomains);
        for (Domain domain: getDomains.getDomains()) {
            if (!domain.getDomainName().equalsIgnoreCase(name)) {
                continue;
            }
            id = domain.getDomainName().toString();
            if (replace) {
                Domain tmp = Utils.getClassFromJson(body, Domain.class);
                tmp.setDomainName(domain.getDomainName());
                PutDomain putDomain = new PutDomain(tmp);
                apiCallDriver.makePutCall(putDomain);
            }
        }
    }
    public PostDomain(Domain domain) {


        body = Utils.getJSONFromClass(domain);
        name = domain.getDomainName();


    }
}
