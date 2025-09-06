FROM docker.io/maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /builder

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

FROM docker.io/eclipse-temurin:21-jre-alpine AS runner

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

COPY --from=builder /builder/target/movie-catalog-api-*.jar ./movie-catalog-api.jar

EXPOSE 8080

USER appuser

ENTRYPOINT [ "java", "-jar", "movie-catalog-api.jar" ]

LABEL org.opencontainers.image.title="Movie Catalog API" \
    org.opencontainers.image.version="0.0.1"