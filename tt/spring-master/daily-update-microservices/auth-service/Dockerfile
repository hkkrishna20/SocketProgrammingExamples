FROM javacode/docker:jdk8

ENV INIT_SCRIPT=/usr/local/bin/auth-service-startup.sh APP_HOME=/opt/name/javacode/java-ee

ADD https://raw.githubusercontent.com/javacode/java-ee/master/build-tools/startup.sh $INIT_SCRIPT

RUN chmod +x $INIT_SCRIPT

WORKDIR $APP_HOME

ADD build/libs/*.jar auth-service.jar

ENTRYPOINT ["/usr/local/bin/auth-service-startup.sh"]
CMD ["/opt/name/javacode/java-ee/auth-service.jar"]