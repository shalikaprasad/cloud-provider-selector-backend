package com.prasad.home.controller;

import com.prasad.models.requests.NewsDto;
import com.prasad.models.response.ResponseWrapper;
import com.prasad.services.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/api/news")
@Api(value = "news", tags = "News Controller")
public class NewsController {
    private final static Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/{count}")
    public ResponseWrapper getNews(@PathVariable("count") String count) {
        logger.info(">> Get News for home page");
        return ResponseWrapper.success(newsService.findNewsByCount(Integer.parseInt(count)));
    }

    @PutMapping(value = "/create")
    public ResponseWrapper createNews(@RequestBody NewsDto news) {

        logger.info(">> Create News for home page");
        return ResponseWrapper.success(newsService.createNews(news));
    }

}
