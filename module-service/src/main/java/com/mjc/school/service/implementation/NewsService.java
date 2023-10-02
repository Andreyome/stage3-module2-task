package com.mjc.school.service.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.validation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService implements BaseService<NewsDtoRequest, NewsDtoResponse, Long> {
    private final BaseRepository<NewsModel, Long> newsModelRepository;

    @Autowired
    public NewsService(BaseRepository<NewsModel, Long> newsModelRepository) {
        this.newsModelRepository = newsModelRepository;
    }


    @Override
    public List<NewsDtoResponse> readAll() {
        return newsModelRepository.readAll().stream().map(NewsMapper.INSTANCE::newsToDto).collect(Collectors.toList());
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        Optional<NewsModel> newsModelOptional = newsModelRepository.readById(id);
        if (newsModelOptional.isPresent()) {
            return NewsMapper.INSTANCE.newsToDto(newsModelOptional.get());
        } else throw new RuntimeException("No news with such id found");
    }

    @Override
    @Validate
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        NewsModel newsModel = NewsMapper.INSTANCE.newsDtoToModel(createRequest);
        newsModel.setCreateDate(LocalDateTime.now());
        newsModel.setLastUpdateDate(LocalDateTime.now());
        newsModelRepository.create(newsModel);
        return NewsMapper.INSTANCE.newsToDto(newsModel);
    }

    @Override
    @Validate
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        NewsModel updatedNews = NewsMapper.INSTANCE.newsDtoToModel(updateRequest);
        updatedNews.setLastUpdateDate(LocalDateTime.now());
        updatedNews.setCreateDate(newsModelRepository.readById(updatedNews.getId()).get().getCreateDate());
        return NewsMapper.INSTANCE.newsToDto(newsModelRepository.update(updatedNews));
    }

    @Override
    public boolean deleteById(Long id) {
        if (!newsModelRepository.deleteById(id)) {
            throw new RuntimeException("News with provided id not found.");
        }
        return true;
    }
}
