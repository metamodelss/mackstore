<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=email" class="button">Voltar</a>
	<h1>Cadastro de E-mail</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psEmail"
		onsubmit="return validateEmailBean(this);">
		<html:javascript formName="EmailBean" />
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">E-mail</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>E-mail</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="EmailBean" property="email" value="${atual.email}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="EmailBean" property="email"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="email" /></td>
			</tr>
		</table>
		<html:hidden property="pag" value="email"/>
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