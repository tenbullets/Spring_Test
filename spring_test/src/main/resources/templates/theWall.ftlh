<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,200;9..40,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style_5.css">

    <title>The Wall</title>

    <style>
        textarea {
            resize: none;
            display: block;
            width: 81%;
            background-color: #b4b3b33d;
            padding: 0 5px;
            font-size: 21px;
            font-family: 'Manrope', sans-serif;
            font-weight: 400;
            color: white;
            margin: 8px auto 20px;
            border: none;
            border-radius: 7px;
        }

        textarea.shortDesc {
            height: 277px;
            margin-bottom: 10px;
            margin-top: 67px;
        }
    </style>
</head>

<body>

<div class="header">
    <div class="container_1">
        <div class="header__inner">
            <div class="header__text">
                <h1>What's new</h1>
            </div>
        </div>
    </div>
</div>

<div class="basic">
    <div class="container_2">
        <div class="basic__inner">

            <div class="block__3">
                <form id="save_post">

                    <textarea maxlength="2000" name="text" class="shortDesc" id="post_text"></textarea>

                    <button id="save_btn">SEND POST</button>
                </form>

            </div>

            <div class="block__4" id="postwall">
                <#list posts as post>
                    <form action="/theWall" method="get">
                        <div class="post">
                            <p class="text" style="font-size: 24px">${post.author}</p>
                            <p class="text" style="color: darkturquoise">${post.text}</p>
                            <div class="like_block">
                                <p class="like_count">${post.likes}</p>
                            </div>
                        </div>

                    </form>
                </#list>
            </div>

        </div>
    </div>


</div>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/main_3.js"></script>

</body>
</html>