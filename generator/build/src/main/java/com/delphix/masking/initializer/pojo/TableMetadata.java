package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class TableMetadata {

      private Integer tableMetadataId;
        private String tableName;
        private Integer rulesetId;
        private String customSql;
        private String whereClause;
        private String havingClause;
        private String keyColumn;
        private List<ColumnMetadata> columnMetadatas;
  
}