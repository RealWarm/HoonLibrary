package com.group.libraryapp.util;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Batch2 {

    static final String BASE_URL = "https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0";

    public static void main(String[] args) throws IOException, ParseException {

        StringBuilder sb = new StringBuilder();

        try {
            // URL 객채 생성 (BASE_URL)
            URL url = new URL(BASE_URL);
            // URL을 참조하는 객체를 URLConnection 객체로 변환
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // 커넥션 request 방식 "GET"으로 설정
            con.setRequestMethod("GET");

            // 커넥션 request 값 설정(key,value)
            con.setRequestProperty("Content-type", "application/json");
            // void setRequestProperty (key,value) 다른 예시
            // con.setRequestProperty("Authorization", AUTH_KEY);
            // con.setRequestProperty("X-Auth-Token", AUTH_TOKEN);

            // 받아온 JSON 데이터 출력 가능 상태로 변경 (default : false)
            con.setDoOutput(true);

            // 데이터 입력 스트림에 담기
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("HOON.txt", true));

            while (br.ready()) {
                String tmp=br.readLine();
                System.out.println(tmp);
                bw.write(tmp);
                sb.append(tmp);
            }
            bw.flush();
            bw.close();
            br.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(sb.toString());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println("@@@@@@@@@@@@@@1");
//        JSONObject objData = (JSONObject)new JSONParser().parse(sb.toString()); // json 전체파싱
//        System.out.println("@@@@@@@@@@@@@@2");
//        JSONArray arrData = (JSONArray) objData.get("images_results");
//        JSONObject tmp;
//        sb = new StringBuilder();
//        for(int i=0; i<arrData.size(); i++){
//            tmp = (JSONObject) arrData.get(i);
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
//        }//for-i


    }//main

}//end class


//    URL url = new URL("https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0");
//    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//                con.setRequestProperty("Content-type", "application/json");
//                con.setDoOutput(true);
//
//                try{
//                StringBuilder sb = new StringBuilder();
//                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//                while (br.ready()){
//                sb.append(br.readLine());
//                }
//                }catch (Exception e){
//                e.printStackTrace();
//                }

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
//            System.out.println("is_product: " + tmp.get("is_product"));