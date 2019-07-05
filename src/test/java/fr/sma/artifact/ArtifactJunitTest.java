package fr.sma.artifact;
import fr.sma.artifact.services.rest.generated.jcms_logos.model.CriteresLogoRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtifactJunitTest {

    // Logger SLF4J
    Logger loggerSLF4J = LoggerFactory.getLogger(ArtifactJunitTest.class);

    @Test
    public void mainTest() {

        loggerSLF4J.info("Hello World Batch INFO");
        loggerSLF4J.debug("Hello World Batch DEBUG");
        loggerSLF4J.error("Hello World Batch ERROR");
        CriteresLogoRequest request = new CriteresLogoRequest();
    }

}
