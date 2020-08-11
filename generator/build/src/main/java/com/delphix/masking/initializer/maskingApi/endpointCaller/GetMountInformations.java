package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.MountInformation;
import com.delphix.masking.initializer.pojo.MountInformationList;

import java.util.ArrayList;
import lombok.Setter;

public class GetMountInformations extends GetApiCall {

    private static final String GET_MOUNT_INFORMATION_PATH = "mount-filesystem";
    private MountInformationList mountInformationList;
    private ArrayList mountInformationArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (mountInformationArray == null) {
           mountInformationArray = new ArrayList<>();
        }

        mountInformationList = Utils.getClassFromJson(responseBody, MountInformationList.class);
        mountInformationArray.addAll(mountInformationList.getResponseList());
        currentSize = mountInformationArray.size();
        if (total == null) {
            total = mountInformationList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_MOUNT_INFORMATION_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<MountInformation> getMountInformations() {
        return mountInformationArray;
    }
}