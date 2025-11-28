// O que cada palavra guarda

public class EntradaIndice {
    public String palavra;
    public ListaLinhas linhas;

    public EntradaIndice(String palavra) {
        this.palavra = palavra.toLowerCase();
        this.linhas = new ListaLinhas();
    }

    public void adicionarLinha(int linha) {
        this.linhas.adicionarLinha(linha);
    }

    public String toString() {
        return palavra + " " + linhas.toString();
    }
}
