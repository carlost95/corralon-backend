package ar.edu.undec.Data.Exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "ar.edu.undec.Data.Implementation")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataExceptionHandler extends ResponseEntityExceptionHandler {

}
