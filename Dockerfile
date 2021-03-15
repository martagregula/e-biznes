FROM ubuntu:18.04

ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV LC_ALL=C.UTF-8
ENV LANG=C.UTF-8

# Install utilities 
RUN apt update && apt install -y wget curl gnupg2 unzip vim git   

# Install Java 8
RUN apt update && apt install -y openjdk-8-jdk

# Install Scala 2.12.13
RUN apt remove scala-library scala
RUN wget www.scala-lang.org/files/archive/scala-2.12.13.deb
RUN dpkg -i scala-2.12.13.deb

# Install sbt
RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list  
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
RUN apt update && apt install -y sbt  

# Install node.js & npm
RUN curl -fsSL https://deb.nodesource.com/setup_current.x | bash -
RUN apt update && apt install -y nodejs
RUN npm install npm@latest -g

EXPOSE 3000
EXPOSE 9000

RUN useradd -ms /bin/bash mgregula
RUN adduser mgregula sudo
USER mgregula
WORKDIR /home/mgregula
RUN mkdir /home/mgregula/files
VOLUME ["/home/mgregula/files"]