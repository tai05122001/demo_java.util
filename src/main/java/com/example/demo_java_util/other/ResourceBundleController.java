package com.example.demo_java_util.other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping(path = "demo/resourcebundle")
public class ResourceBundleController {
    ResourceBundle bundle;
    String view;
    String content;

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
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
    public String demoResourceBundle(){
        initProperties();
        showResourceBundle();
        return view;
    }

    private void initProperties() {


        // Tạo đối tượng ResourceBundle từ tên file và tên thư mục chứa file đó
        // file được đọc được nằm trong thư mục resources
        Locale localeVi = new Locale("vi");
        bundle = ResourceBundle.getBundle("message", localeVi);
        System.out.println("Xin chào trong tiếng việt: "+bundle.getString("hello"));
    }
    private void setContentWeb() {
        // Đọc giá trị từ file resource bundle
//        String welcomemes = bundle.getString("welcome.message");
//        String errormess = bundle.getString("error.message");


        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện ResourceBundle </h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));

        setContent(content.concat(
                "<span> Thông tin đọc bằng ResourceBundle </span></br>"
                        + "<strong>Hello bằng tiếng Việt  </strong> " +bundle.getString("hello")+ "</br>"
                        + "<strong>Nam tiếng việt là  </strong>  " + bundle.getString("name") + "</br></br>"

        ));
        Locale localeEng = new Locale("eng");
        bundle = ResourceBundle.getBundle("message", localeEng);
        setContent(content.concat(
                "<span> Thông tin đọc bằng ResourceBundle </span></br>"
                        + "<strong>Hello bằng tiếng Anh   </strong> " +bundle.getString("hello")+ "</br>"
                        + "<strong>Nam tiếng Anh là  </strong>  " + bundle.getString("name") + "</br></br>"

        ));

        Locale localeFR = new Locale("fr", "FR");
        bundle = ResourceBundle.getBundle("message", localeFR);

        setContent(content.concat(
                "<span> Thông tin đọc bằng ResourceBundle </span></br>"
                        + "<strong>Hello bằng tiếng Pháp  </strong> " +bundle.getString("hello")+ "</br>"
                        + "<strong>Nam tiếng Pháp là  </strong>  " + bundle.getString("name") + "</br></br>"

        ));


        setContent(content.concat(
                "<span>Các key trong file mysql.properties </span></br>" +
                        bundle.keySet().toString() + "</br></br>"

        ));

        setContent(content.concat(
                "<span>Locale của file mess.properties </span></br>" +
                        bundle.getLocale().toString() + "</br></br>"

        ));

        System.out.println(bundle.getLocale());


        setContent(content.concat("</div>"));
    }
    private void showResourceBundle() {
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }
}
