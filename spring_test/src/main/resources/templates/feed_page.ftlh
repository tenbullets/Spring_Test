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

                    <#list postsList as post>
                        <form action="/feed" method="get" id="likes-form${post.id}" onsubmit="return false;">
<#--                        <form action="/feed" method="get" id="likes-form${post.id}">-->
                            <div class="post">
                                <p class="text" style="font-size: 24px">${post.author}</p>
                                <p class="text" style="color: darkturquoise">${post.text}</p>
                                <p class="text" style="margin-bottom: 20px; color: #00d188" id="lto">Likes: ${post.likes}</p>

                                <input type="hidden" id="postId" value="${post.id}">
<#--                                <input type="text" id="postId"/>-->
                                <div id="feedback"></div>
                                <button type="submit" id="btn_like" class="like" >pin</button>
                            </div>
                        </form>
                    </#list>

            </div>
        </div>
    </div>


</div>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/main_2.js"></script>

</body>
</html>