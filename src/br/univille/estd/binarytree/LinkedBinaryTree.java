package br.univille.estd.binarytree;

/**
 * Implementacao de uma árvore binária usando estrutura encadeada
 * @author leandersonandre
 *
 * @param <E>
 */
public class LinkedBinaryTree<E> {
	
	protected BTPosition<E> root; // Referencia para a raiz
	protected int size;           // Numero de nodos
	
	/**
	 * Construtor de uma árvore vazia
	 */
	public LinkedBinaryTree() {
		root = null; // inicia com uma árvore vazia
		size = 0;
	}
	
	/**
	 * Retorna o numero de nodos da árvore
	 * @return
	 */
	public int size() {
		if(root != null) {
			return size;
		}else {
			throw new EmptyTreeException("Arvore vazia");
		}
	}
	
	/**
	 * Retorna se um nodo é interno
	 */
	public boolean isInternal(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			if(v.getLeft() == null && v.getRight() == null) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	
	/**
	 * Retorna se um nodo é externo
	 */
	public boolean isExternal(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			if(v.getLeft() == null && v.getRight() == null) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * Retorna se um nodo é a raiz
	 */
	public boolean isRoot(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			return v.equals(root);
		}
		
	}
	/**
	 * Retorna se um nodo tem o filho da esquerda
	 */
	public boolean hasLeft(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}else {
			if(v.getLeft() == null) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	/**
	 * Retorna se um nodo tem o filho da direita
	 */
	public boolean hasRight(BTPosition<E> v) throws InvalidPositionException{
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			if(v.getRight() == null) {
				return false;
			}else {
				return true;
			}
		}
		
	}
	
	/**
	 * Retorna a raiz da árvore
	 */
	public BTPosition<E> root() throws EmptyTreeException{
		return root;
	}
	
	/**
	 * Retorna o filho da esquerda de um nodo
	 * Lança BoundaryViolationException se nao tiver filho da esquerda
	 */
	public BTPosition<E> left(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else{
			if(v.getLeft() == null) {
				throw new BoundaryViolationException("Raiz nao tem filho da esquerda");
			}
			else {
				return v.getLeft();
			}
		}
	}
	
	/**
	 * Retorna o filho da direita de um nodo
	 * Lança BoundaryViolationException se nao tiver filho da direita
	 */
	public BTPosition<E> right(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else{
			if(v.getRight() == null) {
				throw new BoundaryViolationException("Raiz nao tem filho da direita");
			}
			else {
				return v.getRight();
			}
		}
	}
	
	/**
	 * Retorna o pai de um nodo
	 * Lança BoundaryViolationException se nao tiver pai
	 */
	public BTPosition<E> parent(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else{
			if(v.getParent() == null) {
				throw new BoundaryViolationException("Raiz nao tem pai");
			}
			else {
				return v.getParent();
			}
		}
	}
	
	/**
	 * Substitui o elemento armazenado no nodo
	 * Retorna o elemento substituido
	 */
	public E replace(BTPosition<E> v, E o) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			var temp = v.getElement();
			v.setElement(o);
			
			return temp;
		}
		
	}
	
	/**
	 * Retorna o irmao de um nodo
	 * Lança BoundaryViolationException se nao tiver um irmao
	 */
	public BTPosition<E> sibling(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			var parent = v.getParent();
			if(hasLeft(parent) && left(parent).equals(v) == false) {
				return left(parent);
			}else if(hasRight(parent) && right(parent).equals(v) == false) {
				return right(parent);
			}else {
				throw new BoundaryViolationException("Nodo nao possui irmao");
			}
		}
	}
	
	/**
	 * Insere a raiz em uma arvore vazia
	 */
	public BTPosition<E> addRoot(E e) throws NonEmptyTreeException{
		if(root == null) {
			root = new BTPosition<E>();
			root.setElement(e);
			size = size + 1;
			return root;
		}else {
			throw new NonEmptyTreeException("Arvore ja possui raiz");
		}
		
	}
	
	/**
	 * Insere o filho da esquerda em um nodo
	 */
	public BTPosition<E> insertLeft(BTPosition<E> v, E e) throws InvalidPositionException{
		BTPosition<E> node = new BTPosition<E>();
		node.setElement(e);
		node.setParent(v);
		v.setLeft(node);
		size = size + 1;
		
		return node;
	}
	
	/**
	 * Insere o filho da direita em um nodo
	 */
	public BTPosition<E> insertRight(BTPosition<E> v, E e) throws InvalidPositionException{
		BTPosition<E> node = new BTPosition<E>();
		node.setElement(e);
		node.setParent(v);
		v.setRight(node);
		size = size + 1;
		
		return node;
	}
	
	/**
	 * Remove um nodo com zero ou um filho
	 * Nao pode remover um nodo com dois filhos. Deve lancar InvalidPositionException
	 */
	public E remove(BTPosition<E> v) throws InvalidPositionException{
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			
			try {
				if(sibling(v) != null) {
					throw new InvalidPositionException("Nodo com dois filhos nao pode ser removido");
				}
			}
			catch(Exception e){
				if(e instanceof BoundaryViolationException) {
					var parent = v.getParent();
					parent.setRight(v.getRight());
					parent.setLeft(v.getLeft());
				}
			}
			
		}
		

		return v.getElement();
	}
	
	/**
	 *  Cria um novo nodo para a arvore binaria
	 */
	protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		
		BTPosition<E> node = new BTPosition<E>();
		node.setParent(parent);
		node.setLeft(left);
		node.setRight(right);
		node.setElement(element);
		size = size + 1;

		return node;
	}

}
