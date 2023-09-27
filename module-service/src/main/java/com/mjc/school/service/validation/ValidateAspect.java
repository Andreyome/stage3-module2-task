package com.mjc.school.service.validation;

import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateAspect {
    private Validator validator;
    public ValidateAspect(Validator validator){
        this.validator=validator;
    }
    @Before("@annotation(Validate) && args(newsDtoRequest)")
    public void validateNewsRequest(NewsDtoRequest newsDtoRequest){
        validator.validateNews(newsDtoRequest);
    }
    @Before("@annotation(Validate) && args(authorDtoRequest)")
    public void validateAuthorRequest(AuthorDtoRequest authorDtoRequest){
        validator.validateAuthor(authorDtoRequest);
    }

}
