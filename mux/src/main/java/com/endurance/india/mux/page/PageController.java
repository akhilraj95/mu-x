package com.endurance.india.mux.page;

import jnr.ffi.Struct;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by akhil on 23/6/17.
 */
@CrossOrigin(origins = "*")
@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    public PageController() {
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String createPage(@RequestBody Map<String, Object> data){
        JSONParser parser = new JSONParser();
        System.out.println(data.get("html"));
        System.out.println(data.get("lambda"));

        try {
            String url = pageService.createPage(String.valueOf(data.get("html")), data.get("lambda"));
            return url;
        }catch (Exception e){
            return "Page creation failed";
        }
    }

    @RequestMapping(value="/page/{pageid}",method = RequestMethod.GET)
    public String getPage(@PathVariable int pageid){
        System.out.println(pageid);
        String url = pageService.getPage(pageid);
        return url;
    }

}
