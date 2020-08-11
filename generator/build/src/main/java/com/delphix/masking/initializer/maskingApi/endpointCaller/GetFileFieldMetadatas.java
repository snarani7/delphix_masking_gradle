package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileFieldMetadata;
import com.delphix.masking.initializer.pojo.FileFieldMetadataList;

import java.util.ArrayList;
import lombok.Setter;

public class GetFileFieldMetadatas extends GetApiCall {

    private static final String GET_FILE_FIELD_METADATA_PATH = "file-field-metadata";
    private FileFieldMetadataList fileFieldMetadataList;
    private ArrayList fileFieldMetadataArray;

          @Setter Integer file_format_id;
          @Setter Boolean is_masked;
    
    @Override
    protected void setResponse(String responseBody) {
        if (fileFieldMetadataArray == null) {
           fileFieldMetadataArray = new ArrayList<>();
        }

        fileFieldMetadataList = Utils.getClassFromJson(responseBody, FileFieldMetadataList.class);
        fileFieldMetadataArray.addAll(fileFieldMetadataList.getResponseList());
        currentSize = fileFieldMetadataArray.size();
        if (total == null) {
            total = fileFieldMetadataList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_FILE_FIELD_METADATA_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (file_format_id != null) {
            path += "&&file_format_id=" + file_format_id;
          }
                  if (is_masked != null) {
            path += "&&is_masked=" + is_masked;
          }
                return path;
    }

    public ArrayList<FileFieldMetadata> getFileFieldMetadatas() {
        return fileFieldMetadataArray;
    }
}