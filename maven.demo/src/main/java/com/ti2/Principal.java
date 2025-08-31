package com.ti2;

import java.util.Scanner;
public class Principal{

    public static void main(String[] args) {

        DAO dao = new DAO();
        dao.conectar();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Listar comidas");
            System.out.println("2 - Inserir comida");
            System.out.println("3 - Atualizar comida");
            System.out.println("4 - Excluir comida");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1: // Listar
                    Comidas[] comidas = dao.getComidas();
                    if (comidas != null && comidas.length > 0) {
                        System.out.println("==== Produtos cadastrados ====");
                        for (Comidas p : comidas) {
                            System.out.println(p.toString());
                        }
                    } else {
                        System.out.println("Nenhum produto encontrado.");
                    }
                    break;

                case 2: // Inserir
                    System.out.print("Identificador: ");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Ambiente: ");
                    String ambiente = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    Comidas novaComidas = new Comidas(numero, nome, tipo, ambiente, quantidade);
                    if (dao.inserirComida(novaComidas)) {
                        System.out.println("Produto inserido com sucesso!");
                    } else {
                        System.out.println("Erro ao inserir produto.");
                    }
                    break;

                case 3: // Atualizar
                    System.out.print("Número da comida a atualizar: ");
                    int numAtualizar = sc.nextInt();
                    sc.nextLine();

                    Comidas[] todasComidas = dao.getComidas();
                    Comidas comAtualizar = null;
                    if (todasComidas != null) {
                        for (Comidas p : todasComidas) {
                            if (p.getIdentificador() == numAtualizar) {
                                comAtualizar = p;
                                break;
                            }
                        }
                    }

                    if (comAtualizar != null) {
                        System.out.print("Novo nome (" + comAtualizar.getNome() + "): ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo tipo (" + comAtualizar.getTipo() + "): ");
                        String novoTipo = sc.nextLine();
                        System.out.print("Novo ambiente (" + comAtualizar.getAmbiente() + "): ");
                        String novoAmbiente = sc.nextLine();
                        System.out.print("Nova quantidade (" + comAtualizar.getQuantidade() + "): ");
                        int novaQtd = sc.nextInt();
                        sc.nextLine();

                        comAtualizar.setNome(novoNome);
                        comAtualizar.setTipo(novoTipo);
                        comAtualizar.setAmbiente(novoAmbiente);
                        comAtualizar.setQuantidade(novaQtd);

                        dao.atualizarComidas(comAtualizar);
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4: // Excluir
                    System.out.print("Número do produto a excluir: ");
                    int numExcluir = sc.nextInt();
                    sc.nextLine();
                    dao.excluirComidas(numExcluir);
                    System.out.println("Produto excluído com sucesso!");
                    break;

                case 5: // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 5);

        dao.close();
        sc.close();
    }
}