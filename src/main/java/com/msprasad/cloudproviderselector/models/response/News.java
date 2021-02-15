package com.msprasad.cloudproviderselector.models.response;

import com.msprasad.cloudproviderselector.models.common.AbstractBaseEntity;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Prasad on 06/14/20.
 */

@NamedQueries({

})

@NamedNativeQueries({
        @NamedNativeQuery(
                name = News.GET_NEWS_BY_COUNT,
                query = "SELECT * FROM news ORDER BY id DESC LIMIT :count",
                resultClass = News.class
        )
})

@Entity
@Data
@Table(name="news")
public class News extends AbstractBaseEntity {

    public static final String GET_NEWS_BY_COUNT = "News.getNewsByCount";

    public News() {
    }

    @Column(name = "topic")
    @NotNull
    private String topic;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "sort_description")
    private String sortDescription;

    @Column(name = "picture_id")
    private String pictureId;

    @Column(name = "month")
    private String month;

    @Column(name = "date")
    private String date;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_agree")
    private Boolean isAgree;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
