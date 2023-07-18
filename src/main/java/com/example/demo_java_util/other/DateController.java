package com.example.demo_java_util.other;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping(path = "demo/date")
public class DateController {
    Date date;
    Calendar calendar;
    String view;
    String content;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
        initDate();
        showDate();
        return view;

    }

    private void initDate() {
        date = new Date();
        date.setDate(12);
        date.setMonth(7);
        date.setDate(2023);
    }
    private void setContentWeb() {
        Date date_pivot = new Date();
        date_pivot.setDate(11);
        date_pivot.setMonth(7);
        date_pivot.setYear(2023);
        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện Date - Calendar </h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));
        setContent(content.concat(
                "Giờ đã khai báo là: " +
                        date + "</br></br>"
        ));

        setContent(content.concat(
                "Kiểm tra xem ngày trên có trước ngày  "+date_pivot.toString()+" không? <strong>" +
                        (checkBefore(date_pivot) ? "Có" : "Không") + "</strong></br></br>"
        ));
        setContent(content.concat("</div>"));
        setContent(content.concat(
                "Kiểm tra xem ngày " + date.toString() + " có sau ngày "+date_pivot.toString()+" không? <strong>" +
                        (checkAfter(date_pivot) ? "Có" : "Không") + "</strong></br></br>"
        ));

        setContent(content.concat(
                "So sánh ngày " +date.toString()+ " và ngày  "+date_pivot.toString()+" <strong>" +
                        (date.compareTo(date_pivot) == 1 ? "Lớn hơn" : "Bé hơn") + "</strong></br></br>"
        ));

        setContent(content.concat(
                "<span> Thời gian của " +
                        date.toString() +
                        " dưới dạng số milisecond kể từ Epoch time: <strong>"+date.getTime()+" s</strong></span>"
        ));


        setContent(content.concat("</div>"));
    }

    private boolean checkBefore(Date date1) {
        return date.before(date1);

    }
    private boolean checkAfter(Date date1) {
        return date.after(date1);
    }

    private void showDate() {
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }
}