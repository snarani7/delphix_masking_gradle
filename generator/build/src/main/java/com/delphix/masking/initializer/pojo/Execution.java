package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class Execution {

      private Integer executionId;
        private Integer jobId;
        private Integer sourceConnectorId;
        private Integer targetConnectorId;
        private String status;
        private Integer rowsMasked;
        private Integer rowsTotal;
        private String startTime;
        private String endTime;
        private List<ExecutionComponent> executionComponent;
  
}