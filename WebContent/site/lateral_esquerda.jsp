<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Categorias</h2>
<div class="left_menu">
	<ul>
		<c:forEach var="categoria" items="${listagem}">
			<li>>> <a href="redirect.mackstore?pag=categoria&id=${categoria.id}">${categoria.nome}</a></li>
		</c:forEach>
	</ul>
</div>