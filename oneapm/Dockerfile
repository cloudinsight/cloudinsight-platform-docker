FROM docker.io/oneapm/docker-oneapm-ci-agent

ADD sources.list /etc/apt/sources.list

RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 40976EAF437D05B5 && \
    apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 3B4FE6ACC0B21F32

RUN apt-get update && \
    apt-get install -y openjdk-7-jre-headless -qq --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*
