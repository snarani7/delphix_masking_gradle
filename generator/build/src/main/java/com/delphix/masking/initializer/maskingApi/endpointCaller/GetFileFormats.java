package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileFormat;
import com.delphix.masking.initializer.pojo.FileFormatList;

import java.util.ArrayList;
import lombok.Setter;

public class GetFileFormats extends GetApiCall {

    private static final String GET_FILE_FORMAT_PATH = "file-formats";
    private FileFormatList fileFormatList;
    private ArrayList fileFormatArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (fileFormatArray == null) {
           fileFormatArray = new ArrayList<>();
        }

        fileFormatList = Utils.getClassFromJson(responseBody, FileFormatList.class);
        fileFormatArray.addAll(fileFormatList.getResponseList());
        currentSize = fileFormatArray.size();
        if (total == null) {
            total = fileFormatList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_FILE_FORMAT_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<FileFormat> getFileFormats() {
        return fileFormatArray;
    }
}