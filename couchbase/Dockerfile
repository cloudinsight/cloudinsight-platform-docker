FROM alpine:3.3

RUN apk --update add bash wget dpkg-dev

# Moxi - http://www.couchbase.com/downloads
RUN \
  useradd moxi && \
  cd /tmp && \
  wget -q http://packages.couchbase.com/releases/2.5.0/moxi-server_2.5.0_x86_64.deb && \
  dpkg -i moxi-server_2.5.0_x86_64.deb

# Start
CMD ["/opt/bin/moxi"]
