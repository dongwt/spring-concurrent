package com.dongwt.concurrent.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    
    private static final long serialVersionUID = 1L;
    
    private String userName;
    
    
    private String passWord;
}
