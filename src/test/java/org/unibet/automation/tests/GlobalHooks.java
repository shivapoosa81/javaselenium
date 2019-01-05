package org.unibet.automation.tests;

import cucumber.annotation.Before;

public class GlobalHooks extends AbstractTest {
	private static boolean dunit = false;

	@Before
	public void beforeAll() {
		if (!dunit) {

			try {
				setupContext();
			} catch (Exception e) {
				e.printStackTrace();
			}
			dunit = true;
		}
	}
}
