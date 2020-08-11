package com.delphix.masking.initializer.pojo;

import java.util.List;
import lombok.Data;

@Data
public class User {

      private Integer userId;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private Boolean isAdmin;
        private Boolean showWelcome;
        private Boolean isLocked;
        private NonAdminProperties nonAdminProperties;
  
}