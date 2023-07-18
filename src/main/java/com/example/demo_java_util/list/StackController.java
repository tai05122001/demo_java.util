package com.example.demo_java_util.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "demo/stack")
public class StackController {
    Stack < Integer > stack;
    String view;
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List < Integer > getStack() {
        return stack;
    }

    public void setStack(Stack < Integer > stack) {
        this.stack = stack;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @GetMapping
    private String demoList() {
        initList();
        showList();
        return view;

    }
    // Hàm khởi tạo giá trị của list
    private void initList() {
        stack = new Stack < > ();
        addStack();
        //        addAllList();


    }

    //hàm để thêm giá trị vào danh sách
    private void addStack() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            Integer a = r.nextInt(100);
            stack.push(a);
        }
    }


    private void setContentWeb() {
        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện Stack</h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));
        // khởi tạo và in ra danh sách ngăn xếp
        setContent(content.concat(

                "<span>Danh sách sau khi khởi tạo</span>" +
                        "</br>"
        ));
        printList();

        // xóa phần tử ở đỉnh của ngăn xếp
        setContent(content.concat(
                "<span>Xóa phần tử ở đỉnh của ngăn xếp</span>" +
                        "</br>"
        ));
        popStack();
        printList();
        // trả về phần tử đầu tiên của ngăn xếp
        setContent(content.concat(
                "<span> Phần tử đầu tiên của ngăn xếp là " + stack.peek() + "</span>" +
                        "</br></br>"
        ));


        setContent(content.concat(
                "<span> Phần tử 3 "
                        +
                        (searchStack(3) != -1 ?
                                "nằm ở vị trí thứ " + searchStack(3) :
                                "không nằm trong ngăn xếp ")
                        +
                        "</span>" +
                        "</br></br>"
        ));

        setContent(content.concat(
                "<span> Kiểm tra ngăn xếp có rỗng không? "+(stack.empty()? " Có ": " Không ")+"</span>" +
                        "</br>"
        ));



        setContent(content.concat("</div>"));
    }

    private int searchStack(int i) {
        return stack.search(i);
    }

    private void popStack() {
        stack.pop();
    }

    // hàm sử dụng để hiển thị thông tin lên web
    private void showList() {
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }

    private void printList() {
        for (int i = 0; i < stack.size(); i++) {
            setContent(content.concat("<span>" + stack.get(i) +
                    "</span> &nbsp"));
        }
        setContent(content.concat("</br></br>"));
    }

    //hàm kiểm tra số một số cụ thể trong danh sách
    public boolean checkList(int number) {
        return stack.contains(number);
    }
}