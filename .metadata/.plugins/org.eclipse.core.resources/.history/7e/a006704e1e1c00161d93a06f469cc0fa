package dao;
import java.sql.SQLException;
import classes_bd.*;
import dbo.*;

public class Alunos 
{
	 protected MeuPreparedStatement bd;
	 
	 public Alunos(MeuPreparedStatement bd) throws Exception
	 {
		 if (bd==null)
	            throw new Exception ("Acesso a BD nao fornecido");

	        this.bd = bd;
	 }
	 
	 public boolean cadastrado (String ra) throws Exception
	 {
	        boolean retorno = false;

	        if (ra==null)
	            throw new Exception ("RA nao fornecido");

	        try
	        {
	            String sql;

	            sql = "SELECT COUNT(*) AS QUANTOS FROM BDu14191.Aluno WHERE BDu14191.Aluno.nome = ?";
	            
	            
	            bd.prepareStatement (sql);
	            bd.setString (1, ra);
	           
	            
	            MeuResultSet resultado = (MeuResultSet) bd.executeQuery ();
	            resultado.first();
	            retorno = resultado.getInt("QUANTOS") != 0;

	            /* // ou, se preferirmos,

	            String sql;
	            sql = "SELECT * FROM LIVROS WHERE CODIGO=?";
	            bd.prepareStatement (sql);
	            bd.setInt (1, codigo);
	            MeuResultSet resultado = bd.executeQuery ();
	            retorno = resultado.first();

	            */
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao procurar aluno");
	        }

	        return retorno;
	   }
	 
	  
	  public void incluir (Aluno aluno) throws Exception
	    {
	        if (aluno==null)
	            throw new Exception ("Aluno nao fornecido");
	        if (cadastrado (aluno.getRA()))
	            throw new Exception ("Aluno já existe na base de dados");

	        try
	        {
	            String sql;

	            sql = "INSERT INTO BDu14191.Aluno VALUES (?,?,?,?,?,?,?,?,?)";

	            bd.prepareStatement (sql);

	            bd.setString (1, aluno.getRA());
	            bd.setString (2, aluno.getNome());	            
	            bd.setString (3, aluno.getDataNascimento());
	            bd.setString (4, aluno.getRG());
	            bd.setString (5, aluno.getCPF());
	            bd.setString (6, aluno.getEndereco());
	            bd.setString (7, aluno.getCidade());
	            bd.setString (8, aluno.getUF());
	            bd.setInt (9, aluno.getIdCurso());

	            bd.executeUpdate ();
	            bd.commit();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao inserir aluno");
	        }
	    }
	  
	  public void excluir (String ra) throws Exception
	    {
	        if (ra==null)
	            throw new Exception ("RA nao fornecido");

	        if (!cadastrado (ra))
	            throw new Exception ("Nao cadastrado");

	        try
	        {
	            String sql;
	            
	            sql = "DELETE FROM BDu14191.Aluno WHERE RA=?";
	            bd.prepareStatement (sql);
	            bd.setString (1, ra);
	            bd.executeUpdate ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao excluir aluno");
	        }
	    }
	  
	  public void alterar (String ra, String endereco, String cidade, String uf, String curso) throws Exception
	    {
	        if (ra==null)
	            throw new Exception ("RA de aluno nao fornecido");

	        if (!cadastrado (ra))
	            throw new Exception ("Nao cadastrado");

	        try
	        {
	            String sql;

	            sql = "UPDATE BDu14191.Aluno SET endereco=? , cidade=? , UF=?, idCurso=? " +
	                  "WHERE ra=?";

	            bd.prepareStatement (sql);

	            bd.setString (1, endereco);
	            bd.setString (2, cidade);
	            bd.setString (3, uf);
	            bd.setString (4, curso);
	            bd.setString (5, ra);

	            bd.executeUpdate ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao atualizar dados de aluno");
	        }
	    }
	  
	  public Aluno getAluno (String ra) throws Exception
	    {
	        Aluno aluno = null;

	         if (ra==null)
	            throw new Exception ("RA de aluno nao fornecido");

	        try
	        {
	            String sql;

	            sql = "SELECT * FROM BDu14191.Aluno WHERE RA = ?";

	            bd.prepareStatement (sql);

	            bd.setString (1, ra);

	            MeuResultSet resultado = (MeuResultSet) bd.executeQuery ();

	            if (!resultado.first())
	                throw new Exception ("Nao cadastrado");

	           aluno = new Aluno (resultado.getString("RA"), resultado.getString("nome"), resultado.getString("dataNascimento"), 
	                               resultado.getString("RG"), resultado.getString("CPF"),
	                               resultado.getString("endereco"), resultado.getString("cidade"), resultado.getString("UF"), resultado.getInt("codCurso") + "");
	           
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao procurar aluno");
	        }

	        return aluno;
	    }
	  
	  public MeuResultSet getAlunos () throws Exception
	    {
	        MeuResultSet resultado = null;

	        try
	        {
	            String sql;

	            sql = "SELECT * FROM BDu14191.Aluno";

	            bd.prepareStatement (sql);

	            resultado = (MeuResultSet) bd.executeQuery();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao recuperar aluno");
	        }

	        return resultado;
	    }
	 
	 

}
