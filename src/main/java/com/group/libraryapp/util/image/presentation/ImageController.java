package com.group.libraryapp.util.image.presentation;


import com.group.libraryapp.util.image.dto.ImageResultResponse;
import com.group.libraryapp.util.image.service.ImagesResultsService;
import com.group.libraryapp.util.image.damin.ImageResult;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImagesResultsService imagesResultsService;

    @GetMapping("/image")
    public void batch() throws ParseException {
        StringBuilder sb =new StringBuilder();
        try {
            // 데이터 입력 스트림에 담기
            BufferedReader br = Files.newBufferedReader(Paths.get("HOON.txt"), Charset.forName("UTF-8"));

            while (br.ready()) {
                String tmp=br.readLine();
//                System.out.println(tmp);
                sb.append(tmp);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(sb.toString());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@1");
        JSONObject objData = (JSONObject)new JSONParser().parse(sb.toString()); // json 전체파싱
        System.out.println("@@@@@@@@@@@@@@2");
        JSONArray arrData = (JSONArray) objData.get("images_results");
        JSONObject tmp;
        sb = new StringBuilder();
        List<ImageResult> dbArr= new ArrayList<>();
        for(int i=0; i<arrData.size(); i++){
            tmp = (JSONObject) arrData.get(i);
//            imagesResultsService.saveImageResult(ImageResult.builder().position((String)tmp.get("position")).
//                    thumbnail((String)tmp.get("thumbnail")).
//                    related_content_id((String)tmp.get("related_content_id")).
//                    serpapi_related_content_link((String)tmp.get("serpapi_related_content_link")).
//                    source((String)tmp.get("source")).
//                    source_logo((String)tmp.get("source_logo")).
//                    title((String)tmp.get("title")).
//                    link((String)tmp.get("link")).
//                    original((String)tmp.get("original")).
//                    original_width((String)tmp.get("original_width")).
//                    original_height((String)tmp.get("original_height")).
//                    is_product((String)tmp.get("is_product")).build());
            ImageResult tt =  ImageResult.builder().position((Long) tmp.get("position")).
                    thumbnail((String)tmp.get("thumbnail")).
                    related_content_id((String)tmp.get("related_content_id")).
                    serpapi_related_content_link((String)tmp.get("serpapi_related_content_link")).
                    source((String)tmp.get("source")).
                    source_logo((String)tmp.get("source_logo")).
                    title((String)tmp.get("title")).
                    link((String)tmp.get("link")).
                    original((String)tmp.get("original")).
                    original_width((Long)tmp.get("original_width")).
                    original_height((Long)tmp.get("original_height")).
                    is_product((Boolean)tmp.get("is_product")).build();
            System.out.println("================" + (i+1) + "번째 요소 ================");
            System.out.println(tt);
            System.out.println("@@@@@@@@@@@@@ imagesResultsService :: "+imagesResultsService);
            imagesResultsService.saveImageResult(tt);

//            System.out.println("================" + (i+1) + "번째 요소 ================");
//            System.out.println("position: " + tmp.get("position"));
//            System.out.println("thumbnail: " + tmp.get("thumbnail"));
//            System.out.println("related_content_id: " + tmp.get("related_content_id"));
//            System.out.println("serpapi_related_content_link: " + tmp.get("serpapi_related_content_link"));
//            System.out.println("source: " + tmp.get("source"));
//            System.out.println("source_logo: " + tmp.get("source_logo"));
//            System.out.println("title: " + tmp.get("title"));
//            System.out.println("link: " + tmp.get("link"));
//            System.out.println("original: " + tmp.get("original"));
//            System.out.println("original_width: " + tmp.get("original_width"));
//            System.out.println("original_height: " + tmp.get("original_height"));
        }//for-i
    }//batch

    @GetMapping("/image/list")
    public Page<ImageResultResponse> list(Pageable pageable){
        return imagesResultsService.findAll(pageable).map(ImageResultResponse::new);
    }

    @GetMapping("/image/title")
    public Page<ImageResultResponse> findByTitle(@RequestParam(required = true) String title, Pageable pageable){
        return imagesResultsService.findByTitleContaining(title, pageable).map(ImageResultResponse::new);
    }

}//end class
