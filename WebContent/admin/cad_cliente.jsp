<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=cliente" class="button">Voltar</a>
	<h1>Cadastro de Cliente</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psCliente">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Cadastro de Cliente</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Nome</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ClienteBean" property="nome" value="${atual.nome}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ClienteBean" property="nome"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent><br />
					<html:errors property="nome" /></td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Endereço</strong></td>
				<td class="last">
					<html:select property="idEndereco" value="${atual.idEndereco}" errorStyleClass="erroHighlight"
						errorKey="org.apache.struts.action.ERROR">
						<html:option value="0">Selecionar</html:option>
						<html:options collection="listaEnderecos" property="id" labelProperty="rua"/>
					</html:select><br />
					<html:errors property="idEndereco" />
				</td>
			</tr>
		</table>
		<html:hidden property="pag" value="cliente"/>
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