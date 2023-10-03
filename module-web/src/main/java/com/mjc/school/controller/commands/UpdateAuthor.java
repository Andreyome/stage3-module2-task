package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.exceptions.ValidationException;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateAuthor implements BaseCommand {
    BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;

    public UpdateAuthor(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.authorController = authorController;
    }

    @Override
    public void execute() {
        boolean isTrue = false;
        while (!isTrue) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write author id:");
                Long id = Long.parseLong(scanner.nextLine());
                System.out.println(authorController.readById(id).toString());
                System.out.println("Write author name:");
                String authorName = scanner.nextLine();
                System.out.println(authorController.update(new AuthorDtoRequest(id, authorName, authorController.readById(id).getCreateDate(), LocalDateTime.now())));
                isTrue = true;
            } catch (ValidationException e) {
                throw new ValidationException("Author is invalid");
            }
        }
    }
}
