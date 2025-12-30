# Going deep into drools7-classic

This branch will cover all the other concepts of drools, one by one, whatever i will be learning, like rule-chaining, stateful and stateless, and maybe some other stuff as well, I will try to keep the README.md updated.

---

## Installation

These are same as base config commands, for my particular repo, switch to ```adding-to-drools``` at end.

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
