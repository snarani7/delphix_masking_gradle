package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.TableMetadata;
import com.delphix.masking.initializer.pojo.TableMetadataList;

import java.util.ArrayList;
import lombok.Setter;

public class GetTableMetadatas extends GetApiCall {

    private static final String GET_TABLE_METADATA_PATH = "table-metadata";
    private TableMetadataList tableMetadataList;
    private ArrayList tableMetadataArray;

          @Setter Integer ruleset_id;
    
    @Override
    protected void setResponse(String responseBody) {
        if (tableMetadataArray == null) {
           tableMetadataArray = new ArrayList<>();
        }

        tableMetadataList = Utils.getClassFromJson(responseBody, TableMetadataList.class);
        tableMetadataArray.addAll(tableMetadataList.getResponseList());
        currentSize = tableMetadataArray.size();
        if (total == null) {
            total = tableMetadataList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_TABLE_METADATA_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (ruleset_id != null) {
            path += "&&ruleset_id=" + ruleset_id;
          }
                return path;
    }

    public ArrayList<TableMetadata> getTableMetadatas() {
        return tableMetadataArray;
    }
}