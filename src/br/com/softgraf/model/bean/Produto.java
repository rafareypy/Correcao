package br.com.softgraf.model.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="produto")
public class Produto {

	private Integer codigo;
	private String descricao;
	private Double vlrcompra;
	private Double vlrvenda;
	private Integer estoque;
	private Integer critico;
	private String auditoria;
	private Unidade unidade;
	private Fornecedor fornecedor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getVlrcompra() {
		return vlrcompra;
	}
	public void setVlrcompra(Double vlrcompra) {
		this.vlrcompra = vlrcompra;
	}
	public Double getVlrvenda() {
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
	public Integer getCritico() {
		return critico;
	}
	public void setCritico(Integer critico) {
		this.critico = critico;
	}
	public String getAuditoria() {
		return auditoria;
	}
	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unidade_codigo")
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fornecedor_codigo")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	@Transient
	public boolean isValido() {
		if(descricao != null && descricao.length() > 3 && unidade != null && fornecedor != null )
			return true;
		return false;
	}
}
