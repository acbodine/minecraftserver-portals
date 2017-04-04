FROM ubuntu:xenial

WORKDIR /root/minecraftserver-portals

RUN apt-get -qq update \
 && apt-get -qq install -y \
    default-jdk-headless \
 && apt-get clean

COPY . .

RUN ./gradlew
