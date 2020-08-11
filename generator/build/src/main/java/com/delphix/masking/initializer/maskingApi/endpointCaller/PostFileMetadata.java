package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileMetadata;
import java.util.List;

public class PostFileMetadata extends PostApiCall {

    private static final String Post_FILE_METADATA_PATH = "file-metadata";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, FileMetadata.class).getFileMetadataId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_FILE_METADATA_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetFileMetadatas getFileMetadatas = new GetFileMetadatas();
        apiCallDriver.makeGetCall(getFileMetadatas);
        for (FileMetadata fileMetadata: getFileMetadatas.getFileMetadatas()) {
            if (!fileMetadata.getFileName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!fileMetadata.getRulesetId().equals(parentId)) {
                continue;
            }
            id = fileMetadata.getFileMetadataId().toString();
            if (replace) {
                FileMetadata tmp = Utils.getClassFromJson(body, FileMetadata.class);
                tmp.setFileMetadataId(fileMetadata.getFileMetadataId());
                PutFileMetadata putFileMetadata = new PutFileMetadata(tmp);
                apiCallDriver.makePutCall(putFileMetadata);
            }
        }
    }
    public PostFileMetadata(FileMetadata fileMetadata, Integer parentId) {
        fileMetadata.setRulesetId(parentId);
        this.parentId = parentId;


        body = Utils.getJSONFromClass(fileMetadata);
        name = fileMetadata.getFileName();


    }
}
