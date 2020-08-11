package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.DatabaseRuleset;
import com.delphix.masking.initializer.pojo.TableMetadata;
import com.delphix.masking.initializer.pojo.MaskingJob;
import com.delphix.masking.initializer.pojo.ProfilingJob;
import java.util.List;

public class PostDatabaseRuleset extends PostApiCall {

    private static final String Post_DATABASE_RULESET_PATH = "database-rulesets";
    private DatabaseRuleset databaseRuleset;

    @Override
    public void setResponse(String responseBody) {
        this.databaseRuleset.setDatabaseRulesetId(Utils.getClassFromJson(responseBody, DatabaseRuleset.class).getDatabaseRulesetId());
        id = this.databaseRuleset.getDatabaseRulesetId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_DATABASE_RULESET_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetDatabaseRulesets getDatabaseRulesets = new GetDatabaseRulesets();
        apiCallDriver.makeGetCall(getDatabaseRulesets);
        for (DatabaseRuleset databaseRuleset: getDatabaseRulesets.getDatabaseRulesets()) {
            if (!databaseRuleset.getRulesetName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!databaseRuleset.getDatabaseConnectorId().equals(parentId)) {
                continue;
            }
            id = databaseRuleset.getDatabaseRulesetId().toString();
            this.databaseRuleset.setDatabaseRulesetId(databaseRuleset.getDatabaseRulesetId());
        }
    }
    public PostDatabaseRuleset(DatabaseRuleset databaseRuleset, Integer parentId) {
        databaseRuleset.setDatabaseConnectorId(parentId);
        this.parentId = parentId;
        this.databaseRuleset = databaseRuleset;
        List<TableMetadata> tableMetadatas = databaseRuleset.getTableMetadatas();
                        databaseRuleset.setTableMetadatas(null);
                List<MaskingJob> maskingJobs = databaseRuleset.getMaskingJobs();
                        databaseRuleset.setMaskingJobs(null);
                List<ProfilingJob> profilingJobs = databaseRuleset.getProfilingJobs();
                        databaseRuleset.setProfilingJobs(null);
                List<String> tableMetadataFiles = databaseRuleset.getTableMetadataFiles();
                        databaseRuleset.setTableMetadataFiles(null);
        
        body = Utils.getJSONFromClass(databaseRuleset);
        name = databaseRuleset.getRulesetName();

        databaseRuleset.setTableMetadatas(tableMetadatas);
        databaseRuleset.setMaskingJobs(maskingJobs);
        databaseRuleset.setProfilingJobs(profilingJobs);
        databaseRuleset.setTableMetadataFiles(tableMetadataFiles);

    }
}
