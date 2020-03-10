package com.iab.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Employee implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;

}
