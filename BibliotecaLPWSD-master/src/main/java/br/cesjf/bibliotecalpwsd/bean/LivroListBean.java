/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.bibliotecalpwsd.bean;

import br.cesjf.bibliotecalpwsd.dao.LivroDAO;
import br.cesjf.bibliotecalpwsd.model.Livro;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author dmeireles
 */
@Named
@ViewScoped
public class LivroListBean extends GenericDecorator implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Livro livro;
    private List livros;
    private List<Livro> livrosSelecionados;
    private List livrosFiltrados;
    private Long id;

    //construtor
    public LivroListBean() {
        livros = LivroDAO.getInstance().getList();
        livro = Livro.Builder
                     .newInstance()
                     .build();
    }

    //Métodos dos botões 
    public void record(ActionEvent actionEvent) {
        LivroDAO.getInstance().persist(livro);
        livros = LivroDAO.getInstance().getList();
    }

    public void exclude(ActionEvent actionEvent) {
        for (Livro l: livrosSelecionados){
            LivroDAO.getInstance().remove(l.getId());
        }
        livros = LivroDAO.getInstance().getList();
    }
    
    public void novo(ActionEvent actionEvent) {
        livro = Livro.Builder
                     .newInstance()
                     .build();
    }
    
    @Override
    public void buscarPorId(Long id) {
        super.buscarPorId(id);
        livrosSelecionados.add(LivroDAO.getInstance().find(id));
    }

    //getters and setters
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List getLivros() {
        return livros;
    }

    public void setLivros(List livros) {
        this.livros = livros;
    }

    public List getLivrosSelecionados() {
        return livrosSelecionados;
    }

    public void setLivrosSelecionados(List livrosSelecionados) {
        this.livrosSelecionados = livrosSelecionados;
    }

    public List getLivrosFiltrados() {
        return livrosFiltrados;
    }

    public void setLivrosFiltrados(List livrosFiltrados) {
        this.livrosFiltrados = livrosFiltrados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}