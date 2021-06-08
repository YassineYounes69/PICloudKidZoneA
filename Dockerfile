FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/PICloudKidZoneA-4ArcTic3--master-1.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]