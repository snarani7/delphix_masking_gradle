package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class FileConnector {

      private Integer fileConnectorId;
        private String connectorName;
        private Integer environmentId;
        private String fileType;
        private String purpose;
        private ConnectionInfo connectionInfo;
        private List<FileRuleset> fileRulesets;
  
}