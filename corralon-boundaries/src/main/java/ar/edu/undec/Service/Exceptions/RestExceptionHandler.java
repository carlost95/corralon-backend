package ar.edu.undec.Service.Exceptions;

import ar.edu.undec.Service.ModelService.Response;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "ar.edu.undec.Service.Controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
    //Excepciones de BD/////////////////////////////////////////////////////////////////////////////
    @ExceptionHandler(BancoExisteException.class)
    public ResponseEntity<Response> handleBancoExisteException(BancoExisteException ex) {
        Response response = new Response();
        response.setStatus(412);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(BancoIncompletoException.class)
    protected ResponseEntity<Object> handleBancoIncompletoException(BancoIncompletoException ex) {
        Response response = new Response();
        response.setStatus(413);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(BancoNoExisteException.class)
    protected ResponseEntity<Object> handleBancoNoExisteException(BancoNoExisteException ex) {
        Response response = new Response();
        response.setStatus(414);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
//        Response response = new Response();
//        response.setStatus(101);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
//        Response response = new Response();
//        response.setStatus(102);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    //Excepciones runtime JAVA///////////////////////////////////////////////////////////////////////
//    @ExceptionHandler(MailException.class)
//    protected ResponseEntity<Object> handleMail(MailException ex) {
//        Response response = new Response();
//        response.setStatus(200);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(TemplateException.class)
//    protected ResponseEntity<Object> handleTemplate(TemplateException ex) {
//        Response response = new Response();
//        response.setStatus(201);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(TemplateNotFoundException.class)
//    protected ResponseEntity<Object> handleTemplateNotFound(TemplateNotFoundException ex) {
//        Response response = new Response();
//        response.setStatus(202);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(FileNotFoundException.class)
//    protected ResponseEntity<Object> handleFileNotFound(FileNotFoundException ex) {
//        Response response = new Response();
//        response.setStatus(203);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(IOException.class)
//    protected ResponseEntity<Object> handleIO(IOException ex) {
//        Response response = new Response();
//        response.setStatus(204);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(MessagingException.class)
//    protected ResponseEntity<Object> handleMessaging(MessagingException ex) {
//        Response response = new Response();
//        response.setStatus(205);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(CustomException.class)
//    protected ResponseEntity<Object> handleCustom(CustomException ex) {
//        Response response = new Response();
//        response.setStatus(206);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(ServiceCallException.class)
//    protected ResponseEntity<Object> handleServiceCallException(ServiceCallException ex) {
//        Response response = new Response();
//        response.setStatus(207);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(FEException.class)
//    protected ResponseEntity<Object> handleFEException(FEException ex) {
//        Response response = new Response();
//        response.setStatus(208);
//        response.setMessage(ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handleException(Exception ex) {
//        ex.printStackTrace();
//        Response response = new Response();
//        response.setStatus(999);
//        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}

