<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#--    <link rel="stylesheet" href="/css/style_3.css">-->
    <link rel="stylesheet" href="/css/style_3.css">

    <style>
        textarea {
            resize: none;

            display: block;
            height: 320px;
            width: 94%;
            background-color: #b4b3b33d;
            padding: 0 5px;

            font-size: 15px;
            font-family: 'Manrope', sans-serif;
            font-weight: 400;
            color: black;

            margin-left: 0px;
            margin-top: 8px;
            margin-bottom: 35px;

            border: none;
        }

        textarea.shortDesc {
            height: 150px;
            margin-bottom: 10px;
        }
    </style>

    <title>Authorization</title>
</head>

<body>

<div class="header">
    <div class="container_1">
        <div class="header__inner">
            <div class="header__text">
                <h1>Log in</h1>
            </div>
        </div>
    </div>
</div>

<div class="basic">
    <div class="container_2">
        <div class="basic__inner">

            <div class="block__3">
                <form action="/addPost" method="post">
                    <h4 class="block__text">Authorization</h4>

                    <label>Краткое описание</label>
                    <textarea maxlength="2000" name="text" class="shortDesc"></textarea>

                    <button>SEND POST</button>
                </form>
            </div>

        </div>
    </div>

    <footer>
        <div class="container">
            <div class="footer__inner">
                <div class="footer__text">

                </div>
            </div>
        </div>
    </footer>

</div>

</body>
</html>