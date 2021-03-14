FROM ubuntu:18.04

ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV LC_ALL=C.UTF-8
ENV LANG=C.UTF-8

# Install Java 8
RUN apt update && apt install -y openjdk-8-jdk

# Install Scala 2.12.13
RUN apt install -y wget
RUN apt remove scala-library scala
RUN wget www.scala-lang.org/files/archive/scala-2.12.13.deb
RUN dpkg -i scala-2.12.13.deb

# Install sbt
RUN apt install -y gnupg2
RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list  
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
RUN apt update && apt install -y sbt  

# Install node.js & npm
RUN apt install -y curl
RUN curl -sL https://deb.nodesource.com/setup_15.11
RUN apt update && apt install -y nodejs npm 