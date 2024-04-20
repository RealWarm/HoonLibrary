package com.group.libraryapp.util.image.damin;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageResult extends BaseEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long position;
    private String thumbnail;
    private String related_content_id;
    private String serpapi_related_content_link;
    private String source;
    private String source_logo;
    private String title;
    private String link;
    @Column(length = 5000)
    private String original;
    private Long original_width;
    private Long original_height;
    private Boolean is_product;

//    @Builder
//    public ImageResult(String position, String thumbnail,
//                       String related_content_id,
//                       String serpapi_related_content_link,
//                       String source,
//                       String source_logo,
//                       String title, String link,
//                       String original, String original_width,
//                       String original_height, String is_product) {
//        this.position = position;
//        this.thumbnail = thumbnail;
//        this.related_content_id = related_content_id;
//        this.serpapi_related_content_link = serpapi_related_content_link;
//        this.source = source;
//        this.source_logo = source_logo;
//        this.title = title;
//        this.link = link;
//        this.original = original;
//        this.original_width = original_width;
//        this.original_height = original_height;
//        this.is_product = is_product;
//    }
}
