package com.bolivarSoftware.eTurnos.web.excepciones;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ExceptionsHandler {

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView getPages() throws Exception {
        throw new CustomGenericException("E888", "This is custom message X");
    }

    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {
        ModelAndView model = new ModelAndView("Exception");
        model.addObject("exception", ex);
        return model;

    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("Exception");
        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg", "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;

    }

}
