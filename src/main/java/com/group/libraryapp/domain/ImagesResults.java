package com.group.libraryapp.domain;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImagesResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long position;
    private String thumbnail;
    private String related_content_id;
    private String serpapi_related_content_link;
    private String source;
    private String source_logo;
    private String title;
    private String link;
    private String original;
    private String original_width;
    private String original_height;
    private String is_product;

}
