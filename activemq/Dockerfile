FROM webcenter/activemq:5.12.0

RUN sed -i '100 a ACTIVEMQ_SUNJMX_START="-Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.password.file=${ACTIVEMQ_BASE}/conf/jmx.password -Dcom.sun.management.jmxremote.access.file=${ACTIVEMQ_BASE}/conf/jmx.access"' /opt/activemq/bin/activemq

COPY activemq.xml /opt/activemq/conf/activemq.xml

EXPOSE 7199
