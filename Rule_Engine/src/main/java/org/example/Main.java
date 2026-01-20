package org.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("ir-session");

        // Insert initial facts
        ksession.insert(new Alert("MALWARE", 0.85));

        // ---- PHASE 1: INGESTION ----
        ksession.getAgenda().getAgendaGroup("ingestion").setFocus();
        ksession.fireAllRules();

        // ---- PHASE 2: CLASSIFICATION ----
        ksession.getAgenda().getAgendaGroup("classification").setFocus();
        ksession.fireAllRules();

        // ---- PHASE 3: DECISION ----
        ksession.getAgenda().getAgendaGroup("decision").setFocus();
        ksession.fireAllRules();

        // ---- PHASE 4: RESPONSE ----
        ksession.getAgenda().getAgendaGroup("response").setFocus();
        ksession.fireAllRules();

        ksession.dispose();
    }
}
