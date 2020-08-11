package com.delphix.masking.initializer.maskingApi.endpointCaller;

import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.exception.ApiCallException;
import com.delphix.masking.initializer.Utils;
import com.delphix.masking.initializer.pojo.TableMetadata;
import com.delphix.masking.initializer.pojo.ColumnMetadata;
import java.util.List;

public class PostTableMetadata extends PostApiCall {

    private static final String Post_TABLE_METADATA_PATH = "table-metadata";
    private TableMetadata tableMetadata;

    @Override
    public void setResponse(String responseBody) {
        this.tableMetadata.setTableMetadataId(Utils.getClassFromJson(responseBody, TableMetadata.class).getTableMetadataId());
        id = this.tableMetadata.getTableMetadataId().toString();
    }

    @Override
    public String getEndpoint() {
        return Post_TABLE_METADATA_PATH;
    }

    @Override
    protected void handle409(ApiCallDriver apiCallDriver, String body, boolean replace) throws ApiCallException {
        GetTableMetadatas getTableMetadatas = new GetTableMetadatas();
        apiCallDriver.makeGetCall(getTableMetadatas);
        for (TableMetadata tableMetadata: getTableMetadatas.getTableMetadatas()) {
            if (!tableMetadata.getTableName().equalsIgnoreCase(name)) {
                continue;
            }
            if (!tableMetadata.getRulesetId().equals(parentId)) {
                continue;
            }
            id = tableMetadata.getTableMetadataId().toString();
            this.tableMetadata.setTableMetadataId(tableMetadata.getTableMetadataId());
            if (replace) {
                TableMetadata tmp = Utils.getClassFromJson(body, TableMetadata.class);
                tmp.setTableMetadataId(tableMetadata.getTableMetadataId());
                PutTableMetadata putTableMetadata = new PutTableMetadata(tmp);
                apiCallDriver.makePutCall(putTableMetadata);
            }
        }
    }
    public PostTableMetadata(TableMetadata tableMetadata, Integer parentId) {
        tableMetadata.setRulesetId(parentId);
        this.parentId = parentId;
        this.tableMetadata = tableMetadata;
        List<ColumnMetadata> columnMetadatas = tableMetadata.getColumnMetadatas();
                        tableMetadata.setColumnMetadatas(null);
        
        body = Utils.getJSONFromClass(tableMetadata);
        name = tableMetadata.getTableName();

        tableMetadata.setColumnMetadatas(columnMetadatas);

    }
}
