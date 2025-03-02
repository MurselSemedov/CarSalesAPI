package com.mursalsamad.exception;

import com.mursalsamad.enums.MessageType;

public class ErrorMessage{

    private MessageType messageType;
    private String ofStatic;

    public ErrorMessage(MessageType messageType , String ofStatic){
        this.messageType = messageType;
        this.ofStatic = ofStatic;
    }

    public String prepareErrorMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageType.getMessage());
        if(ofStatic.isEmpty()){
            stringBuilder.
                    append(" : ").
                    append(ofStatic);
        }
        return stringBuilder.toString();
    }

}
