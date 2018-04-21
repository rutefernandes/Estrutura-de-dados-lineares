package arvore;


import arvore.ArvoreGenerica;
import arvore.InvalidPositionException;
import arvore.Position;
import java.util.Iterator;
import java.util.Vector;

public class ArvoreSimples implements ArvoreGenerica {
    //Atributos da árvore

    NoArvore raiz;
    int tamanho;
    //Construtor

    public ArvoreSimples(Object o) {
        raiz = new NoArvore(null, o);
        tamanho = 1;
    }
    
    @Override
    public String toString () {
        Iterator itr = printableTree();
        int h = this.height() + 5;
        int l = this.size() + 5;
        
        Object matrix[][] = new Object[h][l];
        
        int i = 0;
        while (itr.hasNext()) {
            NoArvore n = (NoArvore) itr.next();
            int d = this.depth(n);
            matrix[d][i] = n.element();
            i++;
        }
        
        String str = "";
        
        for (i = 0; i < h; i++){
            for (int j = 0; j < l; j++) {
                str += matrix[i][j] == null ? "  " : matrix[i][j] + " ";
            }
            str += "\n";
        }
        
        return str;
    }
    
    private Iterator printableTree() {
        Vector v = printableTree(this.raiz);
        
        return v.iterator();
    }
    
    private Vector printableTree(Position p) {
        Vector v = new Vector();
        NoArvore n = (NoArvore) p;
        if (isInternal(n)) {
            Iterator itr = n.children();
            int nmb = n.childrenNumber();
            int i = 1;
            while (itr.hasNext()) {
                NoArvore child = (NoArvore) itr.next();
                Vector subv = printableTree(child);
                v.addAll(subv);
                if (i == nmb/2) {
                    v.add(n);
                }
                i++;
            }
        } else {
            v.add(n);
        }
        
        return v;
    }

    /**
     * Retorna a raiz da árvore
     */
    public Position root() {
        return raiz;
    }

    /**
     * Retorna o nó pai de um nó
     */
    public Position parent(Position v) {
        NoArvore n = (NoArvore) v;
        return (n.parent());
    }

    /**
     * retorna os filhos de um nó
     */
    public Iterator children(Position v) {
        NoArvore n = (NoArvore) v;
        return n.children();
    }

    /**
     * Testa se um nó é interno
     */
    public boolean isInternal(Position v) {
        NoArvore n = (NoArvore) v;
        return (n.childrenNumber() > 0);
    }

    /**
     * Testa se um nó é externo
     */
    public boolean isExternal(Position v) {
        NoArvore n = (NoArvore) v;
        return (n.childrenNumber() == 0);
    }

    /**
     * Testa se um nó é a raiz
     */
    public boolean isRoot(Position v) {
        NoArvore n = (NoArvore) v;
        return n == raiz;
    }

    /**
     * Adiciona um filho a um nó
     */
    public void addChild(Position v, Object o) {
        NoArvore n = (NoArvore) v;
        NoArvore novo = new NoArvore(n, o);
        n.addChild(novo);
        tamanho++;
    }

    /**
     * Remove um nó Só pode remover nós externos e que tenham um pai (não seja
     * raiz)
     */
    public Object remove(Position v) throws InvalidPositionException {
        NoArvore n = (NoArvore) v;
        NoArvore pai = n.parent();
        if (pai != null || isExternal(n)) {
            pai.removeChild(n);
        } else {
            throw new InvalidPositionException();
        }
        Object o = n.element();
        tamanho--;
        return o;
    }

    /**
     * Troca dois elementos de posição
     */
    public void swapElements(Position v, Position w) {
        NoArvore n = (NoArvore) v;
        NoArvore m = (NoArvore) w;
        
        Object oldn = n.element();
        Object oldm = m.element();
        
        n.setElement(oldm);
        m.setElement(oldn);
        /*Método que serve de exercício
		 * Este método deverá fazer com que o objeto
		 * que estava na posição v fique na posição w
		 * e fazer com que o objeto que estava na posição w
		 * fique na posição v
         */

    }
    
