FROM openjdk:11
ADD target/prueba-0.0.1-SNAPSHOT.jar /app/app.jar
ADD src/main/resources/application.properties /app/application.properties
RUN mkdir /log
WORKDIR /app
ENV DEFAULT_OPTIONS="-Djava.net.preferIPv4Stack=true -Djava.security.egd=file:/dev/./urandom"
ENV JAVA_OPTS=""
ENTRYPOINT java ${DEFAULT_OPTIONS} ${JAVA_OPTS} -jar /app/app.jar