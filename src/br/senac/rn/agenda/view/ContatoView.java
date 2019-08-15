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
                    ContatoView.buscarPeloNome();
                    break;
                case 4:
                    ContatoView.editarContato();
                    break;
                case 5:
                    ContatoView.excluirContato();
                    break;
            }

        } while (escolha != 0);

    }

    private static void excluirContato() {

        String nome;
        System.out.print("Digite o nome do contato a ser Excluido: ");
        nome = entrada.next();
        Contato contatoBuscadoParaExcluir = bancoDeDados.buscaPeloNome(nome);
        bancoDeDados.remove(contatoBuscadoParaExcluir);

    }

    private static void editarContato() {

        String nome;
        String nomeEditado;
        String foneEditado;
        String respostaNome;
        String respostaFone;

        System.out.print("Digite o Contato a ser Editado: ");
        nome = entrada.next();
        Contato contatoBuscadoParaEditar = bancoDeDados.buscaPeloNome(nome);

        if (contatoBuscadoParaEditar == null) {
            System.out.println("Contato Inexistente!!");

        } else {

            System.out.println("Deseja alterar o nome? (S ou N)");
            respostaNome = entrada.next().toLowerCase().trim();

            if (respostaNome.equals("s")) {
                System.out.print("Digite o novo nome do contato: ");
                nomeEditado = entrada.next();
                contatoBuscadoParaEditar.setNome(nomeEditado);
            }

            System.out.println("Deseja alterar o fone? (S ou N)");
            respostaFone = entrada.next().toLowerCase().trim();

            if (respostaFone.equals("s")) {
                System.out.print("Digite o novo fone do contato: ");
                foneEditado = entrada.next();
                contatoBuscadoParaEditar.setFone(foneEditado);
            }

            bancoDeDados.edita(contatoBuscadoParaEditar);
        }

    }

    private static void buscarPeloNome() {

        String nome;
        System.out.print("Digite o nome do contato: ");
        nome = entrada.next();
        Contato contatoBuscado = bancoDeDados.buscaPeloNome(nome);

        if (contatoBuscado == null) {
            System.out.println("Contato Inexistente!!");

        } else {
            String id = contatoBuscado.getId().toString();
            String nomeBuscado = contatoBuscado.getNome();
            String fone = contatoBuscado.getFone();
            System.out.println(id + " - " + nomeBuscado + " - " + fone);
        }

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
        menu += "3 - Buscar Contato pelo Nome   \n";
        menu += "4 - Editar um contato          \n";
        menu += "5 - Excluir Contato            \n";
        menu += "0 - SAIR                       \n";
        menu += " ============================  \n";
        menu += "Opção: ";
        System.out.print(menu);
    }

}
