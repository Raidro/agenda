package br.senac.rn.agenda.repository;

import br.senac.rn.agenda.model.Contato;

import java.util.ArrayList;
import java.util.List; // é um collection

public class ContatoRepository {

    private static List<Contato> contatos = new ArrayList<>();

    //static pode mudar;
    //atributos e metodos da classe por isso é estatico;
    //não quero começar uma nova lista toda vez que adcionar, criamos ele como static para evitar isso;

    public void salva(Contato contato) {
        contatos.add(contato);
        Long id = Long.valueOf(contatos.size());
        contato.setId(id);

    }
    //não se deve entregar o original, é sempre bom ter uma copia

    public List<Contato> buscaTodos() {
        List<Contato> copiaContatos = new ArrayList<Contato>(contatos);
        return copiaContatos;
    }

    public Contato buscaPeloId(Long id) {

        for (Contato contato : contatos) {
            if (contato.getId().equals(id)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscaPeloNome(String nome) {

        for (Contato contato : contatos) {
            if (contato.getNome().toLowerCase().equals(nome.toLowerCase())) {
                return contato;
            }

        }
        return null;

    }

    public void remove(Contato contato) {
        contatos.remove(contato);

    }

    public void edita(Contato contato) {

        for (Contato c : contatos) { // o "c" é o mesmo que contato, so abreviamos
            if (c.getId().equals(contato.getId())) {
                int indice = contatos.indexOf(c);
                contatos.set(indice, contato);
            }

        }


    }

}
