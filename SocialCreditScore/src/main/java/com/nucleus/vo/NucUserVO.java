/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nucleus.vo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author sandesh
 */
@Getter 
@Setter 
@ToString
public class NucUserVO {
    private String nucUserId;
    private String nucUserName;
    private List<String> nucUserMobile;
    private List<String> nucUserEmail;
}
