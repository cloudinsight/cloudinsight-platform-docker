FROM maven:3-jdk-8-alpine

ADD sources.list /etc/apt/sources.list

COPY settings.xml /usr/share/maven/ref/

ADD kafkaTest /kafka
WORKDIR /kafka

RUN mvn clean compile assembly:single

ADD start-kafka-producer.sh /usr/bin/start-kafka-producer.sh
RUN chmod a+x /usr/bin/start-kafka-producer.sh

EXPOSE 9998

# Run Producer
ENTRYPOINT ["start-kafka-producer.sh"]
