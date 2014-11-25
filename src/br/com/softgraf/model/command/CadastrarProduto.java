package br.com.softgraf.model.command;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import jdk.nashorn.internal.runtime.ListAdapter;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import br.com.softgraf.model.bean.Unidade;
import br.com.softgraf.model.bean.Fornecedor;
import br.com.softgraf.model.bean.Produto;
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
public class CadastrarProduto implements InterfaceCommand {

    public CadastrarProduto() {
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
    	Produto produto = new Produto();
    	
    	System.out.println("vamos cadastrar o produto ");
    	
    	try {
			BeanUtils.populate(produto, request.getParameterMap());					
			
			DAO<Unidade> unidadeDAO = new DAOImpl<Unidade>(Unidade.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
						
			List<Unidade> listaUnidade = unidadeDAO.getBeans();					
			
			for (Unidade unidade : listaUnidade) 
			{
				System.out.println("Unidades"+ unidade.toString());				
			}			
			
			request.setAttribute("unidades", unidadeDAO.getBeans());
			
			
			DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
			
			
			List<Fornecedor> listaFornecedor = fornecedorDAO.getBeans();
			
								
			request.setAttribute("fornecedores", listaFornecedor);
			
			java.util.List<Fornecedor> lista = fornecedorDAO.getBeans();
			
			
			
			System.out.println("Valores " + produto.toString());
			
			if(produto.isValid() == true)
			{
												
				produto.setVlrcompra(Double.parseDouble(request.getParameter("vlrcompra")) );

				produto.setVlrvenda(Double.parseDouble(request.getParameter("vlrvenda")) );
				
				DAO<Produto> produtoDAO = new DAOImpl<Produto>(Produto.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
				produtoDAO.salvar(produto);
			}else{
				request.setAttribute("mensagem", "Preencha os campos obrigat�rios");
			}
			
			
			
//			if(request.getMethod().equalsIgnoreCase("post"))
//			{
//				produto.setUnidade(unidadeDAO.getBean(Integer.valueOf(request.getParameter("unidade_codigo"))));
//				produto.setFornecedor(fornecedorDAO.getBean(Integer.valueOf(request.getParameter("fornecedor_codigo"))));
//				request.setAttribute("mensagem", "Preencha os campos obrigat�rios");				
//			}
//			request.setAttribute("produto", produto);
    					
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean");
			e.printStackTrace();
		
		}catch (InvocationTargetException e){
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean");
			e.printStackTrace();
		}
    	
    	
    
    	return "cadastra_produto.jsp";
    }
    
}