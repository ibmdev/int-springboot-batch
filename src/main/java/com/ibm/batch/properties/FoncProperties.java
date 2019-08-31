package com.ibm.batch.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by karim on 27/08/2019.
 */
@Component
@PropertySource("classpath:fonc/fonc.properties")
@ConfigurationProperties
public class FoncProperties {

    @Value("${fonc.prop1}")
    private String foncProp1;
    public String getFoncProp1() {
        return foncProp1;
    }

}
