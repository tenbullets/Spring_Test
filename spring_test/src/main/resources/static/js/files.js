function sendFile() {
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
        .done(function (response) {
            let fileUrl = 'http://localhost:8080/files/' + response;
            $('#photo').append('<img src = "' + fileUrl + '"/>');
        })
        .fail(function () {
            alert('error')
        });
}