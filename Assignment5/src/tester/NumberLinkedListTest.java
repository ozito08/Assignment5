package tester;

import static org.junit.jupiter.api.Assertions.*;
import assignment5.NumberLinkedList;

import org.junit.jupiter.api.Test;

class NumberLinkedListTest {

	@Test
	void testMean() {
	    NumberLinkedList list = new NumberLinkedList();

	    list.add(10);
	    list.add(20);
	    list.add(30);
	    list.add(40);
	    list.add(50);

	    assertEquals(30.0, list.getMean());
	}
	@Test
	void testStandardDeviation() {
	    NumberLinkedList list = new NumberLinkedList();

	    list.add(10);
	    list.add(20);
	    list.add(30);
	    list.add(40);
	    list.add(50);

	    assertEquals(15.811388300841896,
	                 list.getStandardDeviation(),
	                 0.0001);
	}

}
