package br.univille.estd.binarytree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Elivelton
 * @author Fernando
 */
public class IntegerBinaryTreeImplTest {
	
private IntegerBinaryTreeImpl impl;
	
	@Before
	public void setUp() {
		impl = new IntegerBinaryTreeImpl();
	}
	
	@Test
	public void testAdd() {
		impl.add(10);
		impl.contains(10);
		impl.remove(10);
		System.out.println();
	}
	@Test
	public void testContains() {
		impl.add(10);
		impl.contains(10);
		System.out.println();
	}
	@Test
	public void testRemove() {
		impl.add(10);
		impl.remove(10);
		System.out.println();
	}
	@Test
	public void testisEmpty() {
		impl.isEmpty();
		System.out.println();
	}
	@Test
	public void testSize() {
		impl.add(10);
		impl.size();
		System.out.println();
	}
	@Test
	public void testClear() {
		impl.add(10);
		impl.clear();
		System.out.println();
	}
	@Test
	public void testtoString() {
		impl.add(10);
		impl.toString();
		System.out.println();
	}
}
