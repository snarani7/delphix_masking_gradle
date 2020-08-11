package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class DatabaseRuleset {

      private Integer databaseRulesetId;
        private String rulesetName;
        private Integer databaseConnectorId;
        private Integer environmentId;
        private List<TableMetadata> tableMetadatas;
        private List<MaskingJob> maskingJobs;
        private List<ProfilingJob> profilingJobs;
        private List<String> tableMetadataFiles;
  
}