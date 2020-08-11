package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ExportResponseMetadata {

      private String exportHost;
        private String exportDate;
        private ExportObjectMetadata[] exportedObjectList;
  
}