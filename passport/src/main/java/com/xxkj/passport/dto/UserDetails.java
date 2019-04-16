package com.xxkj.passport.dto;

import lombok.Data;

@Data
public class UserDetails {
    private String grant_type;
    private String username;
    private String password;
    private String client_id;
    private String terminal;
}
