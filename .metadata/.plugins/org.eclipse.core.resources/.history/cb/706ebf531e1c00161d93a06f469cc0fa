package dao;
import java.sql.SQLException;
import classes_bd.*;
import dbo.*;


public class Cursos 
{
	
	protected MeuPreparedStatement bd;


	public Cursos(MeuPreparedStatement bd) throws Exception
	{
		if (bd==null)
           throw new Exception ("Acesso a BD nao fornecido");

       this.bd = bd;
	}

	public boolean cadastrado (int codCurso) throws Exception
	{
       boolean retorno = false;

       if (codCurso<=0)
           throw new Exception ("Código do Curso não fornecido");


       try
       {
           String sql;

           sql = "SELECT COUNT(*) AS QUANTOS " +
                 "FROM BDu14191.Curso WHERE codCurso = ?";

           bd.prepareStatement (sql);

           bd.setInt (1, codCurso);

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
           throw new Exception ("Erro ao procurar curso");
       }

       return retorno;
	}

	public void incluir (Curso curso) throws Exception
   {
       if (curso==null)
           throw new Exception ("Curso nao fornecido");
       if (cadastrado (curso.getCodCurso()))
              throw new Exception ("Curso já existe na base de dados");

       try
       {
           String sql;

           sql = "INSERT INTO BDu14191.Curso " +
                 "(codCurso,nome) VALUES (?,?)";

           bd.prepareStatement (sql);

           bd.setInt(1, curso.getCodCurso());
           bd.setString (2, curso.getNome());

           bd.executeUpdate ();
       }
       catch (SQLException erro)
       {
           throw new Exception ("Erro ao inserir curso");
       }
   	}
 
	public void excluir (int codCurso) throws Exception
	{
       if (codCurso<=0)
           throw new Exception ("Código do Curso nao fornecido");

       if (!cadastrado (codCurso))
           throw new Exception ("Nao cadastrado");

       try
       {
           String sql;

           sql = "DELETE FROM BDu14191.Curso WHERE codCurso=?";

           bd.prepareStatement (sql);

           bd.setInt (1, codCurso);

           bd.executeUpdate ();
       }
       catch (SQLException erro)
       {
           throw new Exception ("Erro ao excluir curso");
       }
	}
 
	public void alterar (int codCurso, String nome) throws Exception
	{
       if (codCurso <= 0)
           throw new Exception ("Curso nao fornecido");

       if (!cadastrado (codCurso))
           throw new Exception ("Nao cadastrado");

       try
       {
           String sql;

           sql = "UPDATE BDu14191.Curso SET NOME=? " +
                 "WHERE codCurso = ?";

           bd.prepareStatement (sql);

           bd.setString(1, nome);
           bd.setInt(2, codCurso);

           bd.executeUpdate ();
       }
       catch (SQLException erro)
       {
           throw new Exception ("Erro ao atualizar dados do curso");
       }
	}
 
	public Curso getCurso (int codCurso) throws Exception
	{
       if (codCurso<=0)
              throw new Exception ("Codigo do Curso nao fornecido");

       try
       {
           String sql;

           sql = "SELECT * FROM BDu14191.Curso WHERE CODIGO = ?";

           bd.prepareStatement (sql);

           bd.setInt (1, codCurso);

           MeuResultSet resultado = (MeuResultSet) bd.executeQuery ();

           if (!resultado.first())
               throw new Exception ("Nao cadastrado");

         Curso curso = new Curso (resultado.getInt(codCurso),resultado.getString("nome"));
         return curso;
       }
       catch (SQLException erro)
       {
           throw new Exception ("Erro ao procurar curso");
       }

       
	}
 
	public MeuResultSet getCursos() throws Exception
	{
       MeuResultSet resultado = null;

       try
       {
           String sql;

           sql = "SELECT * FROM BDu14191.Curso";

           bd.prepareStatement (sql);

           resultado = (MeuResultSet) bd.executeQuery();
       }
       catch (SQLException erro)
       {
           throw new Exception ("Erro ao recuperar curso");
       }

       return resultado;
	}



}