/*******************************************************************************
 * Copyright (c) 2015 David Lamparter, Daniel Marbach
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *******************************************************************************/
package ch.unil.genescore.vegas.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.unil.genescore.main.Pascal;
import ch.unil.genescore.vegas.Farebrother;
import ch.unil.genescore.vegas.FarebrotherExperiment;


public class FarebrotherTest {

	/** The Pascal instance (initializes Settings) */
	private static Pascal psc = new Pascal();

	@BeforeClass
	public static void testSetup() {
		Pascal.set.resetToDefaults();
	}

	@AfterClass
	public static void testCleanup() { }
	
	
	// ============================================================================
	// TESTS

	/** Test test statistic */
	@Test
	public void testFarebrother() {
		Pascal.set.requestedAbsolutePrecision_=1e-25;
		double w=1e-17;
		System.out.println(w);
		double q=1-w;
		double t=1-q;
		 t=w/10.0;
		System.out.println(t);
		double[] lambda={4,3,2,1};		
		
		Farebrother myfarebrother = new Farebrother(lambda);
		double res = myfarebrother.probQsupx(300);
		System.out.println(res);
		FarebrotherExperiment myfarebrotherExp = new FarebrotherExperiment(lambda);
		double res2 = myfarebrotherExp.probQsupx(300);			
		System.out.println(res2);
	}
	
}
