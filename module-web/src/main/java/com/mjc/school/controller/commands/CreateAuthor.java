package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.exceptions.ValidationException;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CreateAuthor implements BaseCommand {
    BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;

    public CreateAuthor(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.authorController = authorController;
    }

    @Override
    public void execute() {
        boolean isTrue = false;
        while (!isTrue) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write author name:");
                String tmpName = scanner.nextLine();
                System.out.println(authorController.create(new AuthorDtoRequest((long) authorController.readAll().size() + 1, tmpName, LocalDateTime.now(), LocalDateTime.now())));
                isTrue = true;
            } catch (ValidationException e) {
                throw new ValidationException("Author name is invalid");
            }
        }

    }
}
