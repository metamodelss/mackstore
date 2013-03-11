<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=endereco" class="button">Voltar</a>
	<h1>Cadastro de Endereço</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psEndereco">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Endereço</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Rua</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="EnderecoBean" property="rua" value="${atual.rua}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="EnderecoBean" property="rua"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="rua" /></td>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Número</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="EnderecoBean" property="numero" value="${atual.numero}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="EnderecoBean" property="numero"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="numero" /></td>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Complemento</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="EnderecoBean" property="complemento" value="${atual.complemento}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="EnderecoBean" property="complemento"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="complemento" /></td>
			</tr>
		</table>
		<html:hidden property="pag" value="endereco"/>
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