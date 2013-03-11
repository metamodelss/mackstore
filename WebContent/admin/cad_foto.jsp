<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=foto" class="button">Voltar</a>
	<h1>Cadastro de Foto</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psFoto" enctype="multipart/form-data">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Cadastro de Foto</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Nome</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="FotoBean" property="nome" value="${atual.nome}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="FotoBean" property="nome"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
						<br />
						<html:errors property="nome" />
				</td>	
			</tr>
			<tr class="bg">
				<td class="first" width="70"><strong>Arquivo</strong></td>
				<td class="last">
					<html:file name="FotoBean" property="file"
					errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					<logic:present name="atual">
						<br/>
						Arquivo atual:
						<span class="erro">&nbsp;${atual.arquivo}</span>
						<html:hidden property="id" value="${atual.id}"/>
						<html:hidden property="arquivo" value="${atual.arquivo}"/>
					</logic:present><br />
					<html:errors property="file" />
				</td>
			</tr>
		</table>
		<html:hidden property="pag" value="foto"/>
		<div class="select">
			<html:submit value="Salvar"
				style="border: 1px solid #9097a9; background-color: #9097a9; color: #FFF;cursor:pointer;" />
			<img src="img/save-icon.gif" alt="salvar"
				style="vertical-align: middle;" />
		</div>
	</html:form>
</div>