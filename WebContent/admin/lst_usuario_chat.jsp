<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=cadUsuarioChat" class="button">Novo</a>
	<h1>Usuário Chat</h1>
</div>
<br />
<div class="select-bar">
	<form action="redirectAdmin.mackstore" method="get">
		<label><input type="text" name="filtro" id="filtro" /></label>
		<label><input type="submit" value="Procurar..." /></label>
		<input type="hidden" name="pag" id="pag" value="usuarioChat">
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
		<display:column property="name" title="Nome" sortable="true"/>
		<display:column property="gravatar" title="Assunto" sortable="true"/>
		<display:column title="Logado" sortable="true" style="font-weight:bold;">
			<c:choose>
				<c:when test="${atual.logado}">
					<span style="color: green;">Conectado</span>
				</c:when>
				<c:otherwise>
					<span style="color: red;">Desconectado</span>				
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column title="Visualizar" style="text-align: center;" url="/admin/redirectAdmin.mackstore?pag=cadUsuarioChat" paramId="id" paramProperty="id"><img src="img/edit-icon.gif" style="text-align: center;"/></display:column>
		<display:column title="Excluir" style="text-align: center;" class="last" headerClass="last">
			<img src="img/hr.gif" onclick="deletaReg('${listagem.id}','${listagem.name}','usuarioChat');" style="cursor: pointer;"/>
		</display:column>
	</display:table>
</div>