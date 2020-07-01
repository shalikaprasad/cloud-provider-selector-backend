package com.prasad.dao.hibernate;

import com.prasad.dao.NewsDao;
import com.prasad.dao.common.hibernate.CRUDDaoImpl;
import com.prasad.models.response.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prasad on 06/14/20.
 */

@Repository("newsDao")
@Transactional
public class NewsDaoImpl extends CRUDDaoImpl<News> implements NewsDao {

    private final static Logger logger = LoggerFactory.getLogger(NewsDaoImpl.class);

    @Override
    public List<News> findNewsByCount(int count) {
        try {
            return (List<News>) entityManager.createNamedQuery(News.GET_NEWS_BY_COUNT)
                    .setParameter("count", count)
                    .getResultList();
        } catch (Exception e) {
            logger.error(">> No News for given number::", e);
            return null;
        }
    }

}