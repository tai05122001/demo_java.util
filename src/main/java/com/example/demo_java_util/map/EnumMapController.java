package com.example.demo_java_util.map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "demo/enummap")
public class EnumMapController {

    enum Color{
        RED,
        GREEN,
        BLUE

    }

    Map<Color , Integer> map;
    String view;
    String content;

    public Map<Color, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Color, Integer> map) {
        this.map = map;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @GetMapping
    private String demoHashTable(){
        initMap();
        showMap();
        return view;

    }

    private void initMap() {
        addMap();
    }

    private void addMap() {
        map = new HashMap<>();
        Random r = new Random();
        Color[] colors= Color.values();
        for (int i = 0; i <colors.length ; i++) {
            map.put(colors[i],r.nextInt(100) );

        }

    }

    private void setContentWeb(){
        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện EnumMap     </h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));
        // khởi tạo Map và hiển thị ra các object trong Map
        setContent(content.concat("<span>Map sau khi khởi tạo</span></br></br>"));
        printList();

        //Sử dụng get để lấy phần tử ra
        setContent(content.concat("<span>Lấy phần tử có key là <strong>Bob</strong></span></br>"));
        setContent(content.concat("<span>Phần tử có key là là BLUE có giá trị là "+map.get(Color.BLUE)+"</span>" +
                "</br></br>"
        ));

        //sử dụng containkey để kiểm tra object có key đó có thuộc map không?
        setContent(content.concat("<span>Kiểm tra phần tử  có key là màu  <strong> RED </strong> có ở trong Map trong</br>"));
        if (containsKey(Color.RED)) {
            setContent(content.concat(
                    "<span>Phần tử có key là <strong>RED</strong>"
                            + " nằm ở trong Map"
                            + "</br></br>"
            ));
        } else {
            setContent(content.concat(
                    "<span>Phần tử có key là <strong>RED</strong>"
                            + " không nằm ở trong Map"
                            + "</br></br>"
            ));
        }

        //sử dụng containvalue để kiểm tra object có val đó có thuộc map không?
        setContent(content.concat("<span>Kiểm tra phần tử  có value <strong> 30 </strong> có ở trong Map trong</br>"));
        if (containsValue(30)){
            setContent(content.concat(
                    "<span>Phần tử có val là <strong>30</strong>"
                            + " nằm ở trong Map"
                            + "</br></br>"
            ));
        } else {
            setContent(content.concat(
                    "<span> Phần tử có value là <strong>30</strong>"
                            + " không nằm ở trong Map"
                            + "</br></br>"
            ));
        }
        // kiểm tra kích thước của Map
        setContent(content.concat("<span>Kích thước của mảng là <strong>"+map.size()+"</strong></span></br>"));

        // in ra các key của Map
        setContent(content.concat("<span>Các key của map là <strong>"+ map.keySet().toString()+"</strong></span></br>"));
        // in ra các value của map
        setContent(content.concat("<span>Các value của map là <strong>"+ map.values().toString()+"</strong></span></br>"));
        //in ra các phần tử của map
        setContent(content.concat("<span>Các phần tử của map là <strong>"+ map.entrySet().toString()+"</strong></span></br>"));

        setContent(content.concat("</div>"));
    }
    private boolean containsKey(Color key){
        return map.containsKey(key);
    }
    private boolean containsValue(Integer val){
        return map.containsValue(val);
    }
    private void printList(){
        int i = 0;
        for (Map.Entry<Color, Integer> entry : map.entrySet()) {
            setContent(content.concat("<span>" + entry.getKey()+" => "+entry.getValue()+
                    "</span> &nbsp </br>"));
            i++;
        }
        setContent(content.concat("</br>"));
    }
    private void showMap(){
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }
}
