# Drools 7 Classic – Learning Baseline

This repository contains a **minimal, stable, working Drools project** using **Drools 7 (Classic KIE)** with **Java 17**.

This setup was built from scratch, debugged via CLI, and verified to work reliably.  
It exists as a **learning baseline** and a **known-good reference** before building a real rule-based system (e.g. automated Incident Response).

---

## Technology Stack

- OS: Linux (I used Debian-based Parrot Linux)
- Java: OpenJDK 17
- Maven: 3.8.x
- Drools: 7.74.1.Final
- Rule format: DRL
- KIE style: Classic (kmodule.xml)
- IDE: Neovim (CLI-first)

Drools 10 is intentionally NOT used due to instability and breaking changes in classic KIE behavior.

---

## Project Structure
<img width="723" height="725" alt="image" src="https://github.com/user-attachments/assets/4e972147-f8a9-46b6-b109-725c858a9bbe" />

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

## pom.xml (Key Points)

- Packaging type: kjar (mandatory)
- Drools version: 7.74.1.Final
- Java release: 17
- Uses kie-maven-plugin
- Does NOT use exec-maven-plugin

---

## kmodule.xml

Location:
src/main/resources/META-INF/kmodule.xml

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
- Namespace stays 6.0.0 for Drools 7

---

## DRL Rule File

Location:
src/main/resources/rules/person.drl

```
package rules;

import org.example.Person;

rule "Adult"
when
    $p : Person(age >= 18)
then
    System.out.println($p.getName() + " is an adult");
end

rule "Minor"
when
    $p : Person(age < 18)
then
    System.out.println($p.getName() + " is a minor");
end
```

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

## Verification

Verify kmodule.xml is packaged correctly:
```
jar tf target/drools7-classic-1.0-SNAPSHOT.jar | grep kmodule
```

Expected:
```
META-INF/kmodule.xml
```

If this file is missing, Drools will not work.

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

This repository is intentionally minimal and should remain unchanged.

---

## Final Note

Working systems matter more than trendy versions.

Drools 7 + Java 17 + Classic KIE is stable, predictable, and production-proven.
