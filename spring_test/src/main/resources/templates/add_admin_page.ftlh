<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form id="add_admin_form">
        <div>
            <label class="col-sm-2 control-label">Username</label>
            <div>
                <input type="text" id="username"/>
            </div>
        </div>

        <div>
            <div>
                <button id="add_admin_btn">Add Admin</button>
            </div>
        </div>

    </form>
</div>
<div>
    <table id="refresh">
        <tr>
            <th>ID</th>
            <th>EMAIL</th>
            <th>USERNAME</th>
            <th>BAN STATUS</th>
            <th>ROLE</th>
        </tr>
        <#list usersList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.ban_status}</td>
                <td>${user.role}</td>
            </tr>
        </#list>
    </table>
</div>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/main_5.js"></script>

</body>
</html>
