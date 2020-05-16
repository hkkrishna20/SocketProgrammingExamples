FROM javacode/docker:jdk8

ENV STARTUP_SCRIPT=/usr/local/bin/news-service-startup.sh APP_HOME=/opt/name/javacode/java-ee

ADD https://raw.githubusercontent.com/javacode/java-ee/master/build-tools/startup.sh $STARTUP_SCRIPT

RUN chmod +x $STARTUP_SCRIPT

WORKDIR $APP_HOME

ADD build/libs/*.jar news-service.jar

ENTRYPOINT ["/usr/local/bin/news-service-startup.sh"]
CMD ["-a", "config-service", "/opt/name/javacode/java-ee/news-service.jar"]