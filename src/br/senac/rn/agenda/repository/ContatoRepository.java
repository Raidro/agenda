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
    }

    public List<Contato> buscaTodos() {
        return contatos;
    }


}
