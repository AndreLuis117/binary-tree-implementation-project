package br.univille.estd.binarytree;

/**
 * @author Elivelton
 * @author Fernando
 */
public class IntegerBinaryTreeImpl implements IntegerBinaryTree {

	private LinkedBinaryTree<Integer> innerTree;
	
	public IntegerBinaryTreeImpl() {
		innerTree = new LinkedBinaryTree<Integer>();
	}

	@Override
	public void add(Integer i) {
		if (isEmpty())
			innerTree.addRoot(i);
		else
			insertElement(innerTree.root(), i);
	}

	@Override
	public boolean contains(Integer i) {
		return false;
	}

	@Override
	public void remove(Integer i) {
		
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return innerTree.size();
	}

	@Override
	public void clear() {
		innerTree = new LinkedBinaryTree<>();
	}

	private void insertElement(BTPosition<Integer> position, Integer i) {
		Integer element = position.getElement();
		if (i < element)
			shouldInsertLeftElement(position, i);
		else if (i > element)
			shouldInsertRightElement(position, i);
		else
			throw new IllegalArgumentException("A árvore já contém o valor " + i);
	}

	private void shouldInsertLeftElement(BTPosition<Integer> position, Integer i) {
		if (position.getLeft() != null)
			insertElement(position.getLeft(), i);
		
		innerTree.insertLeft(position, i);
	}
		
	private void shouldInsertRightElement(BTPosition<Integer> position, Integer i) {
		if (position.getRight() != null)
			insertElement(position.getRight(), i);
		
		innerTree.insertRight(position, i);
	}
	
}