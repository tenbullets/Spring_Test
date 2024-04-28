$(document).ready(function () {
    $("#save_post").submit(function (event) {
        event.preventDefault();
        save_img();
    });
});

function save_img() {
    let formData = new FormData();
    let files = ($('#file'))[0]['files'];
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        processData: false,
        contentType: false
    })
        .done(function (data) {
            let fname = data;
            save_desc(fname);
        })
        .fail(function () {
            $('#image').append('<h1>file not found</h1>');
            alert('error')
        });
}

function save_desc(name) {
    $("#btn-save").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/savePost",
        data: JSON.stringify({text: $("#post_text").val(), img:name}),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            renderPosts(data);
            console.log("SUCCESS");
            $("#btn-save").prop("disabled", false);
        },

        error: function (e) {
            let json = "<h4>Ajax Response</h4><pre>" + e.responseText + "</pre>";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
            $("#btn-save").prop("disabled", false);

        }
    });
}

function renderPosts(postsList) {
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