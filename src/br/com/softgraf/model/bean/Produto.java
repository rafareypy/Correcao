package br.com.softgraf.model.bean;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="produto")
public class Produto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private Integer unidade_codigo;
	private Integer fornecedor_codigo;
	private String descricao;
	private double vlrcompra;
	private double vlrvenda;
	private Integer estoque;
	private Integer critico;
	private String auditoria;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getUnidade_codigo() {
		return unidade_codigo;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unidade_codigo")
	public void setUnidade_codigo(Integer unidade_codigo) {
		this.unidade_codigo = unidade_codigo;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fornecedor_codigo")
	
	public Integer getFornecedor_codigo() {
		return fornecedor_codigo;
	}
	public void setFornecedor_codigo(Integer fornecedor_codigo) {
		this.fornecedor_codigo = fornecedor_codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getVlrcompra() {
		return vlrcompra;
	}
	public void setVlrcompra(Double vlrcompra) {
		this.vlrcompra = vlrcompra;
	}
	public double getVlrvenda() {
		return vlrvenda;
	}
	public void setVlrvenda(Double vlrvenda) {
		this.vlrvenda = vlrvenda;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public String getAuditoria() {
		return auditoria;
	}
	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
	
	
	public Boolean isValid(){
		boolean result = true;
		if ("".equals(codigo) || codigo == null ){
			result = false;
		}else if ("".equals(descricao)|| descricao== null ){
			result = false;
		}else if ("".equals(unidade_codigo)|| unidade_codigo== null ){
			result = false;
		return result;
		}else if ("".equals(fornecedor_codigo)|| fornecedor_codigo== null ){
			result = false;
		}
		return result;
	}
	public String toString()
	{
			return "Codigo = "+codigo + "Codigo unidade = "+unidade_codigo + "Codigo Fornecedor = "+fornecedor_codigo;
			
	}
		

}
