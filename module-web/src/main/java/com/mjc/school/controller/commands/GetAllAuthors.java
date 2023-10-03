package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class GetAllAuthors implements BaseCommand {
    BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;

    public GetAllAuthors(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.authorController = authorController;
    }

    @Override
    public void execute() {
        authorController.readAll().forEach(System.out::println);

    }
}
