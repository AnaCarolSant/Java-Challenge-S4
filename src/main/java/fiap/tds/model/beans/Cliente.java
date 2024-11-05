package fiap.tds.model.beans;


import java.util.Date;



public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private Date dataNascimento;
    private Date dataCadastro;
    private String emailCliente;
    private int telefoneCliente;
    private String genero;
    private String cepCliente;
    private int numeroCliente;
    private String complemento;

    // Construtor vazio
    public Cliente() {}

    // Construtor parametrizado
    public Cliente(int idCliente, String nomeCliente, String cpfCliente, Date dataNascimento, Date dataCadastro,
                   String emailCliente, int telefoneCliente, String genero, String cepCliente, int numeroCliente, String complemento) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.genero = genero;
        this.cepCliente = cepCliente;
        this.numeroCliente = numeroCliente;
        this.complemento = complemento;
    }

    // Getters e Setters    
    
    
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public int getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(int telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
				+ ", dataNascimento=" + dataNascimento + ", dataCadastro=" + dataCadastro + ", emailCliente="
				+ emailCliente + ", telefoneCliente=" + telefoneCliente + ", genero=" + genero + ", cepCliente="
				+ cepCliente + ", numeroCliente=" + numeroCliente + ", complemento=" + complemento + "]";
	}

	 
}
