<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=cadComunicado" class="button">Novo</a>
	<h1>Cadastro de Comunicado</h1>
</div>
<br />
<div class="select-bar">
	<form action="redirectAdmin.mackstore" method="get">
		<label><input type="text" name="filtro" id="filtro" /></label>
		<label><input type="submit" value="Procurar..." /></label>
		<input type="hidden" name="pag" id="pag" value="comunicado">
	</form>
</div>
<h4 class="erroLst"><html:errors prefix="" /></h4>
<div class="table">
	<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
	<img src="img/bg-th-right.gif" width="7" height="7" alt=""
		class="right" />
	<display:table id="listagem" name="listar" 
		requestURI="/admin/redirectAdmin.mackstore" pagesize="20" cellpadding="0" cellspacing="0">
		<display:column property="id" title="ID" sortable="true" class="first" headerClass="first"/>
		<display:column property="titulo" title="T�tulo" sortable="true"/>
		<display:column property="data" title="Data" sortable="true" />
		<display:column title="Alterar" style="text-align: center;" url="/admin/redirectAdmin.mackstore?pag=cadComunicado" paramId="id" paramProperty="id"><img src="img/edit-icon.gif" style="text-align: center;"/></display:column>
		<display:column title="Excluir" style="text-align: center;" class="last" headerClass="last">
			<img src="img/hr.gif" onclick="deletaReg('${listagem.id}','${listagem.titulo}','comunicado');" style="cursor: pointer;"/>
		</display:column>
	</display:table>
</div>