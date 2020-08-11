package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.ColumnMetadata;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutColumnMetadata extends PutApiCall {

    private static final String Post_COLUMN_METADATA_PATH = "column-metadata/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, ColumnMetadata.class).getColumnMetadataId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_COLUMN_METADATA_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutColumnMetadata(ColumnMetadata columnMetadata) {
        body = Utils.getJSONFromClass(columnMetadata);
        name = columnMetadata.getColumnName();
        id = columnMetadata.getColumnMetadataId().toString();
            }
}
