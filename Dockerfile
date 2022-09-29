FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:11
EXPOSE 8080:8080
RUN mkdir /ridebus
COPY --from=build /home/gradle/src/build/libs/*.jar /ridebus/ridebus-server.jar
ENTRYPOINT ["java","-jar","/app/ridebus-server.jar"]