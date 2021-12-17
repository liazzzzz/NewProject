<#import "spring.ftl" as spring />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Регистрация</h1>
<div>
    <form action="/signUp" method="post">
    <input name="firstname" value="${(form.firstname)!}" />
    <#if form??>
        <@spring.bind "form.firstname" />
        <@spring.showErrors "<br>"/>
    </#if>
    <input name="lastname" value="${(form.lastname)!}" />
    <#if form??>
        <@spring.bind "form.lastname" />
        <@spring.showErrors "<br>"/>
    </#if>
        <input name="email" value="${(form.email)!}" />
        <#if form??>
            <@spring.bind "form.email" />
            <@spring.showErrors "<br>"/>
        </#if>
        <input type="password" name="password" value="${(form.password)!}" />
        <#if form??>
            <@spring.bind "form.password" />
            <@spring.showErrors "<br>"/>
        </#if>
        <input type="submit" value="Регистрация">
    </form>




<#--    <form action="/signUp" method="post">-->
<#--        <input name="firstname" placeholder="Имя">-->
<#--        <input name="lastname" placeholder="Фамилия">-->
<#--        <input name="email" placeholder="Email">-->
<#--        <input type="password" name="password" placeholder="Пароль">-->
<#--&lt;#&ndash;        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">&ndash;&gt;-->
<#--        <input type="submit" value="Регистрация">-->
<#--    </form>-->
</div>
<div>
    <a href="/signIn">Войти</a>
</div>
</body>
</html>
