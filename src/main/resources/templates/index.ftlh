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
                    <a class="nav__link" href="/articles">Статьи</a>
                    <a class="nav__link" href="/newArticle">Написать статью</a>
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
            <a class="btn btn--mod" href="/articles">Начать</a>
        </div>
    </div>
</div>
<div class="calculator">
    <div class="calculator__text container"><section id="calculator">
            <h2 class="calculator__title">Новая статья:</h2>
            <#if article?has_content>
                <a href="/articles/${article.id}"><h1 class="calculator_new">${article.title}</h1>
                    <h2 class="calculator__subtitle">${article.text}</h2>
                    <h3 class="calculator__subtitle">${"Опубликовано " + article.createdAt + " пользователем " +  article.user.firstname + " " + article.user.lastname}</h3></a>
            <#else>
                <p class="info__article" >На данный момент статья недоступна</p>
            </#if>
            <a href="/articles/${article.id}" class="btn btn--mod--calc"  href="/login">Читать</a>
        </section>
    </div>
</div>
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