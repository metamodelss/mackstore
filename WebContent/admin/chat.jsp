<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<div class="top-bar">
	<h1>Chat</h1>
</div>
<br />
<div class="select-bar" style="border-bottom: 0;"></div>
<h4 class="erroLst"><html:errors property="salvo" suffix="" prefix="" /></h4>
<div class="table">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt=""
			class="right" />
		<table class="listing form" cellpadding="0" cellspacing="0">
			<tr>
				<th class="full" colspan="2">SETOR DO CHAT</th>
			</tr>
			<tr class="bg">
				<td class="first" width="172"><strong>Teste</strong></td>
				<td class="last">${teste}</td>
			</tr>
		</table>
</div>