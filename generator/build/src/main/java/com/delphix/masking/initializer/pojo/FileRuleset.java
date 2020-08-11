package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class FileRuleset {

      private Integer fileRulesetId;
        private String rulesetName;
        private Integer fileConnectorId;
        private Integer environmentId;
        private List<FileMetadata> fileMetadatas;
        private List<MaskingJob> maskingJobs;
        private List<ProfilingJob> profilingJobs;
  
}