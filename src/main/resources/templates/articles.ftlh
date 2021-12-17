<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="posts.css">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Raleway:400,600,700&display=swap&subset=cyrillic-ext" rel="stylesheet">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Posts</title>
</head>
<header class="header shadow">
    <div class="container">
        <div class="header__inner">
            <div class="header__logo">
                <a href="/"><img src="Squad_logo.png"></a>
            </div>
            <nav class="nav">
                <nav class="nav__link">
                    <#--                    <a class="nav__link" href="/">Home</a>-->
                    <a class="nav__link" href="/newPost">Написать статью</a>
                    <a class="nav__link" href="/profile">Профиль</a>
<#--                    <a class="nav__link" href="/users">Users</a>-->
                                        <a class="nav__link" href="/">Главная</a>
                </nav>
            </nav>
        </div>
    </div>
</header>
<body>
<div class="articles">
    <div class="container">
        <h1 class="articles__info">Статьи</h1>
        <div class="articles_box">
            <#list posts as post>
                <div class="article">
                    <a href="/posts/${post.id}"><h2 class="article_title calculator_new ">${post.title}</h2></a>
                    <#--        <h2>${post.title}</h2>-->
                    <h3 class="article__text">${post.text}</h3>
                    <#--                        <h4>${post.user.firstname + " " + post.user.lastname + " опубликовал в " + post.createdAt} </h4>-->
                </div>
                <a href="/posts/${post.id}" class="btn btn--mod--calc"  href="/login">Читать</a>
            </#list>
        </div>
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
                            <div>Kazan, Vakhitovsky region,</div>
                            <div>St. Kremlin, 35</div>
                        </address>
                    </div>
                </div>
            </div></section>
    </div>
</footer>
</html>