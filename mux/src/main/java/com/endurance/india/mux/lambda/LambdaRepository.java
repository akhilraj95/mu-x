package com.endurance.india.mux.lambda;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by akhil on 23/6/17.
 */
public interface LambdaRepository extends CrudRepository<Lambda, Integer> {
    Lambda findByPageIdAndFormId(String pageId, String formId);
}
