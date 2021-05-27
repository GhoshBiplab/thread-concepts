FROM openjdk:11
COPY ./out/production/TestThreadCommonPool/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","CommonPoolTest"]
