package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ProfileExpression {

      private Integer profileExpressionId;
        private String domainName;
        private String expressionName;
        private String regularExpression;
        private String createdBy;
        private Boolean dataLevelProfiling;
  
}