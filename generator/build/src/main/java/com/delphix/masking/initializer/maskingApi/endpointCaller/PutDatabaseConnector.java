package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.DatabaseConnector;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutDatabaseConnector extends PutApiCall {

    private static final String Post_DATABASE_CONNECTOR_PATH = "database-connectors/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, DatabaseConnector.class).getDatabaseConnectorId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_DATABASE_CONNECTOR_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutDatabaseConnector(DatabaseConnector databaseConnector) {
        body = Utils.getJSONFromClass(databaseConnector);
        name = databaseConnector.getConnectorName();
        id = databaseConnector.getDatabaseConnectorId().toString();
            }
}
