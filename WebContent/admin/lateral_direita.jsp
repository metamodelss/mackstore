<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:present name="dica">
	<strong class="h">Dica do dia</strong>
	<div class="box">${dica.descricao}</div>
</logic:present>