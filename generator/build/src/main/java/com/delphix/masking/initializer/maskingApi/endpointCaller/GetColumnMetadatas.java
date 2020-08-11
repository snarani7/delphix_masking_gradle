package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ColumnMetadata;
import com.delphix.masking.initializer.pojo.ColumnMetadataList;

import java.util.ArrayList;
import lombok.Setter;

public class GetColumnMetadatas extends GetApiCall {

    private static final String GET_COLUMN_METADATA_PATH = "column-metadata";
    private ColumnMetadataList columnMetadataList;
    private ArrayList columnMetadataArray;

          @Setter Integer table_metadata_id;
          @Setter Boolean is_masked;
    
    @Override
    protected void setResponse(String responseBody) {
        if (columnMetadataArray == null) {
           columnMetadataArray = new ArrayList<>();
        }

        columnMetadataList = Utils.getClassFromJson(responseBody, ColumnMetadataList.class);
        columnMetadataArray.addAll(columnMetadataList.getResponseList());
        currentSize = columnMetadataArray.size();
        if (total == null) {
            total = columnMetadataList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_COLUMN_METADATA_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (table_metadata_id != null) {
            path += "&&table_metadata_id=" + table_metadata_id;
          }
                  if (is_masked != null) {
            path += "&&is_masked=" + is_masked;
          }
                return path;
    }

    public ArrayList<ColumnMetadata> getColumnMetadatas() {
        return columnMetadataArray;
    }
}