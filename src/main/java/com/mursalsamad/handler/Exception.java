package com.mursalsamad.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception <T>{

    private String host;
    private String url;
    private Date createTime;
    private T errorMessage;
}
