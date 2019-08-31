package com.ibm.batch.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by karim on 27/08/2019.
 */
@Component
@PropertySource("classpath:tech/tech.properties")
@ConfigurationProperties

public class TechProperties {

    @Value("${tech.prop1}")
    private String techProp1;
    public String getTechProp1() {
        return techProp1;
    }

}
