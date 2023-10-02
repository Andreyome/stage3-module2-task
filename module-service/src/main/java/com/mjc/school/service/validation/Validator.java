package com.mjc.school.service.validation;

import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public void validateAuthor(AuthorDtoRequest authorDtoRequest){
        if(authorDtoRequest.getName().length()>15||authorDtoRequest.getName().length()<3){
            throw new ValidatorException("Author name format is incorrect.");
        }
    }
    public void validateNews(NewsDtoRequest newsDtoRequest){
        if(newsDtoRequest.getTitle().length()>30||newsDtoRequest.getTitle().length()<5){
            throw new ValidatorException("News Title format is incorrect");
        }
        if(newsDtoRequest.getContent().length()>30||newsDtoRequest.getContent().length()<5){
            throw new ValidatorException("News Context format is incorrect");
        }
    }
}
