<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="new_post.css">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Post</title>
</head>

<body>
<h1>Написать статью</h1>
<div>
        <form action="/newPost" method="post">
        <input name="title" placeholder="Title"><br>
        <textarea name="text" placeholder="Text"></textarea>
         <input type="submit" value="Save">
        </form>
</div>
</body>
</html>