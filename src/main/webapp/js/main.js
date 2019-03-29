$(document).ready(function () {

    $("#buy-form").submit(function (event) {
        event.preventDefault();
        addToCart();
    });

    function addToCart() {
        var input = {}
        //input["count"] = $("#input-qty").val();
        //TODO Obtener del input de cantidad
        input["count"] = 1;
        //TODO Obtener de un input hidden
        input["productId"] = 1;
        $("#add-to-cart").prop("disabled", true);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/ajax/add-cart",
            data: JSON.stringify(input),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                //$('#feedback').html(json);
                //TODO mostrar el mensaje en algo similar a toaster
                alert(data["message"]);
                console.log(data);
                $("#add-to-cart").prop("disabled", false);
            },
            error: function (e) {
                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                //$('#feedback').html(json);
                alert(e.responseText);
                console.log(json);
                console.log("ERROR : ", e);
                $("#add-to-cart").prop("disabled", false);
            }
        });
    }
});