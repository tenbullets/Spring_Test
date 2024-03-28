<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style_3.css">

    <title>Account</title>
</head>

<body>

<div class="header">
    <div class="container_1">
        <div class="header__inner">
            <div class="header__text">
                <h1>Account</h1>
            </div>
        </div>
    </div>
</div>

<div class="basic">
    <div class="container_2">
        <div class="basic__inner">

            <div class="block__4">
                <p class="text" style="font-size: 24px; margin-bottom: 30px">INFO</p>
                <h3 class="text">Username: ${userName}</h3>
                <h3 class="text">Email: ${email}</h3>
            </div>

            <div class="block__4">
                <p class="text" style="font-size: 24px; margin-bottom: 30px"">ACTIONS</p>
                <p><a class="text" href="/welcome" data-scroll="#">Return to the welcome page</a></p>
                <p><a class="text" href="/feed" data-scroll="#">Feed</a></p>
                <p><a class="text" href="/addPost" data-scroll="#">+ Post</a></p>
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