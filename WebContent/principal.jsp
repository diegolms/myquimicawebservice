<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java" import="java.sql.*"%>
<%@ page language="java" import="br.com.myquimica.database.ConexaoBD"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if (session.getAttribute("login") != null) {
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyQuímica</title>
</head>

<body>
	<!-- h1>
		Bem vindo
		<%
		out.print(session.getAttribute("login"));
	%>!

	</h1-->

	<!-- page-top-outer......................... START -->
	<%@include file="page-top-outer.jsp"%>
	<!-- page-top-outer......................... END -->

	<!-- nav-outer-repeat......................... START -->
	<%@include file="nav-outer-repeat.jsp"%>
	<!-- nav-outer-repeat......................... END -->

	<div class="clear"></div>

	<!-- start content-outer -->
	<div id="content-outer">
			
		<!-- start content -->
		<div id="content">
			<div id="page-heading">
				<h1>Principal</h1>
			</div>

		

			<!--  end top-search -->



			

		</div>
		<!--  end content -->
		<div class="clear">&nbsp;</div>
	</div>
	<!--  end content-outer -->

	
	<!--  footer......................... START -->
	<%@include file="footer.jsp"%>
	<!--  footer......................... END -->
</body>



</body>

</html>

<%
	// se não existir um login na sessao, 
		// vai enviar para a página de login novamente
	} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>