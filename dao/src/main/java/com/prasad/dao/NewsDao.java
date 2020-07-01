package com.prasad.dao;

import com.prasad.dao.common.CRUDDao;
import com.prasad.models.response.News;

import java.util.List;

/**
 * Created by Prasad on 06/14/20.
 */

public interface NewsDao extends CRUDDao<News> {

    List<News> findNewsByCount(int count);

}

