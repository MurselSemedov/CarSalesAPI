package com.mursalsamad.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError <T>{

    private int status;
    private Exception<T> exception;

}
