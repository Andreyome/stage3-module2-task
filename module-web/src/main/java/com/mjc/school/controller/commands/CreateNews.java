package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.exceptions.ValidationException;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

public class CreateNews implements BaseCommand{
    BaseController<NewsDtoRequest, NewsDtoResponse,Long> newsController;
    Scanner scanner;
    public CreateNews(BaseController<NewsDtoRequest, NewsDtoResponse,Long> newsController, Scanner scanner){
        this.newsController = newsController;
        this.scanner = scanner;
    }
    @Override
    public void execute() {
        boolean isTrue = false;
        while (!isTrue) {
            try {
                System.out.println("Write News title:");
                String tmpTitle = scanner.nextLine();
                System.out.println("Write News content:");
                String tmpContent = scanner.nextLine();
                System.out.println("Write News author id:");
                Long tmpAuthor = scanner.nextLong();
                System.out.println(newsController.create(new NewsDtoRequest(NewsController.getLastNewsId()+1,tmpTitle,tmpContent,tmpAuthor)));
                NewsController.setLastNewsId(NewsController.getLastNewsId()+1L);
                isTrue = true;
            }
            catch (ValidationException e){
                throw new ValidationException("News id is invalid");
            }
        }

    }
}
