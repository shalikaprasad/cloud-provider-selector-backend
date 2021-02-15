package com.msprasad.cloudproviderselector.dao;


import com.msprasad.cloudproviderselector.models.response.News;

import java.util.List;

/**
 * Created by Prasad on 06/14/20.
 */

public interface NewsDao extends CRUDDao<News> {

    List<News> findNewsByCount(int count);

}

