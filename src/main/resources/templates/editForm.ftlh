<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Post</title>
</head>
<body>
<h1>Редактировать статью</h1>
<div>
    <form action="/editPost/${post.id}" method="post">
        <input name="title" placeholder="Title" value=${post.title}>
        <input name="text" placeholder="Text" value=${post.text}>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>