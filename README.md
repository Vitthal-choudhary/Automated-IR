# Drools 7 Classic – Learning Baseline

This branch tells you, how you can configure a **minimal, stable, working Drools project** using **Drools 7 (Classic KIE)** with **Java 17**.

This setup was built from scratch, debugged via CLI, and verified to work reliably.  
It exists as a **learning baseline** and a **known-good reference** before building a real rule-based system. My case is my project Automated IR

---

## Installation
Run this command
```
git clone https://github.com/Vitthal-choudhary/Automated-IR.git
```
after the repository is cloned, we need to switch to this branch, to see this particular code, if u type 
```
git branch -a
```
you will see all the branches, then type
```
git checkout drool-configs-basics
```
Now you are on this branch and u can see the code.

---

## Technology Stack I Used

- OS: Linux (I used Debian-based Parrot Linux)
- Java: OpenJDK 17
- Maven: 3.8.x
- Drools: 7.74.1.Final
- Rule format: DRL
- KIE style: Classic (kmodule.xml)
- IDE: Neovim (CLI-first)

Drools 10 is intentionally NOT used due to instability and breaking changes in classic KIE behavior.

---

## Project Creation (From Scratch)

The project was created using Maven’s quickstart archetype.

Command used:

```
mvn -B archetype:generate \
  -DgroupId=org.example \
  -DartifactId=drools7-classic \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.5 \
  -DinteractiveMode=false
```

After creation:
- The default `src/test` directory was removed
- Required Drools folders were added manually

---

## Project Structure
<img width="723" height="725" alt="image" src="https://github.com/user-attachments/assets/4e972147-f8a9-46b6-b109-725c858a9bbe" />

---

I did not use IntelliJ, because it creates a lot of confusion while starting in creation of maven project, as a beginner, i think this is better.

---

## Prerequisites

### Java
```
java -version
```
Expected:
```
openjdk version "17.x"
```

### Maven
```
mvn -version
```
Expected:
```
Apache Maven 3.8.x
Java version: 17
```

---

## pom.xml 
This file will have all your dependencies, and plugins, and other crucial stuff.
P.S. This file is very important.

---

## kmodule.xml

Location:
src/main/resources/META-INF/kmodule.xml
It helps maven while building kjars to look for rules in the right place.

```
<?xml version="1.0" encoding="UTF-8"?>
<kmodule xmlns="http://jboss.org/kie/6.0.0/kmodule">
  <kbase name="rules" packages="rules">
    <ksession name="ksession-rules"/>
  </kbase>
</kmodule>
```

Notes:
- `packages="rules"` must match DRL package
- `ksession-rules` must match Java code

---

## DRL Rule File

Location:
src/main/resources/rules/person.drl
This file will contain all the rules which we need to implement.
---

## Build and Run (Correct Way)

### Build
```
mvn clean package
```

### Generate runtime classpath
```
mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
```

### Run using plain Java
```
java -cp "target/drools7-classic-1.0-SNAPSHOT.jar:$(cat cp.txt)" org.example.Main
```

---

## Expected Output

```
Alice is an adult
Bob is a minor
```

You may also see:
```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder"
```

This is NOT an error. It only means no logging backend is configured.

---

## Key Lessons

- Drools 10 breaks classic KIE workflows
- kjar packaging is mandatory
- kie-maven-plugin is mandatory
- exec-maven-plugin causes classloader issues
- Drools should be run with an explicit runtime classpath

---

## Purpose of This Branch

- Learning baseline
- Stable reference
- Debugging aid
- Comparison point for future upgrades

This branch should remain unchanged.

---

## Final Note

Working systems matter more than trendy versions.

Drools 7 + Java 17 + Classic KIE is stable, predictable, and production-proven.
