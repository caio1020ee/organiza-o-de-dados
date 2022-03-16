package view;

import java.util.Scanner;

/**
 *
 * @author Luiz Fernando de Souza Matricula: 225272 OD - Prof.ª Silvia Brunini
 * ADS - Polo Sorocaba
 */
public class ManipulaVetores {

    /**
     * Classe principal para o Exercício Organização de Dados.
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double[] valores = new double[50];
        double recebeItem = 0.0;
        int opt = 0;

        try {
            System.out.println("---ManipulaVetores---\n"
                    + "Digite 8 valores para o VETOR!!!\n");

            for (int i = 0; i < 8; i++) {

                valores[i] = scan.nextDouble();

            }

            while (opt != 5) {

                System.out.println("\n--Selecione abaixo as opções--\n"
                        + "1 - Acrescentar Item.\n"
                        + "2 - Procurar Item.\n"
                        + "3 - Remover Item.\n"
                        + "4 - Mostrar Itens do Vetor\n"
                        + "5 - Sair"
                        + "--------------------\n");

                opt = scan.nextInt();

                switch (opt) {

                    case 1:

                        System.out.println("\nDigite o valor para adicionar Item: ");
                        recebeItem = scan.nextDouble();

                        if (inserirItem(valores, recebeItem, 0) == true) {

                            System.out.println("\nValor Inserido com SUCESSO!\n");

                        } else {

                            System.out.println("\nO valor NÃO pode ser incluido!\n");
                        }

                        break;
                    case 2:

                        System.out.println("\nDigite o valor para procurar Item: ");
                        recebeItem = scan.nextDouble();

                        if (procurarItem(valores, recebeItem, valores.length) == -1) {

                            System.out.println("\nO item NÃO EXISTE no Vetor!\n");

                        } else {

                            System.out.println("\nO item está na posição "
                                    + procurarItem(valores, recebeItem, valores.length)
                                    + " do Vetor!\n");

                        }

                        break;

                    case 3:

                        System.out.println("\nDigite o valor para remover o Item: ");
                        recebeItem = scan.nextDouble();

                        boolean verifica = removerItem(valores, recebeItem, valores.length);

                        if (verifica == false) {

                            System.out.println("\nO item NÃO EXISTE no Vetor!\n");

                        } else {

                            System.out.println("\nItem EXCLUÍDO!\n"
                                    + "\n-----Resultado-----\n");

                        }

                        break;
                    case 4:

                        System.out.println("\n-Resultado-\n"
                                + mostrarVetor(valores, valores.length));

                        break;

                    case 5:

                        System.out.println("\nSaindo da Aplicação!\n");

                        break;

                    default:

                        System.out.println("\nOpção INVÁLIDA!\n");

                        break;
                }
            }
        } catch (Exception ex) {

            System.out.println("Erro: " + ex.getMessage() + "\n");
            ex.printStackTrace();

        }

    }

    public static boolean inserirItem(double[] vetor, double valorLido,
            int qtdVetor) {

        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i] != 0) {

                qtdVetor++;

            } else {

                vetor[qtdVetor] = valorLido;

                return true;
            }
        }
        return false;
    }

    public static int procurarItem(double[] vetor, double valorLido,
            int qtdVetor) {

        for (int i = 0; i < qtdVetor; i++) {

            if (vetor[i] == valorLido) {

                return i;

            }

        }

        return -1;

    }

    public static boolean removerItem(double[] vetor, double valorLido,
            int qtdVetor) {

        int posicao = procurarItem(vetor, valorLido, qtdVetor);

        if (posicao != -1) {

            for (int i = 0; i < qtdVetor - 1; i++) {

                if (i >= posicao) {

                    vetor[i] = vetor[i + 1];

                }
            }
            return true;

        }

        return false;
    }

    public static String mostrarVetor(double[] vetor, int qtdVetor) {

        String resul = "";
        int pulaLinha = 0;

        for (int i = 0; i < vetor.length; i++) {

            resul = resul + String.valueOf("Pos.: " + i + " " + vetor[i]) + " ";
            pulaLinha++;

            if (pulaLinha % 10 == 0) {

                resul = resul + "\n";

            }

        }

        return resul;
    }
}
