package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileFieldMetadata;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutFileFieldMetadata extends PutApiCall {

    private static final String Post_FILE_FIELD_METADATA_PATH = "file-field-metadata/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, FileFieldMetadata.class).getFileFieldMetadataId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_FILE_FIELD_METADATA_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutFileFieldMetadata(FileFieldMetadata fileFieldMetadata) {
        body = Utils.getJSONFromClass(fileFieldMetadata);
        name = fileFieldMetadata.getFieldName();
        id = fileFieldMetadata.getFileFieldMetadataId().toString();
            }
}
