$(document).ready(function () {
    $("#save_post").submit(function (event) {
        event.preventDefault();
        save_post_func();
    });
});



function renderPosts(postsList) {
    console.log("size= " + postsList.length)

    // <form action="/theWall" method="get">
    //     <div id="postwall">
    //         <p style="font-size: 24px">${post.author}</p>
    //         <p style="color: darkturquoise">${post.text}</p>
    //         <div>
    //             <p>${post.likes}</p>
    //         </div>
    //     </div>
    // </form>

    let innerHtml = "";

    for (let i = 0; i < postsList.length; i++) {
        innerHtml += '<form action="/theWall" method="get">';
        innerHtml += '  <div class="post" id="postwall">';
        innerHtml += '      <div id="image"><img class="block_img" src="http://localhost:8080/files/' + postsList[i]['img'] +' "></div>';
        innerHtml += '      <p class="text" style="font-size: 24px">' + postsList[i]['author'] + '</p>';
        innerHtml += '      <p class="text" style="font-size: 24px">' + postsList[i]['text'] + '</p>';
        innerHtml += '      <div class="like_block">';
        innerHtml += '          <p class="like_count">' + postsList[i]['likes'] + '</p>';
        innerHtml += '      </div>';
        innerHtml += '  </div>';
        innerHtml += '</form>';
    }

    $('#postwall').html(innerHtml);
}

function save_post_func() {

    let post_value = {}
    post_value["text"] = $("#post_text").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/savePost",
        data: JSON.stringify(post_value),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            renderPosts(data);
            console.log("SUCCESS");
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            let json = "<h4>Ajax Response</h4><pre>" + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}