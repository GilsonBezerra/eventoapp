$("#botao-salvar").click(function(){
		var dados{
			nome: nome,
			local: local,
			data: data,
			horario: horario
			
		};
		$.post("http://localhost:8080/cadastrarEvento", dados);
	});