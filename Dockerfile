FROM java:8
VOLUME /data
ADD build/libs/usel.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:mysql://192.168.99.100:3306/usel?user=monty&password=secret", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]