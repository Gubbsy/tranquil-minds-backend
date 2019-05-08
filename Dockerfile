FROM openjdk:8-alpine
EXPOSE 8090
EXPOSE 8091
WORKDIR /src
CMD [ "./gradlew","--no-daemon","bootrun" ]