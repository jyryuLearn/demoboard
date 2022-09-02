FROM tomcat:9

ARG WAR_FILE=build/libs/dockerDemo-*-SNAPSHOT.war

RUN rm -Rf /usr/local/tomcat/webapps/ROOT
COPY ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war