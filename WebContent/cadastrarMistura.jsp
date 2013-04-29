<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



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
				<h1>Cadastrar Nova Mistura</h1>
			</div>


			<table border="0" width="100%" cellpadding="0" cellspacing="0"
				id="content-table">
				<tr>
					<th rowspan="3" class="sized"><img
						src="sistema/images/side_shadowleft.jpg" width="20" height="300"
						alt="" /></th>
					<th class="topleft"></th>
					<td id="tbl-border-top">&nbsp;</td>
					<th class="topright"></th>
					<th rowspan="3" class="sized"><img
						src="sistema/images/side_shadowright.jpg" width="20" height="300"
						alt="" /></th>
				</tr>
				<tr>
					<td id="tbl-border-left"></td>
					<td>
						<div id="content-table-inner">

							<table border="0" width="100%" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td>

										<table width="573" cellpadding="0" cellspacing="0">
											<tr>
												<th width="70" height="34" valign="middle">Nome</th>
												<td><input type="text" class="inp-form" /></td>
												<td style=" width : 2928px;"><font color="red">Ex: Água</font><td>
												
											</tr>
											
											<tr>
												<th height="50" valign="middle">Mistura</th>
												<td><input type="text" class="inp-form" /></td>
												<td style=" width : 2928px;"><font color="red">Ex: H20</font></td>											
											</tr>
											

											<tr>
												<th height="30" valign="middle">Dica</th>
												<td><input type="text" class="inp-form" /></td>
												<td style=" width : 2928px;"><font color="red">Ex: 2 Átomos de um elemento da Família 1A + 1 Elemento da Família 6A </font></td>
											</tr>
											
											<tr>
												<th height="50" valign="middle">Informação</th>
												<td style=" width : 335px;"><input type="text" class="inp-form" /></td>
												<td style=" width : 2928px;"><font color="red">Ex: A ÁGUA é uma das substâncias mais abundantes em nosso planeta e pode ser encontrada em três estados físicos: sólido, líquido, e gasoso </font></td>
											</tr>
																						
										</table> 
										<br>
										<div>
											<input type="button" value="" class="form-submit" /> <input
												type="reset" value="" class="form-reset" />
										</div>
										
									<td></td>
								</tr>
							</table>
						</div>
					<td id="tbl-border-right"></td>
				</tr>
				<tr>
					<th class="sized bottomleft"></th>
					<td id="tbl-border-bottom">&nbsp;</td>
					<th class="sized bottomright"></th>
				</tr>
			</table>

			<div class="clear">&nbsp;</div>

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