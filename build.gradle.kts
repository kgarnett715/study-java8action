plugins {
    id("java")
//    id ("org.springframework.boot") version "3.3.3"
//    id("io.spring.dependency-management") version "1.1.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    compileOnly("org.projectlombok:lombok")
//    developmentOnly("org.springframework.boot:spring-boot-devtools")
//    annotationProcessor("org.projectlombok:lombok")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}
//
tasks.test {
    useJUnitPlatform()
}