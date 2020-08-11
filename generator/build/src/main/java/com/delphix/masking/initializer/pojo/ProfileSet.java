package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ProfileSet {

      private Integer profileSetId;
        private String profileSetName;
        private Integer[] profileExpressionIds;
        private String createdBy;
        private String createdTime;
        private String description;
        private List<ProfileExpression> profileExpressions;
        private List<String> profileExpressionNames;
  
}