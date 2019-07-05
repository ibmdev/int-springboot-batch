#!/bin/ksh
parent=`dirname $0`
APPROOTPATH=$parent/../bin
PROPERTIESPATH=$parent/../conf
LIBAPPPATH=$parent/../lib
CLASSPATH="$PROPERTIESPATH/tech:$CLASSPATH"
CLASSPATH="$PROPERTIESPATH/fonc:$CLASSPATH"
for fichier in $LIBAPPPATH/*.jar
	do
		CLASSPATH="${fichier}:$CLASSPATH"
	done
java -Ds4p.ws.registry.url=classpath:service-registry.properties -cp $CLASSPATH fr.sma.artifact.main.ArtifactMain

