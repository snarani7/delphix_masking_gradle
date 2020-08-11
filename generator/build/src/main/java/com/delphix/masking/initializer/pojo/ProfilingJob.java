package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ProfilingJob {

      private Integer profileJobId;
        private String jobName;
        private String profileSetName;
        private Integer profileSetId;
        private Integer rulesetId;
        private String createdBy;
        private String createdTime;
        private String email;
        private Integer environmentId;
        private Integer feedbackSize;
        private String jobDescription;
        private Integer maxMemory;
        private Integer minMemory;
        private Boolean multiTenant;
        private Integer numInputStreams;
  
}