package com.prasad.services;

import com.prasad.models.requests.NewsDto;
import com.prasad.models.response.News;

import java.util.List;

/**
 * Created by Prasad on 06/14/20.
 */

public interface NewsService {

    News createNews(NewsDto news);

    News updateNews(News news);

    void deleteNews(News news);

    List<News> findNewsByCount(int count);

    News find(Long id);
}
