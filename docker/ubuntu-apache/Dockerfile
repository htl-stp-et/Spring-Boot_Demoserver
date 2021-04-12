# docker build -t my-apache .

FROM ubuntu:21.04

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get -y update
RUN apt-get -y install apache2
RUN apt-get -y install nano

# COPY ./www/* /var/www/html

ENTRYPOINT ["/usr/sbin/apache2ctl","-D","FOREGROUND"]

EXPOSE 80