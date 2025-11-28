import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndiceRemissivo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do arquivo de palavras chaves: ");
        String arqChaves = scanner.nextLine();

        System.out.println("Nome do arquivo de texto: ");
        String arqTexto = scanner.nextLine();

        TabelaHash tabelaHash = new TabelaHash(101);
        ArvoreBinariaBusca abb = new ArvoreBinariaBusca();

        FileReader fileReader = new FileReader(arqChaves);
        Scanner scChaves = new Scanner(fileReader);

        while (scChaves.hasNextLine()) {
            String palavra = scChaves.next().trim().toLowerCase();

            if(!palavra.isEmpty()) {
                EntradaIndice entrada = new EntradaIndice(palavra);
                tabelaHash.inserir(entrada);
                abb.inserir(entrada);
            }
        }

        scChaves.close();
        fileReader.close();

        // LER TEXTO LINHA POR LINHA
        fileReader = new FileReader(arqTexto);
        Scanner scTexto = new Scanner(fileReader);
        int numeroLinha = 1;

        while (scTexto.hasNextLine()) {
            String linha = scTexto.nextLine();

            linha = linha.replaceAll("[^\\w\\s-]", " "); // TRATA TODOS OS DADOS EXCETO LETRAS, NÚMEROS, ESPAÇOS E HÍFENS.

            String[] palavras = linha.split("\\s+"); // SEPARA POR ESPAÇOS

            for(String p : palavras) {
                p = p.trim();
                if (p.length() == 0) {
                    continue;
                }

                if(!Character.isLetter(p.charAt(0))) {
                    continue; // INDICA QUE O TEXTO DEVE COMEÇAR COM UMA LETRA;
                }

                // BUSCA NA TABELA HASH
                EntradaIndice encontrado = tabelaHash.buscar(p.toLowerCase());
                if (encontrado != null) {
                    encontrado.adicionarLinha(numeroLinha);
                }
            }

            numeroLinha++;
        }

        scTexto.close();
        fileReader.close();

        PrintWriter printWriter = new PrintWriter(new FileWriter("indice.txt"));
        abb.emOrdem(printWriter);
        printWriter.close();

        System.out.println("\nÍndice remissivo gerado com sucesso no arquivo 'indice.txt'!");
    }
}
