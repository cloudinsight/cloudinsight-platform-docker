FROM maven:3-jdk-8-alpine

ADD sources.list /etc/apt/sources.list

COPY settings.xml /usr/share/maven/ref/

ADD kafkaTest /kafka
WORKDIR /kafka

RUN mvn clean compile assembly:single

ADD start-kafka-consumer.sh /usr/bin/start-kafka-consumer.sh
RUN chmod a+x /usr/bin/start-kafka-consumer.sh

EXPOSE 9997

# Run Consumer
ENTRYPOINT ["start-kafka-consumer.sh"]
