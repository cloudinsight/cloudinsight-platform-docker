FROM docker.io/oneapm/docker-oneapm-ci-agent

RUN apt-get update && \
    apt-get install -y openjdk-7-jre-headless -qq --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*
