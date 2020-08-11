package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.DatabaseConnector;
import com.delphix.masking.initializer.pojo.DatabaseRuleset;
import java.util.List;

public class PostDatabaseConnector extends PostApiCall {

    private static final String Post_DATABASE_CONNECTOR_PATH = "database-connectors";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, DatabaseConnector.class).getDatabaseConnectorId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_DATABASE_CONNECTOR_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetDatabaseConnectors getDatabaseConnectors = new GetDatabaseConnectors();
        apiCallDriver.makeGetCall(getDatabaseConnectors);
        for (DatabaseConnector databaseConnector: getDatabaseConnectors.getDatabaseConnectors()) {
            if (!databaseConnector.getConnectorName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!databaseConnector.getEnvironmentId().equals(parentId)) {
                continue;
            }
            id = databaseConnector.getDatabaseConnectorId().toString();
            if (replace) {
                DatabaseConnector tmp = Utils.getClassFromJson(body, DatabaseConnector.class);
                tmp.setDatabaseConnectorId(databaseConnector.getDatabaseConnectorId());
                PutDatabaseConnector putDatabaseConnector = new PutDatabaseConnector(tmp);
                apiCallDriver.makePutCall(putDatabaseConnector);
            }
        }
    }
    public PostDatabaseConnector(DatabaseConnector databaseConnector, Integer parentId) {
        databaseConnector.setEnvironmentId(parentId);
        this.parentId = parentId;

        List<DatabaseRuleset> databaseRulesets = databaseConnector.getDatabaseRulesets();
        databaseConnector.setDatabaseRulesets(null);
        List<String> databaseRulesetFiles = databaseConnector.getDatabaseRulesetFiles();
        databaseConnector.setDatabaseRulesetFiles(null);

        body = Utils.getJSONFromClass(databaseConnector);
        name = databaseConnector.getConnectorName();

        databaseConnector.setDatabaseRulesets(databaseRulesets);
        databaseConnector.setDatabaseRulesetFiles(databaseRulesetFiles);

    }
}