    public Position buscar (Object o) {
        Iterator itr = preOrder();
        NoArvore n;
        while (itr.hasNext()) {
            n = (NoArvore) itr.next();
            if (n.element().equals(o))
                return n;
        }
        
        return null;
    }

    /**
     * Retorna a profundidade de um nó
     */
    public int depth(Position v) {
        NoArvore n = (NoArvore) v;
        int profundidade = profundidade(n);
        return profundidade;
    }

    private int profundidade(NoArvore n) {
        if (n == raiz) {
            return 0;
        } else {
            return 1 + profundidade(n.parent());
        }
    }

    /**
     * Retorna a altura da árvore
     */
    public int height() {
        // Método que serve de exercício
        int altura = altura(this.raiz);
        return altura;
    }
    
    private int altura(NoArvore n) {
        if (isExternal(n)) {
           return 0;
        } else {
           int h = 0;
           Iterator<NoArvore> itr = n.children();
           while (itr.hasNext()) {
               NoArvore no = itr.next();
               h = Math.max(h, altura(no));
           }
           
           return 1+h;
        }
       
    }
    
    public Iterator preOrder() {
        return preOrder(this.raiz).iterator();
    }
    
    private Vector preOrder(Position p) {
        Vector v = new Vector();
        NoArvore n = (NoArvore) p;
        v.add(n);
        if (isInternal(n)) {
            Iterator itr = n.children();
            while (itr.hasNext()) {
                NoArvore child = (NoArvore) itr.next();
                Vector subv = preOrder(child);
                v.addAll(subv);
            }
        }
        
        return v;
    }
    
    public Iterator postOrder() {
        return postOrder(this.raiz).iterator();
    }
    
    private Vector postOrder(Position p) {
        Vector v = new Vector();
        NoArvore n = (NoArvore) p;
        if (isInternal(n)) {
            Iterator itr = n.children();
            while (itr.hasNext()) {
                NoArvore child = (NoArvore) itr.next();
                Vector subv = postOrder(child);
                v.addAll(subv);
            }
        }
        v.add(n);
        
        return v;
    }

    /**
     * Retorna um iterator com os elementos armazenados na árvore
     */
    @Override
    public Iterator elements() {
        // Método não implementados --- Coleguinha fique a vontade para fazê-los
        Vector o = preOrder(this.raiz);
        Vector v = new Vector();
        
        for (Object idx : o) {
            NoArvore n = (NoArvore) idx;
            v.add(n.element());
        }
        
        return v.iterator();
    }

    /**
     * Retorna um iterator com as posições (nós) da árvore
     * @return 
     */
    public Iterator positions() {
        // Método não implementados --- Coleguinha fique a vontade para fazê-los
        return preOrder();
    }

    /**
     * Retorna o número de nós da árvore
     */
    public int size() {
        return this.tamanho;
    }

    /**
     * Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos
     * remover a raiz
     */
    public boolean isEmpty() {
        return false;
    }

    public Object replace(Position v, Object o) {
        NoArvore n = (NoArvore) v;
        Object or = n.element();
        n.setElement(o);
        return or;
    }

    @Override
    public Iterator nos() {
        return positions();
    }

    /* Início da classe aninhada para armazenar o nó*/
    private class NoArvore implements Position {

        private Object o;
        private NoArvore pai;
        private Vector filhos = new Vector();

        public NoArvore(NoArvore pai, Object o) {
            this.pai = pai;
            this.o = o;
        }

        public Object element() {
            return o;
        }

        public NoArvore parent() {
            return pai;
        }

        public void setElement(Object o) {
            this.o = o;
        }

        public void addChild(NoArvore o) {
            filhos.add(o);
        }

        public void removeChild(NoArvore o) {
            filhos.remove(o);
        }

        public int childrenNumber() {
            return filhos.size();
        }

        public Iterator children() {
            return filhos.iterator();
        }
    }
    /* Fim da classe aninhada para armazenar o nó */
}
