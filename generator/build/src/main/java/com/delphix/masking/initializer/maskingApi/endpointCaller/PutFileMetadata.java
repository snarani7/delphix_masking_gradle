package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileMetadata;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutFileMetadata extends PutApiCall {

    private static final String Post_FILE_METADATA_PATH = "file-metadata/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, FileMetadata.class).getFileMetadataId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_FILE_METADATA_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutFileMetadata(FileMetadata fileMetadata) {
        body = Utils.getJSONFromClass(fileMetadata);
        name = fileMetadata.getFileName();
        id = fileMetadata.getFileMetadataId().toString();
            }
}
