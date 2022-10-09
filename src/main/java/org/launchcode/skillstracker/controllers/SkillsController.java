package org.launchcode.skillstracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody //<-returning a string and we want it converting to HTML
public class SkillsController {


    @GetMapping("")
    public String index(){
        return "<html>"+
                "<body>" +
                "<h1> Skills Tracker </h1>" +
                "<h2> We have a few skills we would like to learn. Here is the list! </h2>" +
                        "<ol>" +
                                "<li>Java</li>" +
                                "<li>JavaScript</li>" +
                                "<li>Python</li>" +
                        "</ol>"+
                "</body>"+
                "</html>";

    }
    @ResponseBody
    @GetMapping("form")
    public String skillsForm(){
        String content = "<form method = 'post'>"+
                "Name:<br>" +
                "<input type = 'text' name = 'name' />" +
                "<br>My favorite language:<br>" +
                "<select name = 'firstChoice'>" +
                    "<option value = 'Java'>Java</option>"+
                    "<option value = 'Javascript'>JavaScript</option>"+
                    "<option value = 'Python'>Python</option>"+
                "</select>" +
                "<br>My second favorite language:<br>" +
                "<select name = 'secondChoice'>" +
                "<option value = 'Java'>Java</option>"+
                "<option value = 'Javascript'>JavaScript</option>"+
                "<option value = 'Python'>Python</option>"+
                "</select>" +
                "<br>My third favorite language:<br>" +
                "<select name = 'thirdChoice'>" +
                "<option value = 'Java'>Java</option>"+
                "<option value = 'Javascript'>JavaScript</option>"+
                "<option value = 'Python'>Python</option>"+
                "</select><br>" +
                "<input type = 'submit' value = 'Submit'/>" +
                "</form>";
        return content;

    }
    @ResponseBody
    @PostMapping(value = "form") //<- where we submit the data from that form
    public String formHandler(@RequestParam String name,
                              @RequestParam String firstChoice,
                              @RequestParam String secondChoice,
                              @RequestParam String thirdChoice){
        String html =
                "<h1>" + name + "</h1>" +
                        "<br>" +
                        "<ol>" +
                        "<li>" + firstChoice + "</li>" +
                        "<li>" + secondChoice + "</li>" +
                        "<li>" + thirdChoice + "</li>" +
                        "</ol>";
                return html;

    }
}
