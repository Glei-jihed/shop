FROM openjdk:17

CMD ["mvn", "clean", "package"]

COPY target/shop-0.0.1-SNAPSHOT.jar /app/shop.jar


WORKDIR /app


CMD ["java", "-jar", "shop.jar"]
