<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<div class="top-bar">
	<h1>Home</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<h4 class="erroLst"><html:errors property="salvo" suffix="" prefix="" /></h4>
		<!-- 
		 -->
<div class="table">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Menu rápido</th>
			</tr>
			<tr class="bg">
				<td class="first" width="172"><strong>Categoria</strong></td>
				<td class="last"><a href="redirectAdmin.mackstore?pag=cadCategoria">Cadastrar uma categoria</a></td>
			</tr>
			<tr class="bg">
				<td class="first" width="172"><strong>Produto</strong></td>
				<td class="last"><a href="redirectAdmin.mackstore?pag=cadProduto">Cadastrar um produto</a></td>
			</tr>
			<tr class="bg">
				<td class="first" width="172"><strong>Foto</strong></td>
				<td class="last"><a href="redirectAdmin.mackstore?pag=cadFoto">Cadastrar uma foto</a></td>
			</tr>
			<tr class="bg">
				<td class="first" width="172"><strong>Cliente</strong></td>
				<td class="last"><a href="redirectAdmin.mackstore?pag=cadCliente">Cadastrar uma cliente</a></td>
			</tr>
			<tr class="bg">
				<td class="first" width="172"><strong>Endereço</strong></td>
				<td class="last"><a href="redirectAdmin.mackstore?pag=cadEndereco">Cadastrar uma endereço</a></td>
			</tr>
		</table>
</div>