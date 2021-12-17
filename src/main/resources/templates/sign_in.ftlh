<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>
</head>
<body>
<h1>ВХОД</h1>
<div>
    <form action="/signIn" method="post">
        <input name="email" placeholder="Email">
        <input type="password" name="password" placeholder="Пароль">
<#--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        <input type="submit" value="ВХОД">

        <label for="remember-me">Remember me?</label>
        <input type="checkbox" id="remember-me" name="remember-me">


    </form>
</div>
<div>
    <a href="/signUp" >Нет аккаунта? Зарегестрируйся</a>
</div>
</body>
</html>
