$(document).ready(function ()  {
    $(".like").click(function (event) {
        let $form = $(this).parents('form');
        let id = $form.attr('id');
        let x = id.replace(/^\D+/g, '');
        console.log("x = " + x);

        event.preventDefault();
        send_like(x);
    });
});

function send_like(num) {
    let id = {}
    id["postId"] = num;

    let b = "#btn_like" + num;
    $(b).prop("disabled", false);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/sendLike",
        data: JSON.stringify(id),
        dataType: 'json',
        cache: false,
        timeout: 600000,

        success: function (data) {
            let elemId = "likeCount" + num;
            let l = document.getElementById(elemId);
            l.innerText = data;


            let ls = "likeStatus" + num;
            console.log("ls = " + ls);

            const likeStatus = document.getElementById(ls);

            if (likeStatus.value === "like") {
                likeStatus.value = "like pressed";
                $(b).toggleClass("pressed");
            } else {
                likeStatus.value = "like";
                $(b).toggleClass("pressed");
            }

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", true);
        }
    });
}