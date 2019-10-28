package br.univille.estd.binarytree;

/**
 * Implementacao de uma ·rvore bin·ria usando estrutura encadeada
 * 
 * @author AndrÈ Luis Cardoso 
 *
 * @param <E>
 */
public class LinkedBinaryTree<E> {
	
	protected BTPosition<E> root; // Referencia para a raiz
	protected int size;           // N˙mero de nodos
	
	/**
	 * Construtor de uma √°rvore vazia
	 */
	public LinkedBinaryTree() {
		root = null; // inicia com uma ·rvore vazia
		size = 0;
	}
	
	/**
	 * Retorna o numero de nodos da ·rvore
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Retorna se um nodo √© interno
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
	 * Retorna se um nodo √© externo
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
	 * Retorna se um nodo √© a raiz
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
	 * Retorna a raiz da √°rvore
	 */
	public BTPosition<E> root() throws EmptyTreeException{
		if(root == null ) {
			throw new EmptyTreeException("A Arvore est· vazia");
		}
		return root;
	}
	
	/**
	 * Retorna o filho da esquerda de um nodo
	 * Lan√ßa BoundaryViolationException se nao tiver filho da esquerda
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
	 * Lan√ßa BoundaryViolationException se nao tiver filho da direita
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
	 * Lan√ßa BoundaryViolationException se nao tiver pai
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
	 * Lan√ßa BoundaryViolationException se nao tiver um irmao
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
		
		E temp;
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
					var right = v.getRight();
					var left = v.getLeft();
					var parent = v.getParent();
					temp = v.getElement();
					if(left != null && right != null) {
						throw new InvalidPositionException("Nodo com dois filhos nao pode ser removido");
					}
					
					if(isRoot(v)) {
						temp = v.getElement();
						if(hasLeft(v)) {
							v = v.getLeft();
							v.setParent(null);
							root = v;
							size = size - 1;
						}else if(hasRight(v)) {
							v = v.getRight();
							v.setParent(null);
							root = v;
							size = size - 1;
						}else {
							v = null;
							root = null;
						}
					}else {
						if(parent.getLeft().equals(v)) {
							if(right != null) {
								v.getParent().setLeft(right);
								if(v.getParent().getLeft() != null) {
									v.getParent().getLeft().setParent(v.getParent());
								}
								size = size - 1;
							}else {
								v.getParent().setLeft(left);
								if(v.getParent().getLeft() != null) {
									v.getParent().getLeft().setParent(v.getParent());
								}
								size = size - 1;
							}
						}else {
							if(right != null) {
								v.getParent().setRight(right);
								if(v.getParent().getLeft() != null) {
									v.getParent().getRight().setParent(v.getParent());
								}
								size = size - 1;
							}else {
								v.getParent().setRight(left);
								if(v.getParent().getLeft() != null) {
									v.getParent().getRight().setParent(v.getParent());
								}
								size = size - 1;
							}
						}
					}
					
					
				
			}

		return temp;
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
