package problem7;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import problem7.Main2.Stack;

public class Main2Test {

	@Test
	public void testPopEmptyStack() {
		Stack<String> s1 = new Stack<String>();
		boolean throwException = false;
		try {
			s1.pop();
		} catch (NoSuchElementException e) {
			throwException = true;
		} finally {
			assertTrue(throwException);
		}
	}

	@Test
	public void testPushAndPop() {
		Stack<String> s1 = new Stack<String>();
		s1.push("1");
		assertTrue("1".equals(s1.pop()));
		s1.push("1");
		s1.push("2");
		assertTrue("2".equals(s1.pop()));
		s1.push("3");
		assertTrue("3".equals(s1.pop()));
		assertTrue("1".equals(s1.pop()));
	}
}
