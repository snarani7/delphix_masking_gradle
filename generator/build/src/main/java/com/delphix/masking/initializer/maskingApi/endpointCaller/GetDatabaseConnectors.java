package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.DatabaseConnector;
import com.delphix.masking.initializer.pojo.DatabaseConnectorList;

import java.util.ArrayList;
import lombok.Setter;

public class GetDatabaseConnectors extends GetApiCall {

    private static final String GET_DATABASE_CONNECTOR_PATH = "database-connectors";
    private DatabaseConnectorList databaseConnectorList;
    private ArrayList databaseConnectorArray;

          @Setter Integer environmentId;
    
    @Override
    protected void setResponse(String responseBody) {
        if (databaseConnectorArray == null) {
           databaseConnectorArray = new ArrayList<>();
        }

        databaseConnectorList = Utils.getClassFromJson(responseBody, DatabaseConnectorList.class);
        databaseConnectorArray.addAll(databaseConnectorList.getResponseList());
        currentSize = databaseConnectorArray.size();
        if (total == null) {
            total = databaseConnectorList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_DATABASE_CONNECTOR_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (environmentId != null) {
            path += "&&environmentId=" + environmentId;
          }
                return path;
    }

    public ArrayList<DatabaseConnector> getDatabaseConnectors() {
        return databaseConnectorArray;
    }
}