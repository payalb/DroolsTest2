package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * From Drools 6.0 onwards a new approach is used to create a Knowledge Base and a Knowledge Session. Knowledge base is an interface that manages a set of rules and processes. The main task of the knowledge base is to store and re-use rules because creation of rules is very expensive.Rules are contained inside the package org.drools.KnowledgeBase. These are commonly referred to as knowledge definitions or knowledge. Knowledge base provides methods for creating a Session.
The knowledge session can be of two types:
Stateless Knowledge Session
Stateful Knowledge Session
In this chapter we make use of KieSession to get stateful session. Stateful sessions are longer lived and allow iterative changes over time.
 */
public class DroolsTest {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
//Get the session named kseesion-rule that we defined in kmodule.xml above.
//Also by default the session returned is always stateful. 
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Product product = new Product();
			product.setType("gold");

			FactHandle fact1;

			fact1 = kSession.insert(product);
			kSession.fireAllRules();

			System.out.println("The discount for the jewellery product "
					+ product.getType() + " is " + product.getDiscount());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
