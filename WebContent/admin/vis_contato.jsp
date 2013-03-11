<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=contato" class="button">Voltar</a>
	<h1>Contato</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psContato">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Contato</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Nome</strong></td>
				<td class="last">${atual.nome}</td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Telefone</strong></td>
				<td class="last">${atual.telefone}</td>
			</tr>
			<tr>
				<td class="first"><strong>E-mail</strong></td>
				<td class="last">${atual.email}</td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Assunto</strong></td>
				<td class="last">${atual.assunto}</td>
			</tr>
			<tr>
				<td class="first"><strong>Descrição</strong></td>
				<td class="last">${atual.descricao}</td>
			</tr>
		</table>
		<html:hidden property="pag" value="contato"/>
		<logic:present name="atual">
			<html:hidden property="id" value="${atual.id}"/>
		</logic:present>
	</html:form>
</div>