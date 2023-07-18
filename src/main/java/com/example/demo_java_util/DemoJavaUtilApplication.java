package com.example.demo_java_util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoJavaUtilApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJavaUtilApplication.class, args);
	}
	@GetMapping
	public String run(){
		return
				"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" >\n" +
				"<style >\n" +
				"\t.btn{\n" +
				"\t\tcolor: white!important\n" +
				"\t}\n" +
				"\t.content{\n" +
				"\t\twidth:800px;\n" +
				"\t\tmargin:auto;\n" +
				"\t\tpadding: 16px;\n" +
				"\t\t\n" +
				"\n" +
				"\n" +
				"\n" +
				"\t}\n" +
				"\t.title{\n" +
				"\t\ttext-align:center;\n" +
				"\t\tcolor: red\n" +
				"\t}\n" +
				"\t\n" +
				"\n" +
				"</style>\n" +
				"<body class=\"content\">\n" +
				"\t<h1 class=\"title\">Demo về thư viện java.util </h1>\n" +
				"\t<div>\n" +
				"\t\t<h5>Demo - List và một số thư viện liên quan</h5>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/list\" class=\"btn btn-primary\">List - Collections</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/arrlist\" class=\"btn btn-primary\">ArrayList - Iterator </a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/linkedlist\" class=\"btn btn-primary\">LinkedList </a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/vector\" class=\"btn btn-primary\">Vector </a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/copylist\" class=\"btn btn-primary\">CopyOnWriteArrayList</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/stack\" class=\"btn btn-danger\">Stack</a>\n" +
				"\t</div>\n" +
				"\n" +
				"\t<br/>\n" +
				"\t<br/>\n" +
				"\n" +
				"\t<div>\n" +
				"\t\t<h5>Demo - Map và một số thư viện liên quan</h5>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/map\" class=\"btn btn-success\">Map - HashMap </a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/hashtable\" class=\"btn btn-success\">HashTable</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/treemap\" class=\"btn btn-success\">TreeMap</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/weakhashmap\" class=\"btn btn-success\">WeakHashMap</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/linkedhash\" class=\"btn btn-success\">LinkedHashMap</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/enummap\" class=\"btn btn-danger\">EnumMap</a>\n" +
				"\t</div>\n" +
				"\n" +
				"\t<br/>\n" +
				"\t<br/>\n" +
				"\n" +
				"\t<div>\n" +
				"\t\t<h5>Demo - Set và một số thư viện liên quan</h5>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/set\" class=\"btn btn-info\">Set - HashSet</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/linkedset\" class=\"btn btn-info\">LinkedHashSet  </a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/treeset\" class=\"btn btn-info\">TreeSet </a>\n" +
				"\t\t\n" +
				"\t</div>\n" +
				"\n" +
				"\t<br/>\n" +
				"\t<br/>\n" +
				"\n" +
				"\t<div>\n" +
				"\t\t<h5>Demo - một số thư viện khác </h5>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/date\" class=\"btn btn-primary\">Date</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/properties\" class=\"btn btn-info\">Properties </a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/resourcebundle\" class=\"btn btn-success\">Resource Bundle</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/calendar\" class=\"btn btn-danger\">Calendar</a>\n" +
				"\t\t<a href=\"http://localhost:8080/demo/enum\" class=\"btn btn-dark\">Enum</a>\n" +
				"\t\t\n" +
				"\t</div>\n" +
				"\t\n" +
				"\n" +
				"</body>\n" ;


	}



}
