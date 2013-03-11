<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=admin" class="button">Voltar</a>
	<h1>Cadastro de Administrador</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psAdmin"
		onsubmit="return validateAdminBean(this);">
		<html:javascript formName="AdminBean" />
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Cadastro de Administrador</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Usuário</strong></td>
				<td class="last">
					<logic:present name="adminAtual">
						<html:text name="AdminBean" property="usuario" value="${adminAtual.usuario}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="adminAtual">
						<html:text name="AdminBean" property="usuario"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="usuario" /></td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Senha</strong></td>
				<td class="last">
					<logic:present name="adminAtual">
						<html:password name="AdminBean"	property="senha" 
						errorStyleClass="erroHighlight" value="${adminAtual.senha}"	
						errorKey="org.apache.struts.action.ERROR" /> 
					</logic:present>
					<logic:notPresent name="adminAtual">
						<html:password name="AdminBean"	property="senha" 
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" /> 
					</logic:notPresent>
					<html:errors property="senha" />
				</td>
			</tr>
			<tr>
				<td class="first"><strong>E-mail</strong></td>
				<td class="last">
					<logic:present name="adminAtual">
						<html:text name="AdminBean" property="email"  value="${adminAtual.email}"
							errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="adminAtual">
						<html:text name="AdminBean" property="email" errorStyleClass="erroHighlight" 
							errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="email" /></td>
			</tr>
		</table>
		<html:hidden property="pag" value="admin"/>
		<logic:present name="adminAtual">
			<html:hidden property="id" value="${adminAtual.id}"/>
		</logic:present>
		<div class="select">
			<html:submit value="Salvar"
				style="border: 1px solid #9097a9; background-color: #9097a9; color: #FFF;cursor:pointer;" />
			<img src="img/save-icon.gif" alt="salvar"
				style="vertical-align: middle;" />
		</div>
	</html:form>
</div>