FROM ubuntu:18.04
RUN apt-get update -y
RUN apt-get install default-jre -y
WORKDIR /merhaba
#myapp'i ./ olarak belirtmezsek image build'lerken src_path belirtmek lazım.'
COPY ./myapp .
CMD ["java", "merhaba"]


