package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.MountInformation;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;


public class PutMountInformation extends PutApiCall {

    private static final String Post_MOUNT_INFORMATION_PATH = "mount-filesystem/";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, MountInformation.class).getMountId().toString();
    }

    @Override
    public String getEndpoint() {
        try {
            return Post_MOUNT_INFORMATION_PATH + URLEncoder.encode(id, "ISO-8859-1").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public PutMountInformation(MountInformation mountInformation) {
        body = Utils.getJSONFromClass(mountInformation);
        name = mountInformation.getMountName();
        id = mountInformation.getMountId().toString();
            }
}
