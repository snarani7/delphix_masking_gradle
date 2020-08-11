package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.FileRuleset;
import com.delphix.masking.initializer.pojo.FileRulesetList;

import java.util.ArrayList;
import lombok.Setter;

public class GetFileRulesets extends GetApiCall {

    private static final String GET_FILE_RULESET_PATH = "file-rulesets";
    private FileRulesetList fileRulesetList;
    private ArrayList fileRulesetArray;

    
    @Override
    protected void setResponse(String responseBody) {
        if (fileRulesetArray == null) {
           fileRulesetArray = new ArrayList<>();
        }

        fileRulesetList = Utils.getClassFromJson(responseBody, FileRulesetList.class);
        fileRulesetArray.addAll(fileRulesetList.getResponseList());
        currentSize = fileRulesetArray.size();
        if (total == null) {
            total = fileRulesetList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_FILE_RULESET_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                return path;
    }

    public ArrayList<FileRuleset> getFileRulesets() {
        return fileRulesetArray;
    }
}