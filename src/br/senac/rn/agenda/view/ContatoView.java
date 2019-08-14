package br.senac.rn.agenda.view;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;

import java.util.Scanner;

public class ContatoView {

    private static Scanner entrada = new Scanner(System.in);


    public static void main(String[] args) {

        Long escolha = 1L;
        ContatoRepository bancoDeDados = new ContatoRepository();

        do {
            ContatoView.getMenu();
            escolha = entrada.nextLong();

            if (escolha == 1) {

                String nome;
                String fone;
                System.out.print("Digite o nome do contato: ");
                nome = entrada.next();
                System.out.print("Digite o telefone do contato: ");
                fone = entrada.next();

                Contato contato = new Contato(nome, fone);
                bancoDeDados.salva(contato);
                System.out.println("\n" + "Contato salvo com Sucesso!!");
                System.out.println("Contato Salvo: " + contato.getNome() + "\n" + "Telefone: " + contato.getFone() + "\n");
//                System.out.println("Contato: " + bancoDeDados.buscaTodos());
            }

            if (escolha == 2) {

                for (Contato contato : bancoDeDados.buscaTodos()) {
                    System.out.println("Nome: " + contato.getNome() + " - Fone: " + contato.getFone());
                }

            }
        } while (escolha != 0);


    }

    private static void getMenu() {
        String menu = "";
        menu += " ============================  \n";
        menu += "1 - Cadastrar Novo Contato     \n";
        menu += "2 - Listar todos os Contatos   \n";
        menu += "3 - Buscar Contato             \n";
        menu += "0 - SAIR                       \n";
        menu += " ============================  \n";
        menu += "Opção: ";
        System.out.print(menu);
    }

}
