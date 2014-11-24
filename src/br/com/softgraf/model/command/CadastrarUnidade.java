package br.com.softgraf.model.command;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import br.com.softgraf.model.bean.Unidade;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class CadastrarUnidade implements InterfaceCommand {

    public CadastrarUnidade() {
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
    	Unidade unidade = new Unidade();
    	//br.com.softgraf.model.bean.Unidade unidade = new Unidade();
    	System.out.println("inicializamos ");
    	
    	try {
    		BeanUtils.populate(unidade, request.getParameterMap());
			
    		System.out.println("Dados" +unidade.toString());
    		
    		if (unidade.isValid()) {
    		System.out.println("Passou validacao");	
    	
    		
    		DAO<Unidade> unidadeDao = new DAOImpl<Unidade>(Unidade.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
    		
			
			unidadeDao.salvar(unidade);
			
    		}
			
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean");
			e.printStackTrace();
		
		}catch (InvocationTargetException e){
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean");
			e.printStackTrace();
		}
    	
    	
    
    	return "cadastra_unidade.jsp";
    }
    
}