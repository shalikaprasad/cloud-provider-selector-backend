package com.msprasad.cloudproviderselector.controller;

import com.microsoft.applicationinsights.TelemetryClient;
import com.msprasad.cloudproviderselector.models.requests.NewsDto;
import com.msprasad.cloudproviderselector.models.response.ResponseWrapper;
import com.msprasad.cloudproviderselector.services.NewsService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/api/news")
@Api(value = "news", tags = "News Controller")
public class NewsController {
    private final static Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @Autowired
    TelemetryClient telemetryClient;

    @GetMapping(value = "/{count}")
    public ResponseWrapper getNews(@PathVariable("count") String count) {
        telemetryClient.trackEvent("Get News From DB with count = " + count);
        logger.info(">> Get News for home page");
        return ResponseWrapper.success(newsService.findNewsByCount(Integer.parseInt(count)));
    }

    @PutMapping(value = "/create")
    public ResponseWrapper createNews(@RequestBody NewsDto news) {
        telemetryClient.trackEvent("Create News");
        logger.info(">> Create News for home page");
        return ResponseWrapper.success(newsService.createNews(news));
    }

}
