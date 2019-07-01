package de.juli.unitool.timeismoney.web.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.juli.unitool.timoresrc.log.PrettyLog;

@Controller
public class CustomErrorController implements ErrorController  {
	private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
    
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        LOG_PRETTY.info("ERROR:",status);
         
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
         
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }
 
    @Override
    public String getErrorPath() {
    	LOG_PRETTY.info("getErrorPath");
        return "/error";
    }
}
