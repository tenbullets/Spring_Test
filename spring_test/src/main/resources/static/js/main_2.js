$(document).ready(function ()  {
    $(".like").click(function (event) {
        let $form = $(this).parents('form');
        let id = $form.attr('id');

        let x = id.replace(/^\D+/g, '');
        console.log(x);

        event.preventDefault();
        send_like(x);
    });
});

// document.querySelector('.like').addEventListener('click', function () {
//     let isLiked = this.getAttribute('data-liked');
//
//     if (isLiked === 'false') {
//         //give it a blue thumb to indicate it is liked
//         this.innerHTML = `<span class="blue-thumb">👍</span>`;
//         //set the state to be true for it being liked
//         this.setAttribute('data-liked', 'true');
//     }
//     else {
//         //Reset back to the original Like text
//         this.innerHTML = `👍 Like`;
//         //and set the state back to being false for it being liked
//         this.setAttribute('data-liked', 'false');
//     }
// });

function send_like(num) {
    let id = {}
    id["postId"] = num;

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
            let elemId = "likeCount" + num;
            let l = document.getElementById(elemId);
            l.innerText = data;
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);
        },
        error: function (e) {
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", true);
        }
    });
}

// $(document).ready(function ()  {
//     $(".like").click(function () {
//         let $form = $(this).parents('form');
//         let id = $form.attr('id');
//         // console.log(id);
//
//         let x = id.replace(/^\D+/g, '');
//
//
//         $("#" + id).submit(function (event) {
//             event.preventDefault();
//             send_like(x);
//         });
//     });
// });

// $(".like").click(function () {
//     var $form = $(this).parents('form');
//     var id = $form.attr('id');
//     console.log(id);
// });












