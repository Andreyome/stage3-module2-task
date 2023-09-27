package com.mjc.school.repository.aspects;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.data.DataSource;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.model.impl.NewsModel;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class OnDeleteAspect {
    BaseRepository<NewsModel,Long> newsRepository;
    @Autowired
    public OnDeleteAspect(NewsRepository newsRepository){
        this.newsRepository=newsRepository;
    }
    @After(value = "@annotation(OnDelete)&& args(id)")
    public void onDelete(Long id){
        List<NewsModel> newsToDelete = newsRepository.readAll().stream().filter(newsModel -> !newsModel.getAuthorId().equals(id) ).toList();
        newsToDelete.forEach(NewsModel ->newsRepository.deleteById(NewsModel.getId()));
    }

}
