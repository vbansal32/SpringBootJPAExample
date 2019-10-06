FROM openjdk:8
ADD  target/SpringBootJPA-0.1.jar SpringBootJPA-0.1.jar
EXPOSE 8765
ENTRYPOINT  ["java","-jar","SpringBootJPA-0.1.jar"]