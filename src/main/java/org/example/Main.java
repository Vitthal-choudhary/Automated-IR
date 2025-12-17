package org.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("ksession-rules");

        ksession.insert(new Person("Alice", 25));
        ksession.insert(new Person("Bob", 15));

        ksession.fireAllRules();
        ksession.dispose();
    }
}
