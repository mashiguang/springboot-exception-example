package cn.niceabc.exce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity exceptionHandler(Exception e) {

        Map<String, String> map = new HashMap<>();
        map.put("code", HttpStatus.BAD_REQUEST.value()+"");
        map.put("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        map.put("message", e.getMessage());

        ResponseEntity pe = new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        return pe;
    }
}
