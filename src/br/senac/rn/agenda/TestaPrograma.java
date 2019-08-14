package br.senac.rn.agenda;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;

import java.util.List;

public class TestaPrograma {


    public static void main(String[] args) {

        //não se re-organiza os id's

        ContatoRepository bancoDeDados = new ContatoRepository(); // vai acessar o banco de dados;

        Contato jota = new Contato("Jota Lopes", "9999-8888");

        bancoDeDados.salva(jota);

        Contato felipe = new Contato("Felipe Pontes", "8888-6666");

        Contato michele = new Contato("Michele Silva", "3232-1423");

        bancoDeDados.salva(michele);

        bancoDeDados.salva(felipe);

        // fazendo um "for each"

        List<Contato> contatos = bancoDeDados.buscaTodos();

        for (Contato contato : bancoDeDados.buscaTodos()) {
            System.out.println(contato.getId() + " - " + contato.getNome());
        }

//        Contato contatoBuscado = bancoDeDados.buscaPeloId(2L);
//        System.out.println(contatoBuscado.getNome());

//        Contato contatoBuscadoPorNome = bancoDeDados.buscaPeloNome("Michele Silva");
//        System.out.println(contatoBuscadoPorNome.getNome());


        Contato jotaLopes = new Contato("Jota L.", "9999-8888");

        jotaLopes.setId(1L);//é necessario que criemos o id igual ao id existente

        bancoDeDados.edita(jotaLopes);

        bancoDeDados.remove(jotaLopes);

        Contato caio = new Contato("Caio Silva","777-6565");
        bancoDeDados.salva(caio);


        System.out.println("============================================");

        for (Contato contato : bancoDeDados.buscaTodos()) {
            System.out.println(contato.getId() + " - " + contato.getNome());
        }

    }

}
