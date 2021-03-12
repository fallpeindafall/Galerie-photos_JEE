<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
  <meta charset="UTF-8">
	<link href="css/authentication.css" rel="stylesheet" />
	<link rel="stylesheet" href="css/design.css">
	
</head>
<body>
	
	
	<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form class="box">
                    <h1>Login</h1>
                    <p class="text-muted"> Please enter your login and password!</p> 
                    <input type="text" name="login" placeholder="Username" value="${form.login}"> 
                    <input type="password" name="password" placeholder="Password"> 
                    <a class="forgot text-muted" href="#">Forgot password?</a> 
                    <input type="submit" name="" value="login">
               	<c:if test="${!empty form}">
				<fieldset>
					<span class="erreur">${ form.statusMessage }</span>
				</fieldset>
				</c:if>
                </form>
            </div>
        </div>
    </div>
</div>
	


	
</body>
</html>