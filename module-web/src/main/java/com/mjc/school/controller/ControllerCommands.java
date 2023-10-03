package com.mjc.school.controller;

import com.mjc.school.controller.annotations.CommandBody;
import com.mjc.school.controller.commands.*;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ControllerCommands {
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    @Autowired
    public ControllerCommands(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController, BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.newsController = newsController;
        this.authorController = authorController;
    }


    public void execute() {
        Scanner scanner1 = new Scanner(System.in);
        while (true) {
            System.out.println("Choose command:" + "\n" + "1- Get all authors " + "\n" + "2-Get all news" + "\n" + "3-Create author" + "\n" + "4-Create news" + "\n" + "5-Delete author" + "\n" + "6-Delete news" + "\n" + "7-Get author by ID" + "\n" + "8-Get news by ID" + "\n" + "9-Update author" + "\n" + "10-Update news" + "\n" + "0-Exit");
            int numberOfCommand = scanner1.nextInt();
            switch (numberOfCommand) {
                case 1 -> new GetAllAuthors(authorController).execute();
                case 2 -> new GetAllNews(newsController).execute();
                case 3 -> new CreateAuthor(authorController).execute();
                case 4 -> new CreateNews(newsController).execute();
                case 5 -> new DeleteAuthor(authorController).execute();
                case 6 -> new DeleteNews(newsController).execute();
                case 7 -> new GetAuthorById(authorController).execute();
                case 8 -> new GetNewsById(newsController).execute();
                case 9 -> new UpdateAuthor(authorController).execute();
                case 10 -> new UpdateNews(newsController).execute();
                case 0 -> System.exit(0);
            }
        }
    }

}
