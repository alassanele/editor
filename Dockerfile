FROM openjdk:8
EXPOSE 8080
ADD target/editor-0.0.1-SNAPSHOT.jar editor-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar /editor-0.0.1-SNAPSHOT.jar