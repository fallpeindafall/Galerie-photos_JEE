<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<title>Sing Up Page</title>
  <meta charset="UTF-8">
	<link href="css/signup.css" rel="stylesheet" />
</head>
<body>
	
	
	<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form class="box">
                    <h1>Login</h1>
                    <p class="text-muted"> Please enter your login and password!</p> 
                    <input type="text" name="prenom" placeholder="Firstname" value="${form.utilisateur.prenom}"> 
                    <span class="erreur">${ form.erreurs.prenom }</span>
                    
                    <input type="text" name="nom" placeholder="Lastname" value="${form.utilisateur.nom}"> 
                    <span class="erreur">${ form.erreurs.nom }</span>
                    
                    <input type="email" name="login" placeholder="toi@gmail.com" value="${form.utilisateur.login}">
                    <span class="erreur">${ form.erreurs.login }</span>
                    
                    <input type="password" name="password" placeholder="Password" value="${form.utilisateur.password}">
                    <span class="erreur">${ form.erreurs.password }</span>
                    <input type="password" name="passwordBis" placeholder="Password" value="${form.utilisateur.passwordBis}">
                 	<span class="erreur">${ form.erreurs.passwordBis }</span>
                 	
                    <input type="submit" name="" value="valider">
               <c:if test="${!empty form}">
				<fieldset>
					<span class="${empty form.erreurs ? 'succes' : 'erreur'}">${ form.statusMessage }</span>
				</fieldset>
			</c:if>
                </form>
            </div>
        </div>
    </div>
</div>
	


	
</body>
</html>