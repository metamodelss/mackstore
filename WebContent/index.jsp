<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:notPresent name="listagem">
	<jsp:forward page="/redirect.mackstore?pag=home"/>
</logic:notPresent>
<tiles:insert page="/site/site.jsp" flush="true">
    <tiles:put name="nomeMenu" value="Home" />
    <tiles:put name="topo" value="/site/topo.jsp" />
    <tiles:put name="lateral_esquerda" value="/site/lateral_esquerda.jsp" />
    <tiles:put name="corpo" value="/site/home.jsp" />
    <tiles:put name="lateral_direita" value="/site/lateral_direita.jsp" />
    <tiles:put name="rodape" value="/site/rodape.jsp" />
</tiles:insert>