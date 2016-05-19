package dbo;

public class Curso 
{
	private int codCurso;
	private String nome;
	
	
	public Curso(int codCurso, String nome) 
	{
		try 
		{
			this.setCodCurso(codCurso);
			this.setNome(nome);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCodCurso() 
	{
		return codCurso;
	}
	
	public void setCodCurso(int novoCodCurso) throws Exception
	{
		if(novoCodCurso < 0)
			throw new Exception("Ã�ndice negativo nÃ£o pode ser inserido");
		else
			this.codCurso = codCurso;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String novoNome) throws Exception
	{
		if(novoNome.trim() == "")
			throw new Exception("Nome nÃ£o pode ser nulo");
		else
			this.nome = nome;
	}
	
}

