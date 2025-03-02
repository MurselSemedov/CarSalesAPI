package com.mursalsamad.handler;

import com.mursalsamad.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list , String value){
        list.add(value);
        return list;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String,List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception , WebRequest request){
        Map<String, List<String>> map = new HashMap<>();
        for (ObjectError error : exception.getBindingResult().getAllErrors()){
            String field = ((FieldError) error).getField();
            if(map.containsKey(field)){
                map.put(field,addMapValue(map.get(field),error.getDefaultMessage()));
            }else{
                map.put(field,addMapValue(new ArrayList<>(),error.getDefaultMessage()));
            }
        }
        return ResponseEntity.badRequest().body(createApiError(map,request));
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<String>> handleBaseException(BaseException baseException, WebRequest request){
        return ResponseEntity.badRequest().body(createApiError(baseException.getMessage(),request));
    }

    private String getHost(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
    private <T> ApiError<T> createApiError(T errorDetails,WebRequest request){
        ApiError<T> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        Exception<T> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setErrorMessage(errorDetails);
        exception.setHost(getHost());
        exception.setUrl(request.getDescription(false));
        apiError.setException(exception);
        return apiError;
    }
}
