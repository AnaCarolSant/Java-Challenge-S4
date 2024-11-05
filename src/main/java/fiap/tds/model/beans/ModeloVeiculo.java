package fiap.tds.model.beans;


import java.sql.Date;





public class ModeloVeiculo {
    private int idModeloVeiculo;
    private String nomeModeloVeiculo;
    private String marcaVeiculo;
    private Date anoFabricacao;
    private String combustivel;
    private String tipoCarroceria;
    private String tipoDirecao;
    private String tipoCambio;
    private String tipoFreios;
    private String tipoSuspensao;

    // Construtor vazio
    public ModeloVeiculo() {}

    // Construtor parametrizado
    public ModeloVeiculo(int idModeloVeiculo, String nomeModeloVeiculo, String marcaVeiculo, Date anoFabricacao, String combustivel,
                         String tipoCarroceria, String tipoDirecao, String tipoCambio, String tipoFreios, String tipoSuspensao) {
        this.idModeloVeiculo = idModeloVeiculo;
        this.nomeModeloVeiculo = nomeModeloVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.anoFabricacao = anoFabricacao;
        this.combustivel = combustivel;
        this.tipoCarroceria = tipoCarroceria;
        this.tipoDirecao = tipoDirecao;
        this.tipoCambio = tipoCambio;
        this.tipoFreios = tipoFreios;
        this.tipoSuspensao = tipoSuspensao;
    }

    // Getters e Setters
    
	public int getIdModeloVeiculo() {
		return idModeloVeiculo;
	}

	public void setIdModeloVeiculo(int idModeloVeiculo) {
		this.idModeloVeiculo = idModeloVeiculo;
	}

	public String getNomeModeloVeiculo() {
		return nomeModeloVeiculo;
	}

	public void setNomeModeloVeiculo(String nomeModeloVeiculo) {
		this.nomeModeloVeiculo = nomeModeloVeiculo;
	}

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public Date getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getTipoCarroceria() {
		return tipoCarroceria;
	}

	public void setTipoCarroceria(String tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}

	public String getTipoDirecao() {
		return tipoDirecao;
	}

	public void setTipoDirecao(String tipoDirecao) {
		this.tipoDirecao = tipoDirecao;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getTipoFreios() {
		return tipoFreios;
	}

	public void setTipoFreios(String tipoFreios) {
		this.tipoFreios = tipoFreios;
	}

	public String getTipoSuspensao() {
		return tipoSuspensao;
	}

	public void setTipoSuspensao(String tipoSuspensao) {
		this.tipoSuspensao = tipoSuspensao;
	}

	@Override
	public String toString() {
		return "ModeloVeiculo [idModeloVeiculo=" + idModeloVeiculo + ", nomeModeloVeiculo=" + nomeModeloVeiculo
				+ ", marcaVeiculo=" + marcaVeiculo + ", anoFabricacao=" + anoFabricacao + ", combustivel=" + combustivel
				+ ", tipoCarroceria=" + tipoCarroceria + ", tipoDirecao=" + tipoDirecao + ", tipoCambio=" + tipoCambio
				+ ", tipoFreios=" + tipoFreios + ", tipoSuspensao=" + tipoSuspensao + "]";
	}

	
    
}
