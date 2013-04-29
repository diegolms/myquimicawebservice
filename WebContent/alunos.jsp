<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<%out.print(session.getAttribute("login"));%>!

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
				<h1>Alunos</h1>
			</div>

			<!--  start top-search -->
			<div id="top-search">

				<table border="0" cellpadding="5" cellspacing="0">

					<tr>

						<td><input type="text" value="Pesquisar"
							onblur="if (this.value=='') { this.value='Pesquisar'; }"
							onfocus="if (this.value=='Pesquisar') { this.value=''; }"
							class="top-search-inp" /></td>

						<td><select class="styledselect">

								<option value="">Nome</option>
								<option value="">Matrícula</option>
								<option value="">E-mail</option>

						</select></td>

						<td><input type="image"
							src="sistema/images/top_search_btn.gif" /></td>
					</tr>
				</table>
			</div>

			<!--  end top-search -->



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
						<!--  start content-table-inner -->
						<div id="content-table-inner">

							<table border="0" width="100%" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td>
										<!--  start step-holder -->
										<form id="mainform" action="">

											<table border="0" width="100%" cellpadding="0"
												cellspacing="0" id="product-table">
												<tr>
													<th class="table-header-repeat line-left"><a href="">ID</a></th>

													<th class="table-header-repeat line-left minwidth-1"><a
														href="">Nome</a></th>

													
													<th class="table-header-repeat line-left"><a href="">E-mail</a></th>

													<th class="table-header-repeat line-left"><a href="">Opções</a></th>

												</tr>
												<c:forEach items="${alunos}" var="aluno">
													<tr>
														<td><c:out value="${aluno.id}" /></td>
														<td><c:out value="${aluno.nome}" /></td>
														<td><c:out value="${aluno.email}" /></td>
														<td class="options-width"><a href="" title="Editar"
															class="icon-1 info-tooltip"></a> <a href=""
															title="Excluir" class="icon-2 info-tooltip"></a> <a
															href="" title="Turmas" class="icon-3 info-tooltip"></a> <a
															href="" title="Matricular" class="icon-5 info-tooltip"></a>
														</td>														
													</tr>
												</c:forEach>
											</table>
											<!--  end product-table................................... -->
										</form>
										<table border="0" cellpadding="0" cellspacing="0"
											id="paging-table">

											<tr>

												<td><a href="" class="page-far-left"></a> <a href=""
													class="page-left"></a>

													<div id="page-info">
														Page <strong>1</strong> / 1
													</div> <a href="" class="page-right"></a> <a href=""
													class="page-far-right"></a></td>

											</tr>
										</table>
									</td>
									<td><br> <br> <br> <br> <br> <br>
										<br> <br> <br> <br> <br> <br> <br>
										<br> <br> <br> <br> <br> <br> <br>
										<br> <br>
								</tr>
							</table>


						</div> <!--  end content-table-inner  -->
					</td>
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

	<div class="clear">&nbsp;</div>

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