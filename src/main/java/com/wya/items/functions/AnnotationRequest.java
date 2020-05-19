package com.wya.items.functions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnotationRequest {

    @RequestMapping("anno")
    @ResponseBody
    public String requestAnnotation() {
        System.out.println("123");
        return "request success!";
    }
}
