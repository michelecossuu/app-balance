package com.michelecossu.appbalance.controller;

import com.michelecossu.appbalance.controller.response.ResponseCustom;

public class BaseController {
	
	protected <T> ResponseCustom buildSuccessResponse(T data) {
		ResponseCustom response = new ResponseCustom();
		response.setStatus("success");
		response.setPayload(data);
		return response;
	}
	
	protected ResponseCustom buildErrorResponse(Integer errCode, String errDes) {
		ResponseCustom response = new ResponseCustom();
		response.setStatus("error");
		response.setErrorCode(errCode);
		response.setErroreDes(errDes);
		return response;
	}

}
