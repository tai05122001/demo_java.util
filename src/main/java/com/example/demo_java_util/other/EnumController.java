package com.example.demo_java_util.other;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping(path = "demo/enum")
public class EnumController {

    Season season;
    String view;
    String content;
    enum Season {
        SPRING("Mùa xuân"),
        SUMMER("Mùa hè"),
        FALL("Mùa thu"),
        WINTER("Mùa đông");

        private String name;

        private Season(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

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
    public String demoEnum() {
        initSeason();
        showEnum();
        return view;

    }

    private void initSeason() {

        season = Season.FALL;
    }
    private void setContentWeb() {

        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện Enum </h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));

        setContent(content.concat(
                "Enum Season gồm các mùa sau<br> "
        ));
        printEnum();

        setContent(content.concat(
                "Mùa được khởi tạo là <strong>" + season.name + "</strong></br>"
        ));
        setContent(content.concat(
                season.name+ " có vị trí thứ  <strong>"+(season.ordinal()+1)+"</strong> trong các mùa <br> "
        ));

        setContent(content.concat("</div>"));

        setContent(content.concat(
                "Kiểm tra xem mùa khởi tạo có phải là mùa xuân không? "
                        + "<strong>"
                        + (season.equals(Season.SPRING)?"Có":"Không")
                        +"</strong>"
        ));
    }

    private void printEnum() {
        for (Season season: Season.values()) {
            setContent(content.concat(
                    "<span>"+season.name+"</span></br>"
            ));
            
        }
    }


    private void showEnum() {
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }
}
