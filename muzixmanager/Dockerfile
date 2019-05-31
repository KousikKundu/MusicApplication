FROM java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASENAME=muzixdb
ENV MONGO_URL=mongodb://localhost:27017/muzixdb
ADD ./target/muzixmanager-0.0.1-SNAPSHOT.jar /usr/src/muzixmanager-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "muzixmanager-0.0.1-SNAPSHOT.jar"]
