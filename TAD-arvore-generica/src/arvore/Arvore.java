package arvore;

import java.util.Iterator;
/**
 * Interface que define os métodos de Arvore
 */
public interface Arvore
{
	/* Métodos genéricos */
	/** Retorna o número de nós da árvore */
	public int size();
	/** retorna se a árvore está vazia */
	public boolean isEmpty();
	/** Retorna a altura da árvore */
	public int height();
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements();
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator nos();

	/* Métodos de acesso*/
	/** Retorna a raiz da árvore */
	public Position root();
	/** Retorna o nó pai de um nó */
	public Position parent(Position v);
	/** Retorna os filhos de um nó */
	public Iterator children(Position v);

	/* Métodos de consulta */
	/** Testa se um nó é interno */
	public boolean isInternal(Position v);
	/** Testa se um nó é externo*/
	public boolean isExternal(Position v);
	/** Testa se um nó é a raiz */
	public boolean isRoot(Position v);
	/** Retorna a profundidade de um nó */
	public int depth(Position v);

	/* Métodos de atualização */
	/** Substitui o objeto de um um nó */
	public Object replace(Position v, Object o);
}