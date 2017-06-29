package com.endurance.india.mux.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akhil on 23/6/17.
 */
@Controller
public class MainController {

    public MainController() {
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
