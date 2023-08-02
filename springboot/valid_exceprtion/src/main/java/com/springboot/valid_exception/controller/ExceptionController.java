package com.springboot.valid_exception.controller;

import com.springboot.valid_exception.common.Constants;
import com.springboot.valid_exception.common.exception.CustomException;
import com.springboot.valid_exception.common.exception.CustomExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @GetMapping
    public void getRuntimeException(){
        throw new RuntimeException("컨트롤러 getRuntimeException 메서드 호출");
    }

    @GetMapping("/custom")
    public void getCustomException()throws CustomException {
        throw new CustomException(Constants.ExceptionClass.PRODUCT, HttpStatus.UNAUTHORIZED, "getcustomException메서드 호충");
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> handelerException(RuntimeException e, HttpServletRequest request){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.error("클래스 내 handleException 호출, {}, {}", request.getRequestURI(),
                e.getMessage());


        Map<String, String> map = new HashMap<>();
        map.put("erroe type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

}

