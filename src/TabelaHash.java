public class TabelaHash {
    private class NoHash {
        EntradaIndice entrada;
        NoHash proximo;

        NoHash(EntradaIndice e) {
            this.entrada = e;
            this.proximo = null;
        }
    }

    private NoHash[] tabela;
    private int tamanho;

    public TabelaHash(int capacidade) {
        this.tabela = new NoHash[capacidade];
        this.tamanho = 0;
    }

    private int funcaoHash(String palavra) {
        int hash = 7;

        for (int i = 0; i < palavra.length(); i++) {
            hash = hash * 31 + palavra.charAt(i);
        }
        return Math.abs(hash) % tabela.length;
    }

    public void inserir(EntradaIndice entrada) {
        int pos = funcaoHash(entrada.palavra);
        NoHash novo = new NoHash(entrada);

        if(tabela[pos] == null) {
            tabela[pos] = novo;
        } else {
            NoHash aux = tabela[pos];
            while (aux.proximo != null) {
                aux = aux.proximo;
            }

            aux.proximo = novo;
        }

        tamanho++;
    }

    public EntradaIndice buscar(String palavra) {
        palavra = palavra.toLowerCase();
        int pos = funcaoHash(palavra);
        NoHash aux = tabela[pos];

        while(aux != null) {
            if(aux.entrada.palavra.equals(palavra)) {
                return aux.entrada;
            }

            aux = aux.proximo;
        }

        return null;
    }
}
