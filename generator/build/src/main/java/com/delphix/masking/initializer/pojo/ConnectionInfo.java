package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ConnectionInfo {

      private String connectionMode;
        private String path;
        private String host;
        private String loginName;
        private String password;
        private Integer port;
        private String sshKey;
        private Integer mountId;
        private String mountName;
  
}