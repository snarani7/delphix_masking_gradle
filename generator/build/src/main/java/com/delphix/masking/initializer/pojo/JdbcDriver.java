package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class JdbcDriver {

      private Integer jdbcDriverId;
        private String driverName;
        private String driverClassName;
        private String description;
        private String version;
        private String uploadedBy;
        private String uploadDate;
        private String checksum;
        private Boolean builtIn;
        private Boolean loggerInstalled;
        private String fileReferenceId;
        private List<JvmPermission> pluginJvmPermissions;
  
}