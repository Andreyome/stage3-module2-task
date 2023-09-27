package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.exceptions.ValidationException;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.util.Scanner;

public class DeleteAuthor implements BaseCommand{
    BaseController<AuthorDtoRequest, AuthorDtoResponse,Long> authorController;
    Scanner scanner;
    public DeleteAuthor(BaseController<AuthorDtoRequest, AuthorDtoResponse,Long> authorController, Scanner scanner){
        this.authorController = authorController;
        this.scanner = scanner;
    }
    @Override
    public void execute() {
        System.out.println("Write Author id:");
        boolean isTrue = false;
        while (!isTrue) {
            try {
                Long authorId = scanner.nextLong();
                System.out.println(authorController.deleteById(authorId-1));
                isTrue = true;
            }
            catch (ValidationException e){
                throw new ValidationException("Author id is invalid");
            }
        }

    }
}
