FROM alpine:3.3

RUN apk --update add memcached libmemcached && \
    rm -rf /var/cache/apk/*

VOLUME ["/var/lib/memcached"]

EXPOSE 11211
CMD ["memcached"]
