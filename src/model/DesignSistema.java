package model;

import java.sql.Blob;


public class DesignSistema {

	  private String corPrincipal;
	    private String corSecundaria;
	    private String fundoImagem;
	    private String corTerciaria;
	 
	    private String tipoFonte;
	    private String logoImagem;

	    public DesignSistema(String corPrincipal, String corSecundaria, String fundoImagem, String corTerciaria,  String tipoFonte,String logoImagem) {
	        this.corPrincipal = corPrincipal;
	        this.corSecundaria = corSecundaria;
	        this.fundoImagem = fundoImagem;
	        this.corTerciaria = corTerciaria;
	     
	        this.tipoFonte = tipoFonte;
	        this.logoImagem = logoImagem;
	    }

	    public String getCorPrincipal() {
	        return corPrincipal;
	    }

	    public void setCorPrincipal(String corPrincipal) {
	        this.corPrincipal = corPrincipal;
	    }

	    public String getCorSecundaria() {
	        return corSecundaria;
	    }

	    public void setCorSecundaria(String corSecundaria) {
	        this.corSecundaria = corSecundaria;
	    }

	    public String getFundoImagem() {
	        return fundoImagem;
	    }

	    public void setFundoImagem(String fundoImagem) {
	        this.fundoImagem = fundoImagem;
	    }

	    public String getCorTerciaria() {
	        return corTerciaria;
	    }

	    public void setCorTerciaria(String corTerciaria) {
	        this.corTerciaria = corTerciaria;
	    }

	

	    public String getTipoFonte() {
	        return tipoFonte;
	    }

	    public void setTipoFonte(String tipoFonte) {
	        this.tipoFonte = tipoFonte;
	    }

	    public String getLogoImagem() {
	        return logoImagem;
	    }

	    public void setLogoImagem(String logoImagem) {
	        this.logoImagem = logoImagem;
	    }
	
	
}
