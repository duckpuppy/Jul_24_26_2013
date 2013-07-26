<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<html>
<head>
</head>
<body>
	<s:form method="POST" modelAttribute="person" >
		Name<s:input path="name"/>
		<s:errors path="name"></s:errors>
		<br/>
		Age <s:input path="age"/>
		<s:errors path="age"></s:errors>
		<br/>
		Street <s:input path="address.street"  />
		<br/>
		<input type="submit" value="Add person"/>
	</s:form>
	
</body>
</html>