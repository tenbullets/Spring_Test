$(document).ready(function () {
    $("#add_admin_form").submit(function (event) {
        event.preventDefault();
        add_admin_func();
    });
});



function renderTable(newTable) {
    let innerHtml = '<tr>\n' +
        '               <th>ID</th>' +
        '               <th>EMAIL</th>' +
        '               <th>USERNAME</th>' +
        '               <th>BAN STATUS</th>' +
        '               <th>ROLE</th>' +
        '            </tr>';

    for (let i = 0; i < newTable.length; i++) {
        innerHtml += '<tr>';
        innerHtml += '  <td>' + newTable[i]['id'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['email'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['username'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['ban_status'] + '</td>';
        innerHtml += '  <td>' + newTable[i]['role'] + '</td>';
        innerHtml += '</tr>';
    }

    $('#refresh').html(innerHtml);
}

function add_admin_func() {
    let username = {}
    username["username"] = $("#username").val();

    $("#add_admin_btn").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/addAdmin",
        data: JSON.stringify(username),
        dataType: 'json',
        cache: false,
        timeout: 600000,

        success: function (data) {
            renderTable(data);
            console.log("SUCCESS");
            $("#add_admin_btn").prop("disabled", false);

        },
        error: function (e) {
            let json = "<h4>You're a moron</h4>";
            $('#refresh').html(json);
            console.log("ERROR : ", e);
            $("#add_admin_btn").prop("disabled", false);
        }

    });

}