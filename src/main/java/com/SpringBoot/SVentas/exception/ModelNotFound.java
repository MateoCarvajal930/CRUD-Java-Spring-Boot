package com.SpringBoot.SVentas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFound extends RuntimeException{

    public ModelNotFound(String mensaje){
        super(mensaje);
    }
}
