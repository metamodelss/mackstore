<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="produto" items="${produtos}" varStatus="count">
	<div class="item_wrap simpleCart_shelfItem">
		<div class="item_pic item-thumb"><img src="admin/arquivos/${fotosProdutos[count.index].arquivo}" width="75" height="75" /></div>
		<div class="item_title item_nome">${produto.nome}</div>
		<!-- <div class="item_stock"><i>In Stock</i></div> -->
		<div class="item_price item_preco">10</div>
		<div class="add_cart"><a href="javascript:;" class="item_add">Add to Cart</a></div>
	</div>
</c:forEach>