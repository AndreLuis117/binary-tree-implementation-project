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
}
