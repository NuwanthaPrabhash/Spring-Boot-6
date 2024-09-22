package com.nuwantha.springboot.securityConfigurations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users", schema = "system")
public class Users {
    @Id
    private Integer userSeq;
    private String username;
    private String password;
}
