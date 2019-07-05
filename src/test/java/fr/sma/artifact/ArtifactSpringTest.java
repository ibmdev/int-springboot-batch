package fr.sma.artifact;
import fr.sma.artifact.ArtifactJunitTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContextTest.xml")
public class ArtifactSpringTest {

    @Value("#{systemProperties['my-property-system'] ?: null}")
    private String myPropertySystem;

    @Value("${my.property.fonc: Valeur par défaut}")
    private String myPropertyFonc;

    @Value("${my.property.array.fonc:}")
    private String[] myPropertyArrayFonc;

    @Value("#{'${my.property.array.fonc}'.split(',')}")
    private List<String> myPropertyListFonc;

    @Value("${s4p.ws.registry.url}")
    private String wsRegistryURL;

    @Value("classpath:security/za/smabtp.keystore")
    Resource zaKeyStoreResource;

    @Value("classpath:security/za/smabtp.truststore")
    Resource zaTrustStoreResource;

    @Value("${za.javax.net.ssl.keyStorePassword}")
    private String zaKeyStorePassword;

    @Value("${za.javax.net.ssl.trustStorePassword}")
    private String zaTrustStorePassword;

    Logger loggerSLF4J = LoggerFactory.getLogger(ArtifactJunitTest.class);

    @Before
    public void afterClass() {
        try {
            loggerSLF4J.info("ZA KeyStore URL : " + zaKeyStoreResource.getFile().getAbsolutePath());
            loggerSLF4J.info("ZA TrustStore URL : " + zaTrustStoreResource.getFile().getAbsolutePath());
            loggerSLF4J.info("ZA KeyStore Password : " + zaKeyStorePassword);
            loggerSLF4J.info("ZA TrustStore Password : " + zaTrustStorePassword);
            System.setProperty("javax.net.ssl.keyStore", zaKeyStoreResource.getFile().getAbsolutePath());
            System.setProperty("javax.net.ssl.trustStore", zaTrustStoreResource.getFile().getAbsolutePath());
            System.setProperty("javax.net.ssl.keyStorePassword", zaKeyStorePassword);
            System.setProperty("javax.net.ssl.trustStorePassword", zaTrustStorePassword);
        }
        catch(Exception e) {
            loggerSLF4J.error("Erreur lecture des ressources", e);
        }
    }
    @Test
    public void main() {

        loggerSLF4J.info("My Property System : " + myPropertySystem);
        loggerSLF4J.info("My Property Fonc : " + myPropertyFonc);
        loggerSLF4J.info("My Property Array Fonc : " + myPropertyArrayFonc.length);
        loggerSLF4J.info("My Property List Fonc : " + myPropertyListFonc.size());
        loggerSLF4J.info("WS Registry URL : " + wsRegistryURL);

    }

}
