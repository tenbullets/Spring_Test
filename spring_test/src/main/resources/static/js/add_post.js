$(document).ready(function () {
    $("#save_post").submit(function (event) {
        event.preventDefault();

        let filename = document.getElementById('file').files[0].name;

        save_img();
        save_desc(filename);
    });
});

function save_img() {
    let formData = new FormData();
    let files = ($('#file'))[0]['files'];
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.post({
        type: "POST",
        url: "/files",
        data: formData,
        processData: false,
        contentType: false
    })
}

function save_desc(name) {
    let post_value = {}
    let file_name = {}

    // post_value["text"] = $("#post_text").val();
    // file_name["img"] = name;
    // console.log(JSON.stringify({text: $("#post_text").val(), img:name}));

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
    console.log("size= " + postsList.length)

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
