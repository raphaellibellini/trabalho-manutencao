/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.bibliotecalpwsd.bean;

import javax.faces.event.ActionEvent;

/**
 *
 * @author Raphaelli Bellini
 */
public interface InterfaceFormBean {
    public void init();
    public void record(ActionEvent actionEvent);
    public void exclude(ActionEvent actionEvent);
    public boolean isNew();
    public void clear();
}
