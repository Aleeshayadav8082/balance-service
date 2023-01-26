package com.maveric.balanceservice.exception;

import com.maveric.balanceservice.dto.ErrorDto;
import com.maveric.balanceservice.enums.Constants;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.maveric.balanceservice.enums.Constants.BAD_REQUEST_CODE;
import static com.maveric.balanceservice.enums.Constants.BALANCE_NOT_FOUND_CODE;

//import static org.hibernate.id.enhanced.StandardOptimizerDescriptor.log;
@ControllerAdvice
@RestControllerAdvice
public class ExceptionControllerAdvisor {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ExceptionControllerAdvisor.class);
    String exceptionString="";
    @ExceptionHandler(PathParamsVsInputParamsMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDto handlePathParamsVsInputParamsMismatchException(PathParamsVsInputParamsMismatchException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(exception.getMessage());
        log.error("{}-{}");
        return errorDto;
    }
    public static final ErrorDto handleBalanceNotFoundException(BalanceNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BALANCE_NOT_FOUND_CODE);
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }
    @ExceptionHandler(BalanceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDto handleBalanceAlreadyExistException(BalanceAlreadyExistException exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(BAD_REQUEST_CODE);
        errorDto.setMessage(exception.getMessage());
        exceptionString = exception.getMessage();
        log.error("{}->{}",BAD_REQUEST_CODE,exceptionString);
        return errorDto;
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handleFormatException(HttpMessageNotReadableException e)
    {
        ErrorDto error = getError(Constants.CURRENCY_ERROR, String.valueOf(HttpStatus.BAD_REQUEST));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    private ErrorDto getError(String message , String code){
        ErrorDto error = new ErrorDto();
        error.setCode(code);
        error.setMessage(message);
        return error;}
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorDto> handledFormatException(HttpMediaTypeNotAcceptableException e)
    {
        ErrorDto error = getErrorMsg(Constants.ACCOUNT_ID_ERROR, String.valueOf(HttpStatus.BAD_REQUEST));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    private ErrorDto getErrorMsg(String message , String code){
        ErrorDto error = new ErrorDto();
        error.setCode(code);
        error.setMessage(message);
        return error;}

}