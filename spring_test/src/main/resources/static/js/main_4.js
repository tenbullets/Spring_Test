$(document).ready(function () {
    $("#ban_form").submit(function (event) {
        event.preventDefault();
        ban_func();
    });
});



function renderTable(newTable) {
    console.log("size= " + newTable.length)

    let innerHtml = '<tr>\n' +
        '               <th>ID</th>' +
        '               <th>EMAIL</th>' +
        '               <th>USERNAME</th>' +
        '               <th>BAN STATUS</th>' +
        '            </tr>';

    for (let i = 0; i < newTable.length; i++) {
        innerHtml += '<tr>';
        innerHtml += '  <td>' + newTable[i]['id'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['email'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['username'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['ban_status'] + '</td>';
        innerHtml += '</tr>';
    }

    $('#refresh').html(innerHtml);
}

function ban_func() {

    let username = {}
    username["username"] = $("#username").val();
    console.log("u = " + username)

    $("#ban_btn").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/ban",
        data: JSON.stringify(username),
        dataType: 'json',
        cache: false,
        timeout: 600000,

        success: function (data) {
            renderTable(data);
            console.log("SUCCESS");
            $("#ban_btn").prop("disabled", false);

        },
        error: function (e) {
            let json = "<h4>User not found</h4>";
            $('#refresh').html(json);
            console.log("ERROR : ", e);
            $("#ban_btn").prop("disabled", false);
        }
    });

}