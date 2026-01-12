package org.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("ksession-rules");

        // Phase 1: Detection
        ksession.getAgenda().getAgendaGroup("detection").setFocus();
        ksession.insert(new Incident("Malware", 9));
        ksession.fireAllRules();

        // Phase 2: Response
        ksession.getAgenda().getAgendaGroup("response").setFocus();
        ksession.fireAllRules();

        ksession.dispose();
    }
}
