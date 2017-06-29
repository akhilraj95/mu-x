package com.endurance.india.mux.lambda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by akhil on 23/6/17.
 */
@RestController
public class LambdaController {

    @Autowired
    private LambdaService lambdaService;

    public LambdaController() {
    }

    @RequestMapping(value="/lambda/{pageId}/{functionId}",method = RequestMethod.POST)
    public String getPagePost(@PathVariable String functionId, @PathVariable String pageId, @RequestBody Map<String,String> paramMap){

        System.out.println(paramMap);
        String output = lambdaService.runLamda(functionId,pageId,paramMap);
        System.out.printf("output = "+output);
        return output;
    }
}
