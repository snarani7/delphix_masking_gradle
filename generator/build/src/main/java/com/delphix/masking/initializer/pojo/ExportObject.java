package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ExportObject {

      private ExportResponseMetadata exportResponseMetadata;
        private String blob;
        private String signature;
        private String publicKey;
  
}