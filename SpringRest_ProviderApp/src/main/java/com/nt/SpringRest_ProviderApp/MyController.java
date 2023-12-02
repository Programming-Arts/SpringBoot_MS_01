package com.nt.SpringRest_ProviderApp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    //: http://localhost:9080/getName
    @RequestMapping("/getName")
    public String getName() {
        System.out.println("getTypeRequestMethod() executed");
        return "Nikhil";
    }

    //: http://localhost:9080/getSurname
    @RequestMapping("/getSurname")
    public String getSurname() {
        System.out.println("getTypeRequestMethod() executed");
        return "Deshpande";
    }

    //http://localhost:9090/getData/65
    //@GetMapping("/getData/{id}") // template variable
    //@RequestMapping(value = "/getData/{id}",method = RequestMethod.GET)
    @RequestMapping("/getData/{id}")
    public String getPathParamDataFromRequest(@PathVariable("id") Integer id) {
        String message = "Id : " + id;
        return message;
    }

    //http://localhost:9090/getQueryParamData?age=34
    @RequestMapping("/getQueryParamData")
    public String getQueryParamFromRequest(@RequestParam("ageOfMan") Integer age) {
        String message = "Age : " + age;
        return message;
    }

}
