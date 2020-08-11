package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileMetadata;
import com.delphix.masking.initializer.pojo.FileMetadataList;

import java.util.ArrayList;
import lombok.Setter;

public class GetFileMetadatas extends GetApiCall {

    private static final String GET_FILE_METADATA_PATH = "file-metadata";
    private FileMetadataList fileMetadataList;
    private ArrayList fileMetadataArray;

          @Setter Integer ruleset_id;
    
    @Override
    protected void setResponse(String responseBody) {
        if (fileMetadataArray == null) {
           fileMetadataArray = new ArrayList<>();
        }

        fileMetadataList = Utils.getClassFromJson(responseBody, FileMetadataList.class);
        fileMetadataArray.addAll(fileMetadataList.getResponseList());
        currentSize = fileMetadataArray.size();
        if (total == null) {
            total = fileMetadataList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_FILE_METADATA_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (ruleset_id != null) {
            path += "&&ruleset_id=" + ruleset_id;
          }
                return path;
    }

    public ArrayList<FileMetadata> getFileMetadatas() {
        return fileMetadataArray;
    }
}