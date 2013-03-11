<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=cadEmail" class="button">Novo</a>
	<h1>Cadastro de E-mail</h1>
</div>
<br />
<div class="select-bar">
	<form action="redirectAdmin.mackstore" method="get">
		<label><input type="text" name="filtro" id="filtro" /></label>
		<label><input type="submit" value="Procurar..." /></label>
		<input type="hidden" name="pag" id="pag" value="email">
	</form>
</div>
<h4 class="erroLst"><html:errors prefix="" /></h4>
<div class="table">
	<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
	<img src="img/bg-th-right.gif" width="7" height="7" alt=""
		class="right" />
	<display:table id="listagemEmail" name="listar" requestURI="/admin/redirectAdmin.mackstore" pagesize="20" cellpadding="0" cellspacing="0" export="true">
		<display:column property="id" title="ID" sortable="true" class="first" headerClass="first"/>
		<display:column property="email" title="E-mail" sortable="true"/>
		<display:column title="Alterar" style="text-align: center;" url="/admin/redirectAdmin.mackstore?pag=cadEmail" paramId="id" paramProperty="id" media="html"><img src="img/edit-icon.gif" style="text-align: center;"/></display:column>
		<display:column title="Excluir" style="text-align: center;" class="last" headerClass="last" media="html">
			<img src="img/hr.gif" onclick="deletaReg('${listagemEmail.id}','${listagemEmail.email}','email');" style="cursor: pointer;"/>
		</display:column>
	</display:table>
</div>