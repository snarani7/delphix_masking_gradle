package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileConnector;
import com.delphix.masking.initializer.pojo.FileRuleset;
import java.util.List;

public class PostFileConnector extends PostApiCall {

    private static final String Post_FILE_CONNECTOR_PATH = "file-connectors";
    private FileConnector fileConnector;

    @Override
    public void setResponse(String responseBody) {
        this.fileConnector.setFileConnectorId(Utils.getClassFromJson(responseBody, FileConnector.class).getFileConnectorId());
        id = this.fileConnector.getFileConnectorId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_FILE_CONNECTOR_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetFileConnectors getFileConnectors = new GetFileConnectors();
        apiCallDriver.makeGetCall(getFileConnectors);
        for (FileConnector fileConnector: getFileConnectors.getFileConnectors()) {
            if (!fileConnector.getConnectorName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!fileConnector.getEnvironmentId().equals(parentId)) {
                continue;
            }
            id = fileConnector.getFileConnectorId().toString();
            this.fileConnector.setFileConnectorId(fileConnector.getFileConnectorId());
            if (replace) {
                FileConnector tmp = Utils.getClassFromJson(body, FileConnector.class);
                tmp.setFileConnectorId(fileConnector.getFileConnectorId());
                PutFileConnector putFileConnector = new PutFileConnector(tmp);
                apiCallDriver.makePutCall(putFileConnector);
            }
        }
    }
    public PostFileConnector(FileConnector fileConnector, Integer parentId) {
        fileConnector.setEnvironmentId(parentId);
        this.parentId = parentId;
        this.fileConnector = fileConnector;
        List<FileRuleset> fileRulesets = fileConnector.getFileRulesets();
                        fileConnector.setFileRulesets(null);
        
        body = Utils.getJSONFromClass(fileConnector);
        name = fileConnector.getConnectorName();

        fileConnector.setFileRulesets(fileRulesets);

    }
}
