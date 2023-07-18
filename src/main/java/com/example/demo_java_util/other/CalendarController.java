package com.example.demo_java_util.other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping(path = "demo/calendar")
public class CalendarController {

    Calendar calendar;
    String view;
    String content;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
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
    public String demoDate() {
        initCalendar();
        showCalendar();
        return view;

    }

    private void initCalendar() {
        calendar= Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

    }
    private void setContentWeb() {
        String str_Date = calendar.get(Calendar.DATE)+ "/" +calendar.get(Calendar.MONTH)+ "/" +calendar.get(Calendar.YEAR);
        Calendar calendar_pivot = Calendar.getInstance();
        String str_calendarpv = calendar_pivot.get(Calendar.DATE)+ "/" +calendar_pivot.get(Calendar.MONTH)+ "/" +calendar_pivot.get(Calendar.YEAR);
        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện Calendar </h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));
        setContent(content.concat(
                "Ngày đã khai báo là: " +
                        str_Date + "</br></br>"
        ));

        setContent(content.concat(
                "Ngày 1/6/2022 đã cộng thêm 3 ngày : " +
                        addDay(3) + "</br></br>"
        ));


        setContent(content.concat(
                "Kiểm tra xem ngày "+str_Date+" có trước ngày  "+ str_calendarpv+" không? <strong>" +
                        (checkBefore(calendar_pivot) ? "Có" : "Không") + "</strong></br></br>"
        ));
        setContent(content.concat("</div>"));
        setContent(content.concat(
                "Kiểm tra xem ngày " + str_Date + " có sau ngày "+str_calendarpv+" không? <strong>" +
                        (checkAfter(calendar_pivot) ? "Có" : "Không") + "</strong></br></br>"
        ));
//
        setContent(content.concat(
                "So sánh ngày " +str_Date+ " và ngày  "+str_calendarpv+" <strong>" +
                        (calendar.compareTo(calendar_pivot) == 1 ? "Lớn hơn" : "Bé hơn") + "</strong></br></br>"
        ));


        setContent(content.concat("</div>"));
    }

    private boolean checkBefore(Calendar date1) {
        return calendar.before(date1);

    }
    private boolean checkAfter(Calendar date1) {
        return calendar.after(date1);
    }
    private String addDay(int i){
        calendar.add(Calendar.DATE , 3 );
        return calendar.get(Calendar.DATE)+ "/" +calendar.get(Calendar.MONTH)+ "/" +calendar.get(Calendar.YEAR);
    }
    private void showCalendar() {
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }
}
