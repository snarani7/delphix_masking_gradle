package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class SystemInformation {

      private String version;
        private String build;
        private String latestGlobalKeyResetTime;
        private List<String> patentNumbers;
  
}