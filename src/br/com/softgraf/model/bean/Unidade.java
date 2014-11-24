package br.com.softgraf.model.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="unidade")
public class Unidade{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String descricao;
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
	public Boolean isValid(){
		boolean result = true;
		if ("".equals(codigo) || codigo == null ){
			result = false;
		}else if ("".equals(descricao)|| descricao== null ){
			result = false;
		}
		return result;
		
	}
	public String toString()
	{
			return "Codigo = "+codigo + " Descricao = "+descricao;
			
	}
		

}
