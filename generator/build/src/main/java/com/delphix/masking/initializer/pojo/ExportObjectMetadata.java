package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ExportObjectMetadata {

      private ObjectIdentifier objectIdentifier;
        private String objectType;
        private String revisionHash;
  
}