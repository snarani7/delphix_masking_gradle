package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class Environment {

      private String environmentName;
        private Boolean isWorkflowEnabled;
        private Integer environmentId;
        private String application;
        private String purpose;
        private List<DatabaseConnector> databaseConnectors;
        private List<FileConnector> fileConnectors;
  
}