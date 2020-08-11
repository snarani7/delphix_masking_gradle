package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.JdbcDriver;
import com.delphix.masking.initializer.pojo.JvmPermission;
import java.util.List;

public class PostJdbcDriver extends PostApiCall {

    private static final String Post_JDBC_DRIVER_PATH = "jdbc-drivers";
    private JdbcDriver jdbcDriver;

    @Override
    public void setResponse(String responseBody) {
        this.jdbcDriver.setJdbcDriverId(Utils.getClassFromJson(responseBody, JdbcDriver.class).getJdbcDriverId());
        id = this.jdbcDriver.getJdbcDriverId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_JDBC_DRIVER_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetJdbcDrivers getJdbcDrivers = new GetJdbcDrivers();
        apiCallDriver.makeGetCall(getJdbcDrivers);
        for (JdbcDriver jdbcDriver: getJdbcDrivers.getJdbcDrivers()) {
            if (!jdbcDriver.getDriverName().equalsIgnoreCase(name)) {
                continue;
            }
            id = jdbcDriver.getJdbcDriverId().toString();
            this.jdbcDriver.setJdbcDriverId(jdbcDriver.getJdbcDriverId());
            if (replace) {
                JdbcDriver tmp = Utils.getClassFromJson(body, JdbcDriver.class);
                tmp.setJdbcDriverId(jdbcDriver.getJdbcDriverId());
                PutJdbcDriver putJdbcDriver = new PutJdbcDriver(tmp);
                apiCallDriver.makePutCall(putJdbcDriver);
            }
        }
    }
    public PostJdbcDriver(JdbcDriver jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
        List<JvmPermission> pluginJvmPermissions = jdbcDriver.getPluginJvmPermissions();
                        jdbcDriver.setPluginJvmPermissions(null);
        
        body = Utils.getJSONFromClass(jdbcDriver);
        name = jdbcDriver.getDriverName();

        jdbcDriver.setPluginJvmPermissions(pluginJvmPermissions);

    }
}
