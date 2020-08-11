package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class NonAdminProperties {

      private Integer roleId;
        private List<Integer> environmentIds;
  
}