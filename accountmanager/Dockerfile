FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=UserDb
ENV MYSQL_USER=approot
ENV MYSQL_PASSWORD=root123
ENV MYSQL_URL=jdbc:mysql://localhost:3306/UserDb
ADD ./target/accountmanager-0.0.1-SNAPSHOT.jar /usr/src/accountmanager-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "accountmanager-0.0.1-SNAPSHOT.jar"]
