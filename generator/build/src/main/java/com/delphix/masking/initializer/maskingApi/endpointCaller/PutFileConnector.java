package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileConnector;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutFileConnector extends PutApiCall {

    private static final String Post_FILE_CONNECTOR_PATH = "file-connectors/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, FileConnector.class).getFileConnectorId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_FILE_CONNECTOR_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutFileConnector(FileConnector fileConnector) {
        body = Utils.getJSONFromClass(fileConnector);
        name = fileConnector.getConnectorName();
        id = fileConnector.getFileConnectorId().toString();
            }
}
