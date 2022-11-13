package de.htwberlin.webtech.webtech.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloWorldController {
    @GetMapping(path = "/")
    public ModelAndView showHelloworldPage () {
        return new ModelAndView("helloworld");
    }
    @GetMapping(path = "/home")
    public ModelAndView showHomePage(){ return new ModelAndView("home");}

    @GetMapping(path ="/about")
    public ModelAndView showAboutPage(){return new ModelAndView("about");}

    @GetMapping(path = "/products")
    public ModelAndView showProductsPage(){return new ModelAndView("products");}

    @GetMapping(path = "/test")
    public ModelAndView showTestPage(HttpServletRequest req){
        HttpSession session = req.getSession();
        String name = req.getParameter("name");

        session.setAttribute("name", name);
        System.out.println(name);

        return new ModelAndView("test");}



}
