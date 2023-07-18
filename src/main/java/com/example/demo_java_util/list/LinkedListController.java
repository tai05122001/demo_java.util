package com.example.demo_java_util.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping(path = "demo/linkedlist")

public class LinkedListController {
    List<Integer> list;
    String view;
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @GetMapping
    private String demoLinkedList(){
        initList();
        showList();
        return view;

    }
    // Hàm khởi tạo giá trị của list
    private void initList() {
        list = new ArrayList<>();
        // addList();
        addAllList();


    }

    //hàm để thêm giá trị vào danh sách
    private void addList(){
        Random r = new Random();
        for (int i = 0; i < 10 ; i++) {
            Integer a = r.nextInt(100);
            list.add(a);
        }
    }


    private void addAllList(){
        List<Integer> listsub = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8));

        list.addAll(listsub);
    }

    private void clearList(){
        list.clear();
    }

    //hàm dùng để thiết lập nội dung
    private void setContentWeb(){
        content = "<div>";

        setContent(content.concat(

                "<h1 style='color:red;text-align:center'>Demo cho thư viện LinkedList</h1>"+
                "<a href='http://localhost:8080'>Home</a><br/>"
        ));
        setContent(content.concat(

                "<span>Danh sách sau khi khởi tạo</span>" +
                        "</br></br>"
        ));

        // khởi tạo danh sách
        printList();
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
        setContent(content.concat(
                "</br></br>" +
                        "<span>Phần tử thứ" +
                        "<strong> 2 </strong> " +
                        "trong danh sách là " +
                        "<strong>"+list.get(2)+"</strong>" +
                        "</span>"
        ));
        // duyệt qua list bằng cách sử dụng iterator
        setContent(content.concat(
                "</br></br>" +
                        "Duyệt các phần tử trong list bằng <strong>iterator</strong></br>"
        ));
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            setContent(content.concat("<span>" + iterator.next() +
                    "</span> &nbsp"));

        }
        // xóa một phần tử trong danh sách
        setContent(content.concat(
                "</br></br>" +
                        "Xóa một phần tử ở vị trí số <strong> 10 </strong> trong list </br>"
        ));

        removeIndex(10);
        printList();

        setContent(content.concat(
                "</br></br>" +
                        "Xóa một phần tử có giá trị bằng <strong> 7 </strong> trong list </br>"
        ));
        removeObject(7);
        printList();

        setContent(content.concat(
                "</br></br>" +
                        "Kích thước hiện tại của danh sách là <strong>"+ list.size()+"</strong>"
        ));



        setContent(content.concat("</div>"));
    }

    private void removeObject(int i) {
        Integer k = i ;
        list.remove(k);
    }

    private void removeIndex(int i) {
        if(i > list.size()){
            return;
        }
        else {
            list.remove(i);
        }

    }

    // hàm sử dụng để hiển thị thông tin lên web
    private void showList(){
        view = "<body style='overflow:scroll; width:800px;margin:auto;padding:16px'>";
        setContentWeb();
        setView(view.concat(content));
        setView(view.concat("</body>"));

    }

    private void printList(){
        for (int i = 0 ; i <list.size(); i++){
            setContent(content.concat("<span>" + list.get(i) +
                    "</span> &nbsp"));
        }
    }

    //hàm kiểm tra số một số cụ thể trong danh sách
    public boolean checkList(int number){
        return list.contains(number);
    }
}
