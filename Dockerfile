FROM amazoncorretto:21

WORKDIR /app
COPY target/venta-1.0-SNAPSHOT.jar app.jar
COPY Wallet_fullstack3 /app/oracle_wallet
EXPOSE 8097

CMD [ "java", "-jar", "app.jar" ]