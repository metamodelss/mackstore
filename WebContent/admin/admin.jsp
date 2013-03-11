<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:notPresent name="id_login">
	<jsp:forward page="login.jsp"/>
</logic:notPresent>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>Admin</title>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
	<style media="all" type="text/css">@import "css/all.css";</style>
	<link rel="shortcut icon" href="../site/img/icone.ico" type="image/x-icon" />
	<link rel="icon" type="../site/image/png" href="img/icone.png" />

	<link href="css/calendario.css" rel="stylesheet" type="text/css" />
	<link href="css/menu.css" rel="stylesheet" type="text/css" />
	<!-- JQUERY -->
	<script src="js/jquery-1.7.1.js"></script>
	<script src="js/jquery.maskedinput-1.3.js"></script>
	<script src="js/jquery.click-calendario-1.0.js"></script>
	<script src="js/exemplo-calendario.js"></script>
	<script src="js/funcoes.js"></script>
	<script src="js/jquery.treeview.js"></script>
	<!-- MOO TOOLS -->
	<script type="text/javascript" src="js/mootools/mootools-core-1.3-full-nocompat.js"></script>
	<script type="text/javascript" src="/WebContent/admin/js/mootools/mootools-more-1.3.0.1.js"></script>
	<script type="text/javascript" src="/WebContent/admin/js/mootools/Meio.Mask.js"></script>
	<script type="text/javascript" src="/WebContent/admin/js/mootools/Meio.Mask.Fixed.js"></script>
	<script type="text/javascript" src="/WebContent/admin/js/mootools/Meio.Mask.Reverse.js"></script>	
</head>
<body onload="arvoreMenu();">
<div id="main">
	<div id="header"><tiles:insert attribute="topo" ignore="true"/></div>
	<div id="middle">
		<div id="left-column"><tiles:insert attribute="esquerda" ignore="true"/></div>
		<div id="center-column"><tiles:insert attribute="corpo" ignore="true"/></div>
		<div id="right-column"><tiles:insert attribute="direita" ignore="true"/></div>
	</div>
	<div id="footer"></div>
</div>
</body>
</html>
