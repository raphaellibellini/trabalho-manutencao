/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.bibliotecalpwsd.bean;

import br.cesjf.bibliotecalpwsd.util.ProcessReport;
import com.github.adminfaces.template.exception.BusinessException;

/**
 *
 * @author Raphaelli Bellini
 */
public class GenericDecorator extends ProcessReport implements InterfaceBean {
        @Override
        public void buscarPorId(Long id) {
            if (id == null) {
                throw new BusinessException("Insira um ID");
            }
        }
}
