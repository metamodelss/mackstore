<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:notPresent name="id_login">
	<jsp:forward page="login.jsp"/>
</logic:notPresent>
<logic:notPresent name="atual">
	<jsp:forward page="redirectAdmin.mackstore?pag=home"/>
</logic:notPresent>
<tiles:insert page="/admin/admin.jsp" flush="true">
    <tiles:put name="nomeMenu" value="Home" />
    <tiles:put name="topo" value="/admin/topo.jsp" />
    <tiles:put name="esquerda" value="/admin/lateral_esquerda.jsp" />
    <tiles:put name="corpo" value="/admin/home.jsp" />
    <tiles:put name="rodape" value="/admin/rodape.jsp" />
</tiles:insert>