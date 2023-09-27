package com.mjc.school.repository.data;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class DataSource {
    private List<NewsModel> newsModelList;
    private List<AuthorModel> authorModelList;
    private final String PATH_TO_AUTHORS = "module-repository/src/main/resources/authors";
    private final String PATH_TO_CONTENT = "module-repository/src/main/resources/content";
    private final String PATH_TO_TITLE = "module-repository/src/main/resources/news";
@Autowired
    public DataSource() {
        fillAuthorsList();
        fillNewsList();
    }

    private void fillAuthorsList() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_AUTHORS))) {
            List<String> lines = br.lines().toList();
            this.authorModelList = new ArrayList<>();
            for (long i = 0; i < lines.size(); i++) {
                this.authorModelList.add(new AuthorModel(i+1, lines.get((int) i ),LocalDateTime.now(),LocalDateTime.now()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File \"authors\" not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillNewsList() {
        try (BufferedReader brContent = new BufferedReader(new FileReader(PATH_TO_CONTENT));
             BufferedReader brTitle = new BufferedReader(new FileReader(PATH_TO_TITLE))) {
            List<String> contents = brContent.lines().toList();
            List<String> titles = brTitle.lines().toList();
            this.newsModelList = new ArrayList<>();
            long tmp = 1L;
            for (long i = 0; i < contents.size(); i++) {
                this.newsModelList.add(new NewsModel((tmp), titles.get((int) i), contents.get(((int) i)), LocalDateTime.now(), LocalDateTime.now(), authorModelList.get((int) i).getId()));
                tmp++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File \"content\" not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<AuthorModel> getAuthorsModels(){
        return this.authorModelList;
    }
    public List<NewsModel> getNewsModels(){
        return this.newsModelList;
    }
}