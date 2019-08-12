package br.senac.rn.agenda.model;

public class Contato {

    //definir o que as coisas são dentro do seu sistema;
    //model  - define o conceito das coisas dentro do sistema, como serão representados;
    //view - é a parte visual o que tem contato com o usuario (html, css, js);
    //controller  - regra de negocios;
    //repository ou DAO - é aonde ficam os dados persistentes, vulgo, banco de dados;

    private Long id;
    private String nome;
    private String fone;

    public Contato() {
    }

    public Contato(Long id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
