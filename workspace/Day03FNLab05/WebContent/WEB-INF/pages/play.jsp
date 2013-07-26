<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<h1>Welcome to the guessing game. Enter a number between 1 and 100.</h1>
		<h3 style="color: #FF0000;">${sessionScope.error}</h3>
		<form method="post">
			Enter your guess <input type="text" name="guess"/><br/>
			<input type="submit" value="Guess"/>
		</form>
		
		<h5>${sessionScope.attemptsLine}</h5>
		<h3>${sessionScope.hint}</h3>
		
		<h6>${sessionScope.target}</h6>
	</body>
</html>