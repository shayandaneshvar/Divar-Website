package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.exceptions.ComingSoonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ComingSoonException.class)
    public ModelAndView handleComingSoon(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coming-soon");
        modelAndView.addObject(e);
        return modelAndView;
    }
}
