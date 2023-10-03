package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.exceptions.ValidationException;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

public class DeleteNews implements BaseCommand {
    BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;
    Scanner scanner;

    public DeleteNews(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController) {
        this.newsController = newsController;
    }

    @Override
    public void execute() {
        System.out.println("Write News id:");
        boolean isTrue = false;
        while (!isTrue) {

            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(newsController.deleteById(scanner.nextLong() - 1));
                isTrue = true;
            } catch (ValidationException e) {
                throw new ValidationException("News id is invalid");
            }
        }

    }
}
