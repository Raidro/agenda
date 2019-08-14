package br.senac.rn.agenda.view;

public class ContatoView {

    public static void main(String[] args) {



        System.out.println(getMenu());

    }

    private static String getMenu() {
        String menu = "";
        menu += " ============================  \n";
        menu += "1 - Cadastrar Novo Contato     \n";
        menu += "2 - Listar todos os Contatos   \n";
        menu += "3 - Buscar Contato             \n";
        menu += " ============================  \n";
        menu += "Opção: ";
        return menu;
    }

}
