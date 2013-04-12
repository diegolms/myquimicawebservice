<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyQuímica</title>
<style type="text/css">
.back {
    height: 100%;
    left: 0;
    position: absolute;
    top: 0;
    width: 100%;
}
</style>
<link type="text/css" rel="stylesheet" href="login/login-box.css" />

</head>
<body>	

   <br><br><br><br>    
   
	<div align="center" >
	<a href="http://code.google.com/p/myquimica/"><img src="login/images/tituloMyquimica.png" width="471"
		height="90" style="mmargin-left: 0px;" /></a>
	</div>
	<p><img src="login/images/background.png" class="back"/></p>
	<div style="padding: 0px 0 0 0px;" align="center">
		<div id="login-box">

			
			<form action="LoginServlet" method="post">
				<div id="login-box-name" style="margin-top: 5px;">Usuário:</div>
				<div id="login-box-field" style="margin-top: 5px;">
					<input name="login" class="form-login" title="Username" value=""
						size="30" maxlength="2048" />
				</div>
				<div id="login-box-name">Senha:</div>
				<div id="login-box-field">
					<input name="senha" type="password" class="form-login"
						title="Password" value="" size="30" maxlength="2048" />
				</div>

				<a href="#" style="margin-left: 170px;">Esqueceu sua senha?</a></span><br><br> 
				<%
				if (request.getParameter("erro") != null) {
				%>
					<b><font color="red"> Usuário ou Senha Inválidos </font></b>					
				<%
				}
				%> 
				<div>
				<br>
				<input type="image" src="login/images/login-btn.png"><br>				
				<input type="hidden" name="acao" value="login" />
				</div>
				
			</form>
	  </div>
	  
	  
</div>

</body>
</html>