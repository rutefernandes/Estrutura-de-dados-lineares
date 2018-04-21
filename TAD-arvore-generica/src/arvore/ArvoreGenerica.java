package arvore;

/**
 * Classe que extende de Arvore e acrescenta métodos para adicionar 
 * nós em uma árvore e remover nós da árvore
 */
public interface ArvoreGenerica extends Arvore
{
	/**
	 * @param v Posição que vai receber esse filho
	 * @param o Objeto que vai ficar nessa posição
	 */
	public void addChild(Position v, Object o);
	
	/**
	 * @param v
	 * @return Objeto que estava na posção que foi removida
	 * @throws InvalidPositionException
	 */
	public Object remove(Position v) throws InvalidPositionException;
}