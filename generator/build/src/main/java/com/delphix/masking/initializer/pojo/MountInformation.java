package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class MountInformation {

      private Integer mountId;
        private String mountName;
        private String hostAddress;
        private String mountPath;
        private String type;
        private Boolean connectOnStartup;
        private String options;
        private String status;
  
}