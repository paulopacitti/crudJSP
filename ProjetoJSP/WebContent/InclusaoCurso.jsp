<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse" %> 
<%@ page import="dao.*, dbo.*, bd.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

            <%!
                  // minhas vars privativas
                  private static final long serialVersionUID = 1L;
            %>


</head>
<body>

	<%
	try
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String codCurso = request.getParameter("codCurso");
		String nome = request.getParameter("nome");

		if(codCurso == "" || nome == "")
		{
              %>
                <script>
                    alert("Algum campo está vazio. Tente novamente.");
                </script>
                <%
            	return;
		}
		
		MeuPreparedStatement comando = (MeuPreparedStatement) request.getSession().getAttribute("conexao");
		if(comando == null)
		{
			comando = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver",
		            "jdbc:sqlserver://regulus:1433;databasename=BDu14191",
		            "BDu14191", "cotuca");
			request.getSession().setAttribute("conexao", comando);
			
			Curso curso = new Curso(Integer.parseInt(codCurso), nome); 
			try 
			{
				Cursos cursos = new Cursos(comando);
				cursos.incluir(curso);
                %>

                <script>
                    alert("Inclusão do curso realizado com sucesso realizada com sucesso.");
                </script>

                <%
            }
                catch (Exception e1)
                {

           %>
                    <script>
                        alert("SQLException");
                        e1.printStackTrace();
                        e1.getMessage();
                    </script>
                <%
                }

              }
            }

            catch(IOException e)
            {

            %>
                <script>
                    alert("IO Exception");
                </script>

            <%
                }
              catch (ClassNotFoundException e1)
          		{
          %>
              <script>
                alert("ClassNotFoundException");
              </script>
          <%
              }
              catch (SQLException e1)
              {
          %>
              <script>
                alert("ClassNotFoundException");
              </script>
          <%
              }
         %>

</body>
</html>