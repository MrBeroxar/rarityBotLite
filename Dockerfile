FROM openjdk:8
WORKDIR /
ADD rarityBotLite.jar rarityBotLite.jar
EXPOSE 8080
CMD ["java", "-jar", "rarityBotLite.jar"]

