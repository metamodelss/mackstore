<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>eCommerce Website Template by: Dreamweaver Free</title>
<link href="site/css/style.css" rel="stylesheet" type="text/css" />
<!-- CART LIBS -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="site/js/cart/simpleCart.min.js"></script>
<!-- FIM CART LIBS -->
</head>

<body>
<script>
simpleCart({
	cartColumns: [
	              { attr: "nome" , label: false },
	              { attr: "preco", label: false, view: 'currency' },
	              { view: "decrement" , label: false },
	              { attr: "quantity" , label: "Qtde" },
	              { view: "increment" , label: false },
	              { attr: "total" , label: "SubTotal", view: 'currency' },
	              { view: "remover" , text: "Remover" , label: false }
	          ],
	currency: "BRL",
	cartStyle: "div"
});
</script>
<!-- Top links -->
<div id="top_bar">
	<ul>
<!-- 
    <li><a href="#">Entrar</a></li>
 -->
    <li>
    </li>
    </ul>
	<div class="simpleCart_items"></div>
</div>
<!-- Logo and search -->
<!-- 
<div id="head_wrapper">
	<div id="logo"><img src="site/images/logo.png" width="207" height="74" /></div>
    
    <div id="search_wrapper">
    <input name="search_btn" type="button" class="search_btn" />
    <input name="search" type="text" class="search" value="Procurar..." />
    </div>
</div>
 -->
<!-- Main menu and sub-menu -->
<div id="top_menu_wrap">
	<div id="top_menu">
    <ul>
    <li id="menu_active"><a href="redirect.mackstore?pag=home">Home</a></li>
    <!-- 
    <li><a href="#">Menu Item 2</a></li>
    <li><a href="#">Menu Item 3</a></li>
    <li><a href="#">Menu Item 4</a></li>
    <li><a href="#">Menu Item 5</a></li>
    <li><a href="#">Menu Item 6</a></li>
    <li><a href="#">Menu Item 7</a></li>
     -->
    </ul>
    </div>
    <!-- 
    <div id="sub_menu">
    <ul>
    <li><a href="#">Sub Item 1</a></li>
    <li><a href="#">Sub Item 2</a></li>
    <li><a href="#">Sub Item 3</a></li>
    <li><a href="#">Sub Item 4</a></li>
    <li><a href="#">Sub Item 5</a></li>
    <li><a href="#">Sub Item 6</a></li>
    </ul>
    </div>
     -->
</div>

<!-- Main content -->
<div id="main_container">
	<div id="content_wrap">
		<br />
		<tiles:insert attribute="corpo" ignore="true" />
    </div>

<!-- Left menu 1 (add as many extra menus as you like using the same class) -->
	<div class="left_menu_wrap">
		<tiles:insert attribute="lateral_esquerda" ignore="true" />
    </div>
<!-- Left menu 2-->  
<!--   
    <div class="left_menu_wrap">
    	<h2>Lorem Ipsum</h2>
		<div class="left_menu">
    	<ul>
    	<li>» <a href="#">Left Menu 1</a></li>
    	<li>» <a href="#">Left Menu 2</a></li>
    	<li>» <a href="#">Left Menu 3</a></li>
    	<li>» <a href="#">Left Menu 4</a></li>
    	<li>» <a href="#">Left Menu 5</a></li>
    	<li>» <a href="#">Left Menu 6</a></li>
    	</ul>
    	</div>
    </div>
 -->
</div>

<!-- Footer -->
<div id="footer">
	<div id="copyrights">MackStore 2013</div>
	<!-- 
    <div id="foot_menu">
    	<ul>
        <li><a href="#">Foot Item 1</a></li>
        <li><a href="#">Foot Item 2</a></li>
        <li><a href="#">Foot Item 3</a></li>
        <li><a href="#">Foot Item 4</a></li>
        </ul>
    </div>
     -->
</div>
</body>
</html>
