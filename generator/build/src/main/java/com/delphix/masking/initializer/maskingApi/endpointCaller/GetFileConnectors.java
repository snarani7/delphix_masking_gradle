package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileConnector;
import com.delphix.masking.initializer.pojo.FileConnectorList;

import java.util.ArrayList;
import lombok.Setter;

public class GetFileConnectors extends GetApiCall {

    private static final String GET_FILE_CONNECTOR_PATH = "file-connectors";
    private FileConnectorList fileConnectorList;
    private ArrayList fileConnectorArray;

          @Setter Integer environment_id;
    
    @Override
    protected void setResponse(String responseBody) {
        if (fileConnectorArray == null) {
           fileConnectorArray = new ArrayList<>();
        }

        fileConnectorList = Utils.getClassFromJson(responseBody, FileConnectorList.class);
        fileConnectorArray.addAll(fileConnectorList.getResponseList());
        currentSize = fileConnectorArray.size();
        if (total == null) {
            total = fileConnectorList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_FILE_CONNECTOR_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (environment_id != null) {
            path += "&&environment_id=" + environment_id;
          }
                return path;
    }

    public ArrayList<FileConnector> getFileConnectors() {
        return fileConnectorArray;
    }
}