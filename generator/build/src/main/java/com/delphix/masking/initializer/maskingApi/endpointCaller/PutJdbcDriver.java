package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.JdbcDriver;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutJdbcDriver extends PutApiCall {

    private static final String Post_JDBC_DRIVER_PATH = "jdbc-drivers/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, JdbcDriver.class).getJdbcDriverId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_JDBC_DRIVER_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutJdbcDriver(JdbcDriver jdbcDriver) {
        body = Utils.getJSONFromClass(jdbcDriver);
        name = jdbcDriver.getDriverName();
        id = jdbcDriver.getJdbcDriverId().toString();
            }
}
