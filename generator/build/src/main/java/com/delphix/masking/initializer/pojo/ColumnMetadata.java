package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ColumnMetadata {

      private Integer columnMetadataId;
        private String columnName;
        private Integer tableMetadataId;
        private String algorithmName;
        private String domainName;
        private Integer columnLength;
        private Boolean isMasked;
        private Boolean isPrimaryKey;
        private Boolean isIndex;
        private Boolean isForeignKey;
        private String dateFormat;
        private String notes;
        private String xmlDataSource;
        private Integer xmlFileFormatId;
        private Boolean isProfilerWritable;
        private String dataType;
  
}