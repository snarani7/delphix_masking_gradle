package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class Application {

      private String applicationName;
        private List<Environment> environments;
        private List<String> environmentFiles;
  
}