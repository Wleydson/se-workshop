package com.wleydsonlemos.apiservicos.api.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseError {

    private Integer status;
    private OffsetDateTime dateTime;
    private String error;
    private List<FieldsError> fieldsError;
}
