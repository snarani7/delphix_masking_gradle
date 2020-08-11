package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class MaskingJob {

      private Integer maskingJobId;
        private String jobName;
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
        private Boolean onTheFlyMasking;
        private DatabaseMaskingOptions databaseMaskingOptions;
        private OnTheFlyMaskingSource onTheFlyMaskingSource;
  
}