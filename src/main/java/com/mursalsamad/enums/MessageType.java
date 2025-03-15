package com.mursalsamad.enums;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_FOUND(1001,"The record is not found"),
    GENERAL_ERROR(9999,"Another error occurred");

    final Integer code;
    final String message;

    MessageType(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
