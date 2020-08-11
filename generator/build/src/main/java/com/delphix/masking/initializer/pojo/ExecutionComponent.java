package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ExecutionComponent {

      private Integer executionComponentId;
        private String componentName;
        private Integer executionId;
        private String status;
        private Integer rowsMasked;
        private Integer rowsTotal;
        private String startTime;
        private String endTime;
  
}