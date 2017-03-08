FROM debian:jessie

ADD sources.list /etc/apt/sources.list

RUN apt-get update && \
    apt-get install -y openjdk-7-jre-headless -qq --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

ADD . /kafka
WORKDIR /kafka

ADD start-kafka-consumer.sh /usr/bin/start-kafka-consumer.sh
RUN chmod a+x /usr/bin/start-kafka-consumer.sh

# Run Consumer
CMD ["start-kafka-consumer.sh"]
