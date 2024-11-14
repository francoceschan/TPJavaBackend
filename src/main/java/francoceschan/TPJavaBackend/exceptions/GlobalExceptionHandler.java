package francoceschan.TPJavaBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ColectivoAsignadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleColectivoAsignadoException(ColectivoAsignadoException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(BoletoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleBoletoException(BoletoException ex) {
        return ex.getMessage();
    }
}
