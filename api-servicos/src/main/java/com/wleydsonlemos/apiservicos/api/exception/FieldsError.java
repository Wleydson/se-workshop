package com.wleydsonlemos.apiservicos.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldsError {

    private String name;
    private String message;
}
