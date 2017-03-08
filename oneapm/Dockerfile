FROM docker.io/oneapm/docker-oneapm-ci-agent

ADD sources.list /etc/apt/sources.list

RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 62C7DA6D && \
    apt-key adv --keyserver keyserver.ubuntu.com --recv-keys B421195B

RUN apt-get update && \
    apt-get install -y openjdk-7-jre-headless -qq --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*
