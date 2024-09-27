FROM mcr.microsoft.com/java/jdk:8-zulu-alpine AS derleyici
COPY /source /usr/src/merhaba
WORKDIR /usr/src/merhaba
RUN javac merhaba.java

FROM mcr.microsoft.com/java/jre:8-zulu-alpine
WORKDIR /merhaba
COPY --from=derleyici /usr/src/merhaba .
CMD ["java", "merhaba"] 



