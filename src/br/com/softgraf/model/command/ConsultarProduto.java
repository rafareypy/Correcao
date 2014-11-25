package br.com.softgraf.model.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;




import br.com.softgraf.model.bean.*;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

public class ConsultarProduto implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Command consultar produto");
		DAO<Produto> produtoDAO = new DAOImpl<Produto>(Produto.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
		List<Produto> produtos = produtoDAO.getBeans();
		for (Produto produto : produtos) {
			System.out.println("" +produto.toString());
		}
		request.setAttribute("produtos", produtos);
		return "consulta_produto.jsp";
	}

}
