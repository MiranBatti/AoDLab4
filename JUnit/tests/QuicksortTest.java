package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.hig.aod.lab4.QuickSortMedianOfThree;

/**
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-19
 *
 */
public class QuicksortTest {

	ArrayList<Integer> fixture;
	
	@Before
	public void setUp() throws Exception {
		fixture = new ArrayList<Integer>();
		
		for (int i = 0; i < 50; i++) {
			fixture.add(i);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUnsorted() {
		Collections.shuffle(fixture); // osortera listan
		
		Integer[] fixtureArray = new Integer[50]; 
		
		for (int i = 0; i < fixtureArray.length; i++) { // lägg listans element i en array
			fixtureArray[i] = fixture.get(i);
		}
		
		long startTime = System.currentTimeMillis();
		
		QuickSortMedianOfThree.sort(fixtureArray); // sortera arrayen
		
		long ellapsedTime= System.currentTimeMillis() - startTime;
		
		System.out.println(ellapsedTime);
		
		for (int i = 0; i < fixtureArray.length; i++) {
			assertEquals(i, fixtureArray[i].intValue());
		}
	}
	
	@Test
	public void testSorted() {
		Integer[] fixtureArray = new Integer[50]; 
		
		for (int i = 0; i < fixtureArray.length; i++) { // lägg listans element i en array
			fixtureArray[i] = fixture.get(i);
		}
		
		QuickSortMedianOfThree.sort(fixtureArray); // sortera arrayen
		
		for (int i = 0; i < fixtureArray.length; i++) {
			assertEquals(i, fixtureArray[i].intValue());
		}
	}
	
	@Test
	public void testReverseSorted() {
		Collections.sort(fixture, Collections.reverseOrder()); // osortera listan
		
		Integer[] fixtureArray = new Integer[50]; 
		
		for (int i = 0; i < fixtureArray.length; i++) { // lägg listans element i en array
			fixtureArray[i] = fixture.get(i);
		}
		
		QuickSortMedianOfThree.sort(fixtureArray); // sortera arrayen
		
		for (int i = 0; i < fixtureArray.length; i++) {
			assertEquals(i, fixtureArray[i].intValue());
		}
	}
	
	@Test
	public void testDuplicatesUnsorted() {
		String[] fixture = new String[10];
		
		fixture[0] = "vi";
		fixture[1] = "vi";
		fixture[2] = "de";
		fixture[3] = "de";
		fixture[4] = "de";
		fixture[5] = "de,";
		fixture[6] = "ni";
		fixture[7] = "de";
		fixture[8] = "de";
		fixture[9] = "de";
		
		QuickSortMedianOfThree.sort(fixture);
		
		assertEquals("de", fixture[0]);
		assertEquals("de", fixture[1]);
		assertEquals("de", fixture[2]);
		assertEquals("de", fixture[3]);
		assertEquals("de", fixture[4]);
		assertEquals("de", fixture[5]);
		assertEquals("de,", fixture[6]);
		assertEquals("ni", fixture[7]);
		assertEquals("vi", fixture[8]);
		assertEquals("vi", fixture[9]);
	}
	
	@Test
	public void testDuplicatesSorted() {
		String[] fixture = new String[10];
		
		fixture[0] = "de";
		fixture[1] = "de";
		fixture[2] = "de";
		fixture[3] = "de";
		fixture[4] = "de";
		fixture[5] = "de";
		fixture[6] = "de,";
		fixture[7] = "ni";
		fixture[8] = "vi";
		fixture[9] = "vi";
		
		QuickSortMedianOfThree.sort(fixture);
		
		assertEquals("de", fixture[0]);
		assertEquals("de", fixture[1]);
		assertEquals("de", fixture[2]);
		assertEquals("de", fixture[3]);
		assertEquals("de", fixture[4]);
		assertEquals("de", fixture[5]);
		assertEquals("de,", fixture[6]);
		assertEquals("ni", fixture[7]);
		assertEquals("vi", fixture[8]);
		assertEquals("vi", fixture[9]);
	}
	
	@Test
	public void testDuplicatesReverseSorted() {
		String[] fixture = new String[10];
		
		fixture[9] = "de";
		fixture[8] = "de";
		fixture[7] = "de";
		fixture[6] = "de";
		fixture[5] = "de";
		fixture[4] = "de";
		fixture[3] = "de,";
		fixture[2] = "ni";
		fixture[1] = "vi";
		fixture[0] = "vi";
		
		QuickSortMedianOfThree.sort(fixture);
		
		assertEquals("de", fixture[0]);
		assertEquals("de", fixture[1]);
		assertEquals("de", fixture[2]);
		assertEquals("de", fixture[3]);
		assertEquals("de", fixture[4]);
		assertEquals("de", fixture[5]);
		assertEquals("de,", fixture[6]);
		assertEquals("ni", fixture[7]);
		assertEquals("vi", fixture[8]);
		assertEquals("vi", fixture[9]);
	}
	
	@Test (expected = NullPointerException.class)
	public void testUnsortedNullElement() {
		Collections.shuffle(fixture); // osortera listan
		
		Integer[] fixtureArray = new Integer[50]; 
		
		for (int i = 0; i < fixtureArray.length; i++) { // lägg listans element i en array
			fixtureArray[i] = fixture.get(i);
		}
		
		fixtureArray[1] = null;
		
		QuickSortMedianOfThree.sort(fixtureArray); // sortera arrayen
		
		for (int i = 0; i < fixtureArray.length; i++) {
			assertEquals(i, fixtureArray[i].intValue());
		}
	}
	
	@Test
	public void testNullArray() {
		QuickSortMedianOfThree.sort(null);
	}
	
}
