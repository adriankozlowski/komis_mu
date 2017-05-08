package pl.quider.web.komis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by adrian on 08.05.17.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("exception", e);
        //mav.addObject("errorcode", "404");
        log.error(e.getLocalizedMessage(), e);
        return mav;
    }
}
