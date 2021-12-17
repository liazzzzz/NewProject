<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="posts.css">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Post</title>
</head>
<header class="header shadow">
    <div class="container">
        <div class="header__inner">
            <div class="header__logo">
                <a href="/">Article.by</a>
            </div>
            <nav class="nav">
                <nav class="nav__link">
                    <#--                    <a class="nav__link" href="/">Home</a>-->
                    <a class="nav__link" href="/newPost">New Post</a>
                    <a class="nav__link" href="/profile">Profile</a>
                    <a class="nav__link" href="/users">Users</a>
                    <#--                    <a class="nav__link" href="/">Home</a>-->
                </nav>
            </nav>
        </div>
    </div>
</header>
<body>
<div class="container">
<h1 class="articles__info">${"Статья #" + post.id}</h1>
    <div class="articles_box">
        <h2 class="article_title">${post.title}</h2>
        <h3 class="article_text">${post.text}</h3>
        <h4>${post.user.firstname + " " + post.user.lastname + " опубликовал(а) в " + post.createdAt} </h4>
    </div>
<div>

    <a class="link" href="/editPost/${post.id}">Edit</a>
    <a class="link" href="/deletePost/${post.id}">Delete</a>
</div>
</div>
<div>
    <h2>Комментарии</h2>
    <#if comments?has_content>
    <#list comments as comment>
        <h4>${comment.user.firstname + " " + comment.user.lastname + " • " + comment.createdAt} </h4>
        <h3>${comment.text}</h3>
    </#list>
    </#if>
</div>
<div>
    <form name="comment" action= "/posts/${post.id}/comment" method="post">
        <input name="text" placeholder="Оставте комменатрий">
        <input type="submit" value="Отправить">
    </form>
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