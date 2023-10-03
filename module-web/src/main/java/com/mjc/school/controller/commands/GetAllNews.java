package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

public class GetAllNews implements BaseCommand {
    BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;

    public GetAllNews(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController) {
        this.newsController = newsController;
    }

    @Override
    public void execute() {
        newsController.readAll().forEach(System.out::println);
    }
}
