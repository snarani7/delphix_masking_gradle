package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class JvmPermission {

      private String className;
        private String target;
        private String action;
  
}