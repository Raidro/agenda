package br.senac.rn.agenda.view;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;

import java.util.Scanner;

public class ContatoView {

    private static Scanner entrada = new Scanner(System.in);
    private static ContatoRepository bancoDeDados = new ContatoRepository();

    public static void main(String[] args) {

        Integer escolha = -1;

        do {
            ContatoView.getMenu();
            escolha = entrada.nextInt();


            switch (escolha) {
                case 1:
                    ContatoView.cadastrar();
                    break;
                case 2:
                    ContatoView.listarTodos();
                    break;
                case 3:

                    break;
            }


        } while (escolha != 0);


    }

    private static void listarTodos() {
        for (Contato contato : bancoDeDados.buscaTodos()) {
            String id = contato.getId().toString();
            String nome = contato.getNome();
            String fone = contato.getFone();

            String saida = id + " - " + nome + " - " + fone;
            System.out.println(saida);
        }
    }

    private static void cadastrar() {
        String nome;
        String fone;
        System.out.print("Digite o nome do contato: ");
        nome = entrada.next();
        System.out.print("Digite o telefone do contato: ");
        fone = entrada.next();
        Contato contato = new Contato(nome, fone);
        bancoDeDados.salva(contato);
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
