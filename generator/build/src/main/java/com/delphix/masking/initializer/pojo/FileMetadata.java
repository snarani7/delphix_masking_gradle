package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class FileMetadata {

      private Integer fileMetadataId;
        private String fileName;
        private Integer rulesetId;
        private Integer fileFormatId;
        private String fileType;
        private String delimiter;
        private String enclosure;
        private String endOfRecord;
        private Boolean nameIsRegularExpression;
        private String fileFormatName;
  
}