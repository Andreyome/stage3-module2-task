package com.mjc.school.repository.model.impl;

import com.mjc.school.repository.model.BaseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsModel implements BaseEntity<Long> {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewsModel newsModel)) {
            return false;
        }
        return (Objects.equals(this.id, newsModel.id)) && (this.title.equals(newsModel.title)) && (this.content.equals(newsModel.content)) && (this.lastUpdateDate.equals(newsModel.lastUpdateDate)) && (this.createDate.equals(newsModel.createDate)) && (Objects.equals(this.authorId, newsModel.authorId));
    }
}
