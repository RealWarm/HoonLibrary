package com.group.libraryapp.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Batch2 {

    static final String BASE_URL = "https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0";
    public static void main(String[] args) throws IOException, ParseException {

        URL url = null;
        HttpURLConnection con = null;
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try {
            // URL 객채 생성 (BASE_URL)
            url = new URL(BASE_URL);
            // URL을 참조하는 객체를 URLConnection 객체로 변환
            con = (HttpURLConnection) url.openConnection();

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
//            BufferedWriter bw = new BufferedWriter(new FileWriter("HOON.txt", true));
            while (br.ready()) {
                String tmp=br.readLine();
//                bw.write(tmp);
                sb.append(tmp);
            }
//            bw.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            System.out.println(sb.toString());
        }

        JSONObject objData = (JSONObject)new JSONParser().parse(sb.toString());
        JSONArray arrData = (JSONArray) objData.get("images_results");
        JSONObject tmp;
        JSONArray tmpArr;
        sb = new StringBuilder();
        for(int i=0; i<arrData.size(); i++){
            tmp = (JSONObject) arrData.get(i);
            System.out.println("================" + (i+1) + "번째 요소 ================");
            System.out.println("position: " + tmp.get("position"));
            System.out.println("thumbnail: " + tmp.get("thumbnail"));
            System.out.println("related_content_id: " + tmp.get("related_content_id"));
            System.out.println("serpapi_related_content_link: " + tmp.get("serpapi_related_content_link"));
            System.out.println("source: " + tmp.get("source"));
            System.out.println("source_logo: " + tmp.get("source_logo"));
            System.out.println("title: " + tmp.get("title"));
            System.out.println("link: " + tmp.get("link"));
            System.out.println("original: " + tmp.get("original"));
            System.out.println("original_width: " + tmp.get("original_width"));
            System.out.println("original_height: " + tmp.get("original_height"));
            System.out.println("is_product: " + tmp.get("is_product"));
        }//for-i


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