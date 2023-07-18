package com.example.demo_java_util.other;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Date;
import java.util.Properties;

@RestController
@RequestMapping(path = "demo/properties")
public class PropertiesController {
    Properties properties ;
    String view;
    String content;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
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
    public String demoProperties(){
        initProperties();
        showProperties();
        return view;
    }

    private void initProperties() {

        properties= new Properties();
        File file = new File("mysql.properties");
        try (InputStream inputStream = new FileInputStream(file.getAbsoluteFile())){

            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void setContentWeb() {
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");


        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện Properties </h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));

        setContent(content.concat(
                "<span> Thông tin đọc được bằng Properties </span></br>" +
                        "<strong>urlDatabase: </strong> " + url + "</br>"+
                        "<strong>userDatabase: </strong> " + user + "</br>"+
                        "<strong>passDatabase: </strong>  " + password + "</br></br>"


        ));
        setContent(content.concat(
                "<span>Các key  - val trong file mysql.properties </span></br>" +
                        properties.entrySet().toString() + "</br></br>"

        ));

        setContent(content.concat(
                "<span>Các key trong file mysql.properties </span></br>" +
                        properties.keySet().toString() + "</br></br>"

        ));
        setContent(content.concat(
                "<span>Các value trong file mysql.properties </span></br>" +
                        properties.values().toString() + "</br></br>"

        ));







        setContent(content.concat("</div>"));
    }
    private void showProperties() {
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }


}
