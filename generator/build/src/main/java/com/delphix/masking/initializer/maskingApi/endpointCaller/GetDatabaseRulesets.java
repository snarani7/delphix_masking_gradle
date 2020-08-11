package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Constants;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.DatabaseRuleset;
import com.delphix.masking.initializer.pojo.DatabaseRulesetList;

import java.util.ArrayList;
import lombok.Setter;

public class GetDatabaseRulesets extends GetApiCall {

    private static final String GET_DATABASE_RULESET_PATH = "database-rulesets";
    private DatabaseRulesetList databaseRulesetList;
    private ArrayList databaseRulesetArray;

          @Setter Integer environment_id;
    
    @Override
    protected void setResponse(String responseBody) {
        if (databaseRulesetArray == null) {
           databaseRulesetArray = new ArrayList<>();
        }

        databaseRulesetList = Utils.getClassFromJson(responseBody, DatabaseRulesetList.class);
        databaseRulesetArray.addAll(databaseRulesetList.getResponseList());
        currentSize = databaseRulesetArray.size();
        if (total == null) {
            total = databaseRulesetList.getPageInfo().getTotal();
        }

    }

    @Override
    protected String getEndpoint(int pageNumber) {
        String path = GET_DATABASE_RULESET_PATH + "?page_size=" + Constants.PAGE_SIZE + "&&page_number=" + pageNumber;
                  if (environment_id != null) {
            path += "&&environment_id=" + environment_id;
          }
                return path;
    }

    public ArrayList<DatabaseRuleset> getDatabaseRulesets() {
        return databaseRulesetArray;
    }
}