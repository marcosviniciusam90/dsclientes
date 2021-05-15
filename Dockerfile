FROM maven:3-jdk-8-slim

ENV APP_HOME=/home/app
ENV TARGET_FOLDER=$APP_HOME/target

COPY src $APP_HOME/src
COPY pom.xml $APP_HOME

RUN mvn -f $APP_HOME/pom.xml clean package
RUN mv $TARGET_FOLDER/*.jar $TARGET_FOLDER/app.jar

EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar $TARGET_FOLDER/app.jar" ]