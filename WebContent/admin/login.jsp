<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Admin</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "css/all.css";</style>
</head>
<body>
<div id="main">
	<div id="header">
		<img src="img/mackstore.png" class="logo">
	</div>
	<div id="middle" style="height: 400px;">
		<div id="left-column"></div>
		<div id="center-column" style="min-height:200px;margin-top: 50px;border-bottom: 1px solid #979dad;">
			<div class="top-bar">
				<h1>Login</h1>
			</div><br />
		  <div class="select-bar" style="border-bottom: 0;"></div>
		  <h4 class="erroLst"><html:errors property="loginIncorreto" prefix="" /></h4><br>
		  <div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<html:form action="/admin/psLogin">
					<table class="listing form" cellpadding="0" cellspacing="0">
						<tr>
							<th class="full" colspan="2">Autenticação</th>
						</tr>
						<tr>
							<td class="first" width="172"><strong>Usuário</strong></td>
							<td class="last">
								<html:text property="usuario" name="AdminBean2" 
								errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR"/>
								<html:errors property="usuario" />
							</td>
						</tr>
						<tr class="bg">
							<td class="first"><strong>Senha</strong></td>
							<td class="last">
								<html:password property="senha" name="AdminBean2" 
								errorStyleClass="erroHighlight" errorKey="org.apache.struts.action.ERROR"/>
								<html:errors property="senha" />
							</td>
						</tr>
						<tr>
							<td class="first">&nbsp;</td>
							<td class="last">
								<html:submit value="Login"/>
							</td>
						</tr>
					</table>
				</html:form>
	        <p>&nbsp;</p>
		  </div>
		</div>
		<div id="right-column"></div>
	</div>
	<div id="footer"></div>
</div>
</body>
</html>