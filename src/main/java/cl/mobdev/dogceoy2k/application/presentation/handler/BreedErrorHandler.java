package cl.mobdev.dogceoy2k.application.presentation.handler;

import cl.mobdev.dogceoy2k.common.MyError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class BreedErrorHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<MyError> handleException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.add(error.getDefaultMessage());
        });

        MyError error = new MyError(
                HttpStatus.I_AM_A_TEAPOT.value(),
                new Date(),
                errors,
                ex.getNestedPath()
        );
        return new ResponseEntity<>(error, HttpStatus.I_AM_A_TEAPOT);
    }
}
