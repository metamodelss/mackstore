<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=comunicado" class="button">Voltar</a>
	<h1>Cadastro de Comunicado</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psComunicado">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Cadastro de Comunicado</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Título</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ComunicadoBean" property="titulo" value="${atual.titulo}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ComunicadoBean" property="titulo"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent><br />
					<html:errors property="titulo" /></td>
			</tr>
			<tr class="bg">
				<td class="first" width="70"><strong>Subtítulo</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ComunicadoBean" property="subTitulo" value="${atual.subTitulo}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ComunicadoBean" property="subTitulo"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent><br />
					<html:errors property="subTitulo" /></td>
			</tr>
			<tr>
				<td class="first"><strong>Descrição</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:textarea name="ComunicadoBean" property="descricao" cols="50" rows="5"
						errorStyleClass="erroHighlight" value="${atual.descricao}"	
						errorKey="org.apache.struts.action.ERROR" styleId="CKEditor" /> 
					</logic:present>
					<logic:notPresent name="atual">
						<html:textarea name="ComunicadoBean"	property="descricao" cols="50" rows="5"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" 
						styleId="CKEditor" /> 
					</logic:notPresent>
					<ckeditor:replace  replace="CKEditor" basePath="ckeditor/" config="${configCK}" />
					<br />
					<html:errors property="descricao" />
				</td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Data</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ComunicadoBean" property="data"  value="${atual.data}" maxlength="10"
							errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" 
							styleId="data" styleClass="data"
							/>
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ComunicadoBean" property="data" maxlength="10" 
							errorStyleClass="erroHighlight"	errorKey="org.apache.struts.action.ERROR" 
							styleId="data" styleClass="data"
							/>
					</logic:notPresent>
						<img id="btCalendario" src="img/cal.gif" style="cursor: pointer;" 
							width="16" height="16" border="0" alt="Calendário">
					<br />
					<html:errors property="data" /></td>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Fonte</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ComunicadoBean" property="fonte" value="${atual.fonte}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ComunicadoBean" property="fonte"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent><br />
					<html:errors property="fonte" /></td>
			</tr>
		</table>
		<html:hidden property="pag" value="comunicado"/>
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