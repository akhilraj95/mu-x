package com.endurance.india.mux.page;

import com.endurance.india.mux.lambda.LambdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akhil on 23/6/17.
 */
@Component
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private LambdaService lambdaService;


    public String createPage(String html,Object lambda){
        Page p = new Page(html);
        p.setHtml(html);
        p = pageRepository.save(p);

        try {
            Map<String, String> lambdaMap = (HashMap<String, String>) lambda;
            for (String key : lambdaMap.keySet()) {
                // create lambda
                lambdaService.createLambda(lambdaMap.get(key),key,String.valueOf(p.getId()));
            }
        }catch (Exception e){
            return "JSON error";
        }

        // update page

        html = html.replaceAll("<head>", "<head><script>var websiteEndpoint = 'http://127.0.0.1:8080/lambda/"+p.getId()+"/'</script>");
        p.setHtml(html);
        pageRepository.save(p);
        return "http://127.0.0.1:8080/page/"+String.valueOf(p.getId());
    }

    public String getPage(int pageid){
        Page p = pageRepository.findOne(pageid);
        return p.getHtml();
    }

}
