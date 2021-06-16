FROM ubuntu:18.04

ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENV LC_ALL=C.UTF-8
ENV LANG=C.UTF-8

# Install utilities 
RUN apt-get update && \
    apt-get install -y \
    vim \
    git \
    wget \
    unzip \
    curl \
    gnupg

# Install Java 8
RUN apt update && apt install -y openjdk-8-jdk

# Install Scala 2.12.13
RUN apt remove scala-library scala
RUN wget www.scala-lang.org/files/archive/scala-2.12.13.deb
RUN dpkg -i scala-2.12.13.deb

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# Install scala 2.12
RUN wget https://downloads.lightbend.com/scala/2.12.3/scala-2.12.3.deb && \
    dpkg -i scala-2.12.3.deb && \
    apt-get update && \
    apt-get install -y scala

# Install sbt
RUN echo "deb http://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list &&\
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add &&\
    apt-get update &&\
    apt-get install -y sbt

EXPOSE 9000

# Add user with root right
RUN adduser --disabled-password \
    --gecos '' mgregula
RUN adduser mgregula sudo
RUN echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> \
    /etc/sudoers
USER mgregula
WORKDIR /home/mgregula/

RUN cd /home/mgregula/
RUN git clone https://github.com/Metanefrydia/e-biznes.git && cd e-biznes && git fetch
RUN mv -v ~/e-biznes/* ~/

RUN sbt playUpdateSecret
RUN sbt stage
CMD cd target/universal/stage/bin && chmod +x shop_project && ./shop-project -Dhttp.port=9000

EXPOSE 9000