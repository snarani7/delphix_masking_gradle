package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class DatabaseMaskingOptions {

      private Boolean batchUpdate;
        private Boolean bulkData;
        private Integer commitSize;
        private Boolean disableTriggers;
        private Boolean dropIndexes;
        private Boolean disableConstraints;
        private Integer numOutputThreadsPerStream;
        private Boolean truncateTables;
        private MaskingJobScript prescript;
        private MaskingJobScript postscript;
  
}