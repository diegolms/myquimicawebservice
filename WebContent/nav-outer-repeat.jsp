<html>
<head>
<link type="text/css" rel="stylesheet" href="sistema/screen.css" media="screen" title="default" />
</head>
<body>
	<div class="nav-outer-repeat">
		<!--  start nav-outer -->
		<div class="nav-outer">

			<!-- start nav-right -->
			<div id="nav-right">

				<div class="nav">
					<div class="nav-divider"></div>
						<ul class="select">
							<a href="minha_conta.jsp"><b>Minha Conta</b></a>
						</ul>

						<div class="nav-divider"></div>

						<ul class="select">
							<a href="LoginServlet?acao=logout"><b>Sair</b></a> 
							
						</ul>
				
				
				</div>

				<!--  end account-content -->

			</div>
			<!-- end nav-right -->


			<!--  start nav -->
			<div class="nav">
				<div class="table">

					<ul class="select">
						<a href="principal.jsp"><b>Principal</b></a> 
					</ul><div class="nav-divider"></div>

					<ul class="select">
					<!-- jsp:forward page="/AlunoServlet?action=listarAlunos"/><b>Alunos</b-->
					<a href="AlunoServlet?action=listarAlunos"><b>Alunos</b> </a> 		
					</ul>

					<div class="nav-divider"></div>

					<ul class="select">
						<a href="MisturaServlet?action=listarMisturas"><b>Misturas</b></a> 
							
					</ul>
					<div class="nav-divider"></div>
					
				</div>
				
			</div>
			<!--  start nav -->

		</div>
		
	</div>
</html>
</body>