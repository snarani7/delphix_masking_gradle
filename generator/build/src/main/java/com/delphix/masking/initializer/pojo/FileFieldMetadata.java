package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class FileFieldMetadata {

      private Integer fileFieldMetadataId;
        private Integer fileFormatId;
        private Integer fieldLength;
        private String fieldName;
        private Integer fieldPositionNumber;
        private String algorithmName;
        private String domainName;
        private String dateFormat;
        private Boolean isMasked;
        private Boolean isProfilerWritable;
        private String notes;
  
}