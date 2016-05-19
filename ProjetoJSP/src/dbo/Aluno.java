package dbo;

public class Aluno 
{
	private String RA;
	private String nome;
	private String dataNascimento;
	private String RG;
	private String CPF;
	private String endereco;
	private String cidade;
	private String UF;
	private int idCurso;

	public Aluno(String novoRA, String novoNome, String novaDataNascimento, String novoRG, String novoCPF, String novoEndereco, String novaCidade, String novaUF, String novoIdCurso)
	{
		this.RA = novoRA;
		this.nome = novoNome;
		this.dataNascimento = novaDataNascimento;
		this.RG = novoRG;
		this.CPF = novoCPF;
		this.endereco = novoEndereco;
		this.cidade = novaCidade;
		this.UF = novaUF;
		this.idCurso = Integer.parseInt(novoIdCurso);
	}
	
	public String getRA() 
	{
		return RA;
	}
	
	public void setRA(String rA) 
	{
		RA = rA;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDataNascimento() 
	{
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}
	
	public String getRG() 
	{
		return RG;
	}
	
	public void setRG(String rG) 
	{
		RG = rG;
	}
	
	public String getCPF() 
	{
		return CPF;
	}
	
	public void setCPF(String cPF) 
	{
		CPF = cPF;
	}
	
	public String getEndereco() 
	{
		return endereco;
	}
	
	public void setEndereco(String endereco) 
	{
		this.endereco = endereco;
	}
	
	public String getCidade() 
	{
		return cidade;
	}
	
	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}
	
	public String getUF() 
	{
		return UF;
	}
	
	public void setUF(String uF) 
	{
		UF = uF;
	}

	public int getIdCurso()
	{
		return idCurso;
	}

	public void setIdCurso(int novoIdCurso)
	{
		this.idCurso = novoIdCurso;
	}
		
}