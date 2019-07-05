#!/bin/ksh
. /sma/librairie/smacert/datapower.profile
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
/usr/java6_64/bin/java ${JAVA_OPTS} -cp $CLASSPATH fr.sma.artifact.main.ArtifactMain

