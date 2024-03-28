<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style_4.css">

    <title>Feed</title>
</head>

<body>

<div class="header">
    <div class="container_1">
        <div class="header__inner">
            <div class="header__text">
                <h1>Feed</h1>
            </div>
        </div>
    </div>
</div>

<div class="basic">
    <div class="container_2">
        <div class="basic__inner">
            <div class="block__4">

                <form action="/feed" method="get">
                    <#list postsList as post>
                        <div class="post">
                            <p class="text" style="font-size: 24px">${post.author}</p>
                            <p class="text" style="color: darkturquoise">${post.text}</p>
                            <p class="text" style="margin-bottom: 20px; color: #00d188">${post.likes} likes</p>
                        </div>
                    </#list>

                </form>

            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div class="footer__inner">
                <div class="footer__text">
                    <#--                    <h3>tg: zhertvapropagandynolana</h3>-->
                </div>
            </div>
        </div>
    </footer>

</div>

</body>
</html>