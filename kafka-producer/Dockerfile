FROM debian:jessie

ADD sources.list /etc/apt/sources.list

RUN apt-get update && \
    apt-get install -y openjdk-7-jre-headless -qq --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

ADD . /kafka
WORKDIR /kafka

ADD start-kafka-producer.sh /usr/bin/start-kafka-producer.sh
RUN chmod a+x /usr/bin/start-kafka-producer.sh

# Run Producer
CMD ["start-kafka-producer.sh"]
