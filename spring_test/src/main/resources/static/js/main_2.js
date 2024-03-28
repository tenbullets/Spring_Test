// $(".like").click(function () {
//     var $form = $(this).parents('form');
//     var id = $form.attr('id');
//     console.log(id);
// });

$(document).ready(function ()  {
    $(".like").click(function () {
        var $form = $(this).parents('form');
        var id = $form.attr('id');
        // console.log(id);

        let x = id.replace(/^\D+/g, '');
        console.log(x);

        $("#" + id).submit(function (event) {
            event.preventDefault();
            send_like(x);
        });
    });
});

function send_like(num) {
    var id = {}
    id["postId"] = num;

    console.log("inside " + num);

    $("#btn_like").prop("disabled", false);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/sendLike",
        data: JSON.stringify(id),
        dataType: 'json',
        cache: false,
        timeout: 600000,

        success: function (data) {

            // var likes = "<h4>Likes - </h4><h4>" + data + "</h4>";
            // $('#feedback').html(likes);
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            // var likes = "<h4>Result</h4><h4>" + e.responseText + "</h4>";
            // $('#feedback').html(likes);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", true);

        }
    });

}