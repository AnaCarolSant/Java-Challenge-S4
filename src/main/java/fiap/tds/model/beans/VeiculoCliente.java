package fiap.tds.model.beans;


public class VeiculoCliente {
    private int idVeiculoCliente;
    private int idCliente;
    private String placaVeiculo;
    private int idModeloVeiculo; // Armazena o ID do ModeloVeiculo diretamente

    // Construtor vazio
    public VeiculoCliente() {}

    // Construtor parametrizado
    public VeiculoCliente(int idVeiculoCliente, int idCliente, String placaVeiculo, int idModeloVeiculo) {
        this.idVeiculoCliente = idVeiculoCliente;
        this.idCliente = idCliente;
        this.placaVeiculo = placaVeiculo;
        this.idModeloVeiculo = idModeloVeiculo;
    }

    // Getters e Setters
    public int getIdVeiculoCliente() {
        return idVeiculoCliente;
    }

    public void setIdVeiculoCliente(int idVeiculoCliente) {
        this.idVeiculoCliente = idVeiculoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public int getIdModeloVeiculo() {
        return idModeloVeiculo;
    }

    public void setIdModeloVeiculo(int idModeloVeiculo) {
        this.idModeloVeiculo = idModeloVeiculo;
    }

	@Override
	public String toString() {
		return "VeiculoCliente [idVeiculoCliente=" + idVeiculoCliente + ", idCliente=" + idCliente + ", placaVeiculo="
				+ placaVeiculo + ", idModeloVeiculo=" + idModeloVeiculo + "]";
	}
    
    
}
