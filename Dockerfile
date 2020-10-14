FROM amazoncorretto/amazoncorretto:11-alpine-jdk AS builder

WORKDIR /tmp
ARG GRADLE_VERSION=6.6.1
RUN     wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
		unzip gradle-${GRADLE_VERSION}-bin.zip && \
		rm gradle-${GRADLE_VERSION}-bin.zip && \
		mv gradle-${GRADLE_VERSION} gradle && \
		ln -s gradle/gradle-${GRADLE_VERSION} gradle/latest
		
WORKDIR /usr/app
COPY    . .
RUN		export PATH=/tmp/gradle/bin:${PATH} && \
		gradle buildMainHttpStarter && \
		gradle CopyRuntimeLibsFolderToBUILD
		
FROM amazoncorretto/amazoncorretto:11-alpine-jdk

WORKDIR /usr/app
COPY 	--from=builder /usr/app/BUILD-OUTPUT .
		
CMD ["java", "-jar", "hello-vertx.jar-1.0.jar"]
