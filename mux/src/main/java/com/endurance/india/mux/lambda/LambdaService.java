package com.endurance.india.mux.lambda;

import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Properties;

/**
 * Created by akhil on 23/6/17.
 */
@Service
public class LambdaService {

    @Autowired
    private LambdaRepository lambdaRepository;

    public void createLambda(String function,String formId,String pageId){
        Lambda l = new Lambda(function,formId,pageId);
        l = lambdaRepository.save(l);
    }


    public String runLamda(String functionId, String pageId, Map<String,String> paramMap){

            Lambda l = lambdaRepository.findByPageIdAndFormId(pageId,functionId);
            String func = l.getFunction();
            PythonInterpreter python = new PythonInterpreter();
            StringBuilder stringBuilder = new StringBuilder();
            for ( String key : paramMap.keySet() ) {
                stringBuilder.append(key);
                stringBuilder.append("='");
                stringBuilder.append(paramMap.get(key));
                stringBuilder.append("'\n");
            }
            stringBuilder.append(func);
            System.out.println(stringBuilder.toString());
            python.exec(stringBuilder.toString());
            PyObject output = python.get("output");
            System.out.println(output.toString());
            return output.toString();

    }

}
