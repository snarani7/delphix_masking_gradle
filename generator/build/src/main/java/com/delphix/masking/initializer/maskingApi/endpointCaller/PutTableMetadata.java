package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.TableMetadata;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutTableMetadata extends PutApiCall {

    private static final String Post_TABLE_METADATA_PATH = "table-metadata/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, TableMetadata.class).getTableMetadataId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_TABLE_METADATA_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutTableMetadata(TableMetadata tableMetadata) {
        body = Utils.getJSONFromClass(tableMetadata);
        name = tableMetadata.getTableName();
        id = tableMetadata.getTableMetadataId().toString();
            }
}
