package br.senac.rn.agenda;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;

import java.util.List;

public class TestaPrograma {


    public static void main(String[] args) {


        ContatoRepository bancoDeDados = new ContatoRepository(); // vai acessar o banco de dados;

        Contato jota = new Contato(1L, "Jota Lopes", "9999-8888");

        bancoDeDados.salva(jota);

        Contato felipe = new Contato(2L, "Felipe Pontes", "8888-6666");

        Contato michele = new Contato(3L, "Michele Silva", "3232-1423");

        bancoDeDados.salva(michele);

        bancoDeDados.salva(felipe);

        // fazendo um "for each"

        List<Contato> contatos = bancoDeDados.buscaTodos();

        for (Contato contato : contatos) {
            System.out.println(contato.getNome());
        }

    }

}
