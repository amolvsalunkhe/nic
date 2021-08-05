package com.nic.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import com.nic.constant.ResponseType;
import com.nic.model.Response;

@RestController
@ControllerAdvice
public class BaseController {
	
	public Response getResponse(Object data, ResponseType responseType) {
        Response response = new Response();
        response.setData(data);
        switch (responseType) {
        case Success: {
            response.setIsSuccess(true);
            response.setMessage(responseType.toString());
            response.setStatus(200);
            break;
        }
        case Error: {
            response.setIsSuccess(false);
            response.setMessage(data.toString());
            response.setStatus(500);
            break;
        }
        case NoData: {
            response.setIsSuccess(false);
            response.setMessage(responseType.toString());
            response.setStatus(204);
            break;
        }
        case Created: {
            response.setIsSuccess(true);
            response.setMessage(responseType.toString());
            response.setStatus(201);
            break;
        }
        }

        return response;
    }
	
}
