package br.com.softgraf.model.helper;
import br.com.softgraf.model.command.AcessarUsuario;
import br.com.softgraf.model.command.CadastrarProduto;
import br.com.softgraf.model.command.CadastrarUnidade;
import br.com.softgraf.model.command.InicializaFornecedor;
import br.com.softgraf.model.command.InicializaUnidade;
import br.com.softgraf.model.command.InterfaceCommand;

import javax.servlet.http.HttpServletRequest;

import  br.com.softgraf.model.command.CadastrarFornecedor;

import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class SoftGrafHelper {
    
    private HttpServletRequest request;
    
    public SoftGrafHelper (HttpServletRequest request){
        super();
        this.request = request;
    }
    
    public InterfaceCommand getCommnand()
    {
    	
        String cmd = request.getParameter("cmd");
        System.out.println("Cmd passo = "+ cmd);
        if (cmd == null ) {
            return new AcessarUsuario();
        }
        else if (cmd.equals("iniciarSoftgraf"))
        {        
            return new InicializaFornecedor();
            
        }
        else if (cmd.equals("cadastrarUnidade")){
        	return new CadastrarUnidade();
        	//return new InicializaFornecedor();
        	
        }else if (cmd.equals("cadastrarProduto")){
        	return new CadastrarProduto();
        	
        }        		
        else if(cmd.equals("acessarUsuario")) 
        {        	
            return new AcessarUsuario();
        }else if(cmd.equals("cadastrarFornecedor"))
        	
        	return new CadastrarFornecedor();
    	else{
        	return new AcessarUsuario();
        }
        
        	
                   
      
    
            
       
        
                
    }
    
    
    
}
