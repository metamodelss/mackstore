<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=usuarioChat" class="button">Voltar</a>
	<h1>Cadastro de Usuário Chat</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psUsuarioChat">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Cadastro de Usuário Chat</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Nome</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="UsuarioChatBean" property="name" value="${atual.name}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="UsuarioChatBean" property="name"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="name" /></td>
			</tr>
			<tr class="bg">
				<td class="first" width="70"><strong>Senha</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:password name="UsuarioChatBean" property="senha" value="${atual.name}" maxlength="50"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:password name="UsuarioChatBean" property="senha" maxlength="50"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="senha" />
				</td>
			</tr>
			<tr>
				<td class="first"><strong>Foto</strong></td>
				<td class="last">
					<html:select property="foto.id" value="${atual.foto.id}" errorStyleClass="erroHighlight"
						errorKey="org.apache.struts.action.ERROR">
						<html:option value="0">Selecionar</html:option>
						<html:options collection="listaFoto" property="id" labelProperty="nome"/>
					</html:select><br />
					<html:errors property="foto.id" />
				</td>
			</tr>
		</table>
		<html:hidden property="pag" value="UsuarioChat"/>
		<logic:present name="atual">
			<html:hidden property="id" value="${atual.id}"/>
		</logic:present>
		<div class="select">
			<html:submit value="Salvar"
				style="border: 1px solid #9097a9; background-color: #9097a9; color: #FFF;cursor:pointer;" />
			<img src="img/save-icon.gif" alt="salvar"
				style="vertical-align: middle;" />
		</div>
	</html:form>
</div>