package com.prasad.services.impl;

import com.prasad.dao.NewsDao;
import com.prasad.models.requests.NewsDto;
import com.prasad.models.response.News;
import com.prasad.services.NewsService;
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
