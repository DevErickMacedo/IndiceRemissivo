public class ArvoreBinariaBusca {

    class Nodo {
        EntradaIndice info;
        Nodo esquerdo;
        Nodo direito;

        public Nodo(EntradaIndice info) {
            this.info = info;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    private Nodo raiz;
    private int nElementos;

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public void inserir(EntradaIndice entrada) {
        this.raiz = inserirRec(this.raiz, entrada);
    }

    private Nodo inserirRec(Nodo nodo, EntradaIndice entrada) {
        if(nodo == null) {
            nElementos++;
            return new Nodo(entrada);
        }

        int cmp = entrada.palavra.compareTo(nodo.info.palavra);

        if(cmp < 0) {
            nodo.esquerdo = inserirRec(nodo.esquerdo, entrada);
        } else if (cmp > 0) {
            nodo.direito = inserirRec(nodo.direito, entrada);
        }

        return nodo;
    }

    public void emOrdem(java.io.PrintWriter printWriter) {
        emOrdemRec(raiz, printWriter);
    }

    private void emOrdemRec(Nodo nodo, java.io.PrintWriter printWriter) {
        if(nodo != null) {
            emOrdemRec(nodo.esquerdo, printWriter);
            printWriter.println(nodo.info.toString());
            System.out.println(nodo.info.toString());
            emOrdemRec(nodo.direito, printWriter);
        }
    }

    public EntradaIndice buscar(String palavra) {
        return buscarRec(raiz, palavra.toLowerCase());
    }

    private EntradaIndice buscarRec(Nodo nodo, String palavra) {
        if(nodo == null) {
            return null;
        }

        int cmp = palavra.compareTo(nodo.info.palavra);

        if(cmp == 0) {
            return nodo.info;
        }

        if (cmp < 0) {
            return buscarRec(nodo.esquerdo, palavra);
        }

        return buscarRec(nodo.direito, palavra);
    }
}
