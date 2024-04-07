package com.group.libraryapp.util;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderV1 {

    public static void main(String[] args) {
        CSVReaderV1 csvReaderV1 = new CSVReaderV1();
        List<List<String>> table = csvReaderV1.readCSV();
//        table.remove(0);
//        for(int i=0; i<table.size(); i++){
//            for (int j=0; j<table.get(i).size(); j++){
//                System.out.print(table.get(i).get(j)+", ");
//            }//for-j
//            System.out.println();
//        }//for-i
        table.stream().forEach(line -> System.out.println(String.join(",", line)));
    }

    public List<List<String>> readCSV() {
        // 반환용 리스트 변수
        List<List<String>> csvList = new ArrayList<>();
        // 입력 스트림
        BufferedReader br = null;
        File csv = new File("data/grape.csv");
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine() OH NE 39 CH.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을, 로 나누어 배열에 저장 후 리스트로 변환한다.
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }//while
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                }
                br.close(); // 사용 후 BufferedReader를 닫아준다.
            } catch (IOException e) {
                e.printStackTrace();
            }//try
        }//finally
        return csvList;
    }//reCSV

}//end

//    public static void main(String[] args) {
//        String result ="";
//        try{
//            URL url = new URL("https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0");
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("GET");
//            urlConnection.setRequestProperty("Content-type", "application/json");
//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//            result = br.readLine();
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject =
//        }catch (Exception e){
//
//        }

//    }//main