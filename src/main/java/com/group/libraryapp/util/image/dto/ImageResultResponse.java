package com.group.libraryapp.util.image.dto;


import com.group.libraryapp.util.image.damin.ImageResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageResultResponse {
    private Long id;
    private Long position;
    private String thumbnail;
    private String related_content_id;
    private String serpapi_related_content_link;
    private String source;
    private String source_logo;
    private String title;
    private String link;
    private String original;
    private Long original_width;
    private Long original_height;
    private Boolean is_product;

    public ImageResultResponse(ImageResult imageResult) {
        this.id = imageResult.getId();
        this.position = imageResult.getPosition();
        this.thumbnail = imageResult.getThumbnail();
        this.related_content_id = imageResult.getRelated_content_id();
        this.serpapi_related_content_link = imageResult.getSerpapi_related_content_link();
        this.source = imageResult.getSource();
        this.source_logo = imageResult.getSource_logo();
        this.title = imageResult.getTitle();
        this.link = imageResult.getLink();
        this.original = imageResult.getOriginal();
        this.original_width = imageResult.getOriginal_width();
        this.original_height = imageResult.getOriginal_height();
        this.is_product = imageResult.getIs_product();
    }
}
