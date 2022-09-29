FROM openjdk:17-alpine
COPY ./src/ /app
WORKDIR /app
RUN javac ./academy/mindswap/webserver/WebServer.java
ENV PORT=8081
COPY ./www/ /app/www
COPY ./resources/ /app/resources
ENTRYPOINT ["java","academy.mindswap.webserver/WebServer"]

# docker build -t thewebserver .
# docker run -d --name thewebserver -p 80:8081 thewebserver