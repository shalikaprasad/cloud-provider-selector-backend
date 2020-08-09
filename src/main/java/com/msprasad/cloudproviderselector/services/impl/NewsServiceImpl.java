package com.msprasad.cloudproviderselector.services.impl;

import com.msprasad.cloudproviderselector.dao.NewsDao;
import com.msprasad.cloudproviderselector.models.requests.NewsDto;
import com.msprasad.cloudproviderselector.models.response.News;
import com.msprasad.cloudproviderselector.services.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Prasad on 06/14/20.
 */

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;



    @Override
    public News createNews(NewsDto newsDto) {
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        news.setTopic(newsDto.getTopic());
        news.setCategory(newsDto.getCategory());
        news.setDescription(newsDto.getDescription());
        news.setSortDescription(newsDto.getSortDescription());
        news.setPictureId(newsDto.getPictureId());
        news.setMonth(newsDto.getMonth());
        news.setDate(newsDto.getDate());
        news.setIsActive(newsDto.isActive());
        news.setIsAgree(newsDto.isAgree());
        return newsDao.create(news);
    }

    @Override
    public News updateNews(News news) {
        return null;
    }

    @Override
    public void deleteNews(News news) {

    }

    @Override
    public List<News> findNewsByCount(int count) {
        return newsDao.findNewsByCount(count);
    }

    @Override
    public News find(Long id) {
        return null;
    }
}
