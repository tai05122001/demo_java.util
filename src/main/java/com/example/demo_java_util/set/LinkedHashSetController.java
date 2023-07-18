package com.example.demo_java_util.set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "demo/linkedset")
public class LinkedHashSetController {

    Set<Integer> set;
    String view;
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Integer> getList() {
        return set;
    }

    public void setList(Set<Integer> list) {
        this.set = list;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @GetMapping
    private String demoLinkedHashSet(){
        initSet();
        showList();
        return view;

    }
    // Hàm khởi tạo giá trị của list
    private void initSet() {
        set = new LinkedHashSet<>();
        addSet();
        //        addAllList();


    }

    //hàm để thêm giá trị vào danh sách
    private void addSet(){
        Random r = new Random();
        for (int i = 0; i < 4 ; i++) {
            Integer a = r.nextInt(100);
            set.add(a);
        }
    }


    private void addAllList(){
        Set<Integer> listsub = new LinkedHashSet<>(){{
            add(1);
            add(3);
            add(2);
            add(10);
            add(13);
            add(14);
        }

        };

        set.addAll(listsub);
    }

    private void clearSet(){
        set.clear();
    }

    //hàm dùng để thiết lập nội dung
    private void setContentWeb(){
        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện LinkedHashSet</h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));
        setContent(content.concat(

                "<span>Danh sách sau khi khởi tạo</span>" +
                        "</br></br>"
        ));

        // khởi tạo danh sách
        printSet();
        // xóa danh sách
        setContent(content.concat(
                "</br></br>" +
                        "<span>Danh sách sau khi xóa</span>"
        ));
        // kiểm tra một phần tử trong danh sách
        setContent(content.concat(
                "</br></br>" +
                        "<span>Kiểm tra số " +
                        "<strong>10</strong> " +
                        "có trong danh sách không </span>"
        ));
        setContent(content.concat(
                "</br></br>" +
                        "<span> Số 10 </span>" +
                        (checkList(10)?"có ở trong danh sách":"không ở trong danh sách")
        ));

        // lấy một phần tử trong danh sách
//        setContent(content.concat(
//                "</br></br>" +
//                        "<span>Phần tử thứ" +
//                        "<strong> 2 </strong> " +
//                        "trong danh sách là " +
//                        "<strong>"+set.get(2)+"</strong>" +
//                        "</span>"
//        ));
        // duyệt qua list bằng cách sử dụng iterator
        setContent(content.concat(
                "</br></br>" +
                        "Duyệt các phần tử trong list bằng <strong>iterator</strong></br>"
        ));

        printSet();

        // xóa một phần tử trong danh sách
        setContent(content.concat(
                "</br></br>" +
                        "Xóa một phần tử ở vị trí số <strong> 0 </strong> trong list </br>"
        ));

        removeIndex(0);
        printSet();

        setContent(content.concat(
                "</br></br>" +
                        "Xóa một phần tử có giá trị bằng <strong> 5 </strong> trong list </br>"
        ));
        removeObject(5);
        printSet();

        setContent(content.concat(
                "</br></br>" +
                        "Kích thước hiện tại của danh sách là <strong>"+ set.size()+"</strong>"
        ));



        setContent(content.concat("</div>"));
    }

    private void removeObject(int i) {
        Integer k = i ;
        set.remove(k);
    }

    private void removeIndex(int i) {
        if(i > set.size()){
            return;
        }
        else {
            set.remove(i);
        }
    }

    // hàm sử dụng để hiển thị thông tin lên web
    private void showList(){
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }
    private void printSet(){
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            setContent(content.concat("<span>" + iterator.next() +
                    "</span> &nbsp"));

        }
    }
    //hàm kiểm tra số một số cụ thể trong danh sách
    public boolean checkList(int number){
        return set.contains(number);
    }
}
