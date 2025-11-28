// Lista encadeada de linhas

public class ListaLinhas {
    private NoListaString inicio;
    private int tamanho;

    public ListaLinhas() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionarLinha(int linha) {
        NoListaString novo = new NoListaString(linha);

        if(inicio == null) {
            inicio = novo;
        } else {
            NoListaString aux = inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }

            aux.proximo = novo;
        }

        tamanho++;
    }

    public String toString() {
        if(inicio == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        NoListaString aux = inicio;

        while (aux != null) {
            sb.append(aux.linha);

            if(aux.proximo != null) {
                sb.append(" ");
            }

            aux = aux.proximo;
        }

        return sb.toString();
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}
