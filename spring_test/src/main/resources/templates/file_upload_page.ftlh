<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Upload</title>
</head>

<body>
    <div>
        <input type="file" id="file" name="file" placeholder="Имя файла"/>
        <input type="hidden" id="file_hidden">
        <button onclick="sendFile()">Загрузить файл</button>
        <div class="filename"></div>
    </div>
    <div id="image"></div>


<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/files.js"></script>
</body>

</html>