<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<div class="top-bar">
	<a href="redirectAdmin.mackstore?pag=produto" class="button">Voltar</a>
	<h1>Cadastro de Produto</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<div class="table">
	<html:form action="/admin/psProduto">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">Cadastro de Produto</th>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Nome</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ProdutoBean" property="nome" value="${atual.nome}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ProdutoBean" property="nome"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent><br />
					<html:errors property="nome" /></td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Categoria</strong></td>
				<td class="last">
					<html:select property="idCategoria" value="${atual.idCategoria}" errorStyleClass="erroHighlight"
						errorKey="org.apache.struts.action.ERROR">
						<html:option value="0">Selecionar</html:option>
						<html:options collection="listaCategorias" property="id" labelProperty="nome"/>
					</html:select><br />
					<html:errors property="idCategoria" />
				</td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Descrição</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:textarea name="ProdutoBean" property="descricao" cols="50" rows="5"
						errorStyleClass="erroHighlight" value="${atual.descricao}"	
						errorKey="org.apache.struts.action.ERROR" styleId="CKEditor" /> 
					</logic:present>
					<logic:notPresent name="atual">
						<html:textarea name="ProdutoBean"	property="descricao" cols="50" rows="5"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" 
						styleId="CKEditor" /> 
					</logic:notPresent>
					<ckeditor:replace  replace="CKEditor" basePath="ckeditor/" config="${configCK}" />
					<br />
					<html:errors property="descricao" />
				</td>
			</tr>
			<tr>
				<td class="first" width="70"><strong>Quantidade</strong></td>
				<td class="last">
					<logic:present name="atual">
						<html:text name="ProdutoBean" property="quantidade" value="${atual.quantidade}"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:present>
					<logic:notPresent name="atual">
						<html:text name="ProdutoBean" property="quantidade"
						errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR" />
					</logic:notPresent>
					<html:errors property="quantidade" /></td>
			</tr>
			<tr class="bg">
				<td class="first"><strong>Foto</strong></td>
				<td class="last">
					<html:select property="idFoto" value="${atual.idFoto}" errorStyleClass="erroHighlight"
						errorKey="org.apache.struts.action.ERROR">
						<html:option value="0">Selecionar</html:option>
						<html:options collection="listaFotos" property="id" labelProperty="nome"/>
					</html:select><br />
					<html:errors property="idFoto" />
				</td>
			</tr>
		</table>
		<html:hidden property="pag" value="produto"/>
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