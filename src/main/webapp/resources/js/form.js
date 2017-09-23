function createClient() {
    if (validate()) {
        $('#nameOfClient').css('background-color', '');
    } else {
        alert("Поле Имя обязательно для заполнения!");
        return false;   // cancel submit
    }
}

function validate() {
    var result = true;
    if ($('#nameOfClient').val() == '') {
        $('#nameOfClient').css('background-color', 'pink');
        result = false;
    }
    return result;
}