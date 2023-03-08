package com.michelecossu.appbalance.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResponseCustom<T> {
	
	private String status;
    private Object Payload;
    private Integer errorCode;
    
    @JsonProperty("erroreDes")
    private String erroreDes;

}
