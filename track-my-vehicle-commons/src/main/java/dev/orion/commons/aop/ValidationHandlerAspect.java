package dev.orion.commons.aop;

import dev.orion.commons.exception.ApiValidationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Aspect
@Configuration
public class ValidationHandlerAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void apiMethod(){}

    @Before(value = "apiMethod() and args(..,result)", argNames = "result")
    public void handle(BindingResult result){
        if (result.hasErrors()){
            System.err.println("=============");
            throw new ApiValidationException(result);
        }
    }
}
