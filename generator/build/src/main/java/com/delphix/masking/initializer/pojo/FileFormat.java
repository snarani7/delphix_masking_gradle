package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class FileFormat {

      private Integer fileFormatId;
        private String fileFormatName;
        private String fileFormatType;
        private List<FileFieldMetadata> fileFieldMetadata;
        private List<String> fileFieldMetadataFiles;
  
}