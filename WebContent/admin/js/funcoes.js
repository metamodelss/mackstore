//FUNÇÕES NATIVAS DO SITE
function deletaReg(id, nome, bean) {
	linkDeleta = '/Kapcon/admin/redirectAdmin.mackstore?pag=' + bean
	+ '&deletaId=' + id;
	// alert(linkDeleta);
	aceita = confirm('Deseja realmente excluir o registro "' + id + ' | '
			+ nome + '"?');
	if (aceita == true) {
		location.href = linkDeleta;
	}
}
//UTILITÁRIOS

//ARVORE DE MENUS
function arvoreMenu() {
	$("#arvore_menu").treeview({
		toggle: function() {
			console.log("%s was toggled.", $(this).find(">span").text());
		}
	});
	
	$("#add").click(function() {
		var branches = $("<li><span class='folder'>New Sublist</span><ul>" + 
			"<li><span class='file'>Item1</span></li>" + 
			"<li><span class='file'>Item2</span></li></ul></li>").appendTo("#browser");
	});
}
//MÁSCARAS
jQuery(function($){
	$(".data").mask("99/99/9999");
	$(".telefone").mask("(99)9999-9999?9");
	$(".decimal").mask("999.99");
	$(".rg").mask("99.999.999-a");
	//$("#tel").mask("(99)9999-9999");
});

//LIMITA TEXTBOX
limite = 1000;
function soma(idText,lblCaracter) {
    var textArea = document.getElementById(idText);
    var lblQtdeCaracter = document.getElementById(lblCaracter);

    var mais_um = eval(textArea.value.length - 1);
    mais_um++;

    if (textArea.value.length > limite) {
    	textArea.value = '';
    	textArea.value = valor_limite;
        alert("Você deve digitar no máximo " + limite + " caracteres");
    }
    else {
        lblQtdeCaracter.value = '';
        lblQtdeCaracter.value = eval(mais_um);
        valor_limite = textArea.value;
        lblQtdeCaracter.innerHTML = (limite - mais_um)+' caracteres restantes';
    }
    lblQtdeCaracter.focus();
}

//CORTA TEXTO, REMOVE HTML
function generateShortText(qtdeCaracter,idContainer,idReg,nomeFoward){
	var descricao = $(idContainer).text();
	descricao = descricao.substr(0,200);
	(descricao.length==200)?descricao+='...':null;
	descricao = '<a href="?pag='+nomeFoward+'&id='+idReg+'">'+descricao+'</a>';
	$(idContainer).html(descricao);
}

function verifica(nameForm){
	var form = document.getElementById(nameForm);
	if(form.email.value == 'Cadastre seu e-mail aqui...') return;
	if(isEmail(form.email.value)){
		form.submit();
	}
	else{
		alert('Digite um e-mail válido!');
	}
}

function isEmail(email){
	var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return regex.test(email);
}

$(document).ready(function () {
	$('.len').each(function() {
		qtdeLimite = $(this).parent().children('.numLen').text();
		textContent = $(this).text();
		if(textContent.length > qtdeLimite){
			$(this).text(textContent.substring(0,qtdeLimite)+'...');
		}
	});
});