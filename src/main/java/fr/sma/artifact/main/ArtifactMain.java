package fr.sma.artifact.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtifactMain {

    // LOGGER
    private static Logger loggerArtifactMain = LoggerFactory.getLogger(ArtifactMain.class);
    // Contexte Spring
    private static final String SPRING_CONFIG_FILE = "/spring/applicationContext.xml";

    public static void main(String[] args ) {
        loggerArtifactMain.info("Artifact Main");
    }
}
