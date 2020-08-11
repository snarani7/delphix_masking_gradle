package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class DatabaseConnector {

      private Integer databaseConnectorId;
        private String connectorName;
        private String databaseType;
        private Integer environmentId;
        private String customDriverName;
        private String databaseName;
        private String host;
        private String instanceName;
        private String jdbc;
        private String password;
        private Integer port;
        private String schemaName;
        private String servicePrincipalName;
        private String sid;
        private String username;
        private Boolean useKerberosAuth;
        private List<DatabaseRuleset> databaseRulesets;
        private List<String> databaseRulesetFiles;
  
}