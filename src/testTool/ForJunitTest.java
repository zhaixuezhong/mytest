package testTool;

import junit.framework.TestCase;

public class ForJunitTest extends TestCase {
private ForJunit forJunit = new ForJunit();
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testAaaaa() {
		forJunit.aaaa();
	}

	public void testBbbb() {
		forJunit.bbbb();
	}

	public void testCccc() {
		forJunit.cccc();
	}

	public void testDddd() {
		forJunit.dddd();
	}

}
