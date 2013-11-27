/**
 * Funcoes utilitárias, como pegar altura da tela, etc.
 */

function redireciona(url) {
	window.location.href = url;
}

function alturaTela() {
	var h = screen.height;
	alert(h);
}

var myVar;
function mostrar(elementId, timeout) {
	myVar = setTimeout(function() {
		document.getElementById(elementId).className = '';
	}, timeout);
}
function esconder(elementId) {
	clearTimeout(myVar);
	document.getElementById(elementId).className = 'hidden';
}