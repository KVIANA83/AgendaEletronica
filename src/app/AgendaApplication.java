package app;

import java.util.*;
import model.Contato;
import service.AgendaManager;
import exception.ContatoExistenteException;
import exception.ContatoNaoEncontradoException;

public class AgendaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaManager agenda = new AgendaManager();
        int opcao;

        do {
            System.out.println("\n===== AGENDA ELETRÔNICA =====");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Todos os Contatos");
            System.out.println("5. Salvar em CSV");
            System.out.println("6. Carregar de CSV");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    try {
                        agenda.adicionarContato(new Contato(nome, telefone, email));
                        System.out.println("Contato adicionado com sucesso!");
                    } catch (ContatoExistenteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nome para buscar: ");
                    nome = scanner.nextLine();
                    try {
                        Contato c = agenda.buscarContato(nome);
                        System.out.println("Contato encontrado: " + c);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nome para remover: ");
                    nome = scanner.nextLine();
                    try {
                        agenda.removerContato(nome);
                        System.out.println("Contato removido!");
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nLista de Contatos:");
                    for (Contato c : agenda.listarContatosOrdenados()) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    agenda.salvarContatosCSV("contatos.csv");
                    break;

                case 6:
                    agenda.carregarContatosCSV("contatos.csv");
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }
}

