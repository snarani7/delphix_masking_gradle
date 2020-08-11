package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileRuleset;
import com.delphix.masking.initializer.pojo.FileMetadata;
import com.delphix.masking.initializer.pojo.MaskingJob;
import com.delphix.masking.initializer.pojo.ProfilingJob;
import java.util.List;

public class PostFileRuleset extends PostApiCall {

    private static final String Post_FILE_RULESET_PATH = "file-rulesets";

    @Override
    public void setResponse(String responseBody) {
        id = Utils.getClassFromJson(responseBody, FileRuleset.class).getFileRulesetId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_FILE_RULESET_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetFileRulesets getFileRulesets = new GetFileRulesets();
        apiCallDriver.makeGetCall(getFileRulesets);
        for (FileRuleset fileRuleset: getFileRulesets.getFileRulesets()) {
            if (!fileRuleset.getRulesetName().equalsIgnoreCase(name)) {
                continue;
            }
            id = fileRuleset.getFileRulesetId().toString();
        }
    }
    public PostFileRuleset(FileRuleset fileRuleset) {

        List<FileMetadata> fileMetadatas = fileRuleset.getFileMetadatas();
        fileRuleset.setFileMetadatas(null);
        List<MaskingJob> maskingJobs = fileRuleset.getMaskingJobs();
        fileRuleset.setMaskingJobs(null);
        List<ProfilingJob> profilingJobs = fileRuleset.getProfilingJobs();
        fileRuleset.setProfilingJobs(null);

        body = Utils.getJSONFromClass(fileRuleset);
        name = fileRuleset.getRulesetName();

        fileRuleset.setFileMetadatas(fileMetadatas);
        fileRuleset.setMaskingJobs(maskingJobs);
        fileRuleset.setProfilingJobs(profilingJobs);

    }
}
