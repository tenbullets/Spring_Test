<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/style_3.css">
    <title>Registration</title>
</head>

<body>

<div class="header">
    <div class="container_1">
        <div class="header__inner">
            <div class="header__text">
                <h1>${username}</h1>
            </div>
        </div>
    </div>
</div>

<div class="basic">
    <div class="container_2">
        <div class="basic__inner">

            <div class="block__3">
                <form action="/confirm" method="post">
                    <h4 class="block__text">Сonfirm the phone number</h4>
                    <input type="hidden" name="username" value="${username}">

                    <label for="key">Activation Code</label>
                    <input name="key" placeholder="Enter Your Activation Code" id="key">

                    <button>send</button>
                </form>
            </div>

        </div>
    </div>

    <footer>
        <div class="container">
            <div class="footer__inner">
                <div class="footer__text">
                    <!-- <h3>tg: zhertvapropagandynolana</h3> -->
                </div>
            </div>
        </div>
    </footer>

</div>

</body>
</html>