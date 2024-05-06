plugins {
    java
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.1.0"
    groovy
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    //unit testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.spockframework:spock-spring:2.3-groovy-4.0")
    testImplementation("io.github.benas:random-beans:3.9.0")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.liquibase:liquibase-core:4.20.0") {
        exclude("org.yaml:snakeyaml:1.30")
    }

    implementation("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")

    //validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //swagger
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    implementation("org.yaml:snakeyaml:1.32")

    //scheduler
    implementation("net.javacrumbs.shedlock:shedlock-spring:4.41.0")
    implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:2.2.0")

    // client
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.1")
    implementation("io.github.openfeign:feign-httpclient:10.12")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    //security
    implementation("org.springframework.boot:spring-boot-starter-security")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
