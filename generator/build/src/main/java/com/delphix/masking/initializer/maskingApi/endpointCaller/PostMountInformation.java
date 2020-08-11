package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.MountInformation;
import java.util.List;

public class PostMountInformation extends PostApiCall {

    private static final String Post_MOUNT_INFORMATION_PATH = "mount-filesystem";
    private MountInformation mountInformation;

    @Override
    public void setResponse(String responseBody) {
        this.mountInformation.setMountId(Utils.getClassFromJson(responseBody, MountInformation.class).getMountId());
        id = this.mountInformation.getMountId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_MOUNT_INFORMATION_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetMountInformations getMountInformations = new GetMountInformations();
        apiCallDriver.makeGetCall(getMountInformations);
        for (MountInformation mountInformation: getMountInformations.getMountInformations()) {
            if (!mountInformation.getMountName().equalsIgnoreCase(name)) {
                continue;
            }
            id = mountInformation.getMountId().toString();
            this.mountInformation.setMountId(mountInformation.getMountId());
            if (replace) {
                MountInformation tmp = Utils.getClassFromJson(body, MountInformation.class);
                tmp.setMountId(mountInformation.getMountId());
                PutMountInformation putMountInformation = new PutMountInformation(tmp);
                apiCallDriver.makePutCall(putMountInformation);
            }
        }
    }
    public PostMountInformation(MountInformation mountInformation) {
        this.mountInformation = mountInformation;

        body = Utils.getJSONFromClass(mountInformation);
        name = mountInformation.getMountName();


    }
}
