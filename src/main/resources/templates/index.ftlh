<!doctype html>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="тест, профессия, ЕГЭ, вузы">
    <meta name="description" content="">
    <title>Сайт по подготовке к ЕГЭ</title>
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="book-bookmark-icon_34486.ico" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Raleway:400,600,700&display=swap&subset=cyrillic-ext" rel="stylesheet">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<header class="header shadow">
    <div class="container">
        <div class="header__inner">
            <div class="header__logo">
                <a href="/"><img src="Squad_logo.png"></a>
            </div>
            <nav class="nav">
                <nav class="nav__link">
                    <a class="nav__link" href="/posts">Статьи</a>
                    <a class="nav__link" href="/newPost">Написать статью</a>
<#--                    <a class="nav__link" href="/users">Пользователи</a>-->
                    <@security.authorize access="isAuthenticated()">
                       <a class="nav__link" href="/profile">Профиль</a>
                       <a class="nav__link" href="/logout">Выйти</a>
                    </@security.authorize>
                    <@security.authorize access="!isAuthenticated()">
                        <a class="nav__link authorization__link" href="/signIn">Вход</a>
                        <a class="nav__link authorization__link" href="/signUp">Регистрация</a>
                    </@security.authorize>
                </nav>
            </nav>
        </div>
    </div>
</header>
<body>
<div class="intro">
    <div class="container">
        <div class="intro_inner">
            <h1 class="intro__title">Подготовка к ОГЭ и ЕГЭ</h1>
            <h2 class="intro__subtitle">На нашем сайте ты найдешь материалы для обучения по любому предметам. Читай, комментируй и пиши свои статьи.</h2>
            <a class="btn btn--mod" href="/posts">Начать</a>
        </div>
    </div>
</div>
<div class="calculator">
    <div class="calculator__text container"><section id="calculator">
            <h2 class="calculator__title">Новая статья:</h2>
            <#if post?has_content>
                <a href="/posts/${post.id}"><h1 class="calculator_new">${post.title}</h1>
                    <h2 class="calculator__subtitle">${post.text}</h2>
                    <h3 class="calculator__subtitle">${"Опубликовано " + post.createdAt + " пользователем " +  post.user.firstname + " " + post.user.lastname}</h3></a>
            <#else>
                <p class="info__article" >На данный момент статья недоступна</p>
            </#if>
            <a href="/posts/${post.id}" class="btn btn--mod--calc"  href="/login">Читать</a>
        </section>
    </div>
</div>
<#--<div>-->
<#--    <div class="container">-->
<#--        <section id="article">-->
<#--            <div class="articles">-->
<#--                <div class="article__item">-->
<#--                    <p class="info__article">Новая статья:</p>-->
<#--                    <#if post?has_content>-->
<#--                        <a href="/posts/${post.id}"><h1 class="article__title">${post.title}</h1>-->
<#--                        <h2 class="article__text">${post.text}</h2>-->
<#--                        <h3 class="article__data">${"Опубликовано " + post.createdAt + " пользователем " +  post.user.firstname + " " + post.user.lastname}</h3></a>-->
<#--                    <#else>-->
<#--                        <p class="info__article" >На данный момент статья недоступна</p>-->
<#--                    </#if>-->
<#--                </div>-->
<#--            </div>-->
<#--        </section>-->
<#--    </div>-->
<#--</div>-->
</body>
<footer class="footer">
    <div class="container"><section id="contacts">
            <div class="footer__inner">
                <div class="footer__block">
                    <h4 class="footer__title">Контакты</h4>
                    <div class="footer__text">
                        <p>+1121011030</p>
                        <address class="footer__address">
                            <div>Набережные Челны</div>
                            <div>Проспект Мира, 13</div>
                        </address>
                    </div>
                </div>
            </div></section>
    </div>
</footer>
</html>