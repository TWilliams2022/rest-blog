package com.example.restblog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Within ViewController, create a public method named showView(). It should return a String.

@Controller
public class ViewController {

//    Annotate showView() with @RequestMapping();
    @RequestMapping ({"/", "/about", "/posts", "/login", "/home"})
public String showView(){

    return "forward:/index.html";
}

}
