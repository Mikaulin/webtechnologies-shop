$(document).ready(function () {

    $("#buy-form").submit(function (event) {
        event.preventDefault();
        addToCart();
    });

    function addToCart() {
        var input = {};
        input["count"] = parseInt($("#input-qty").val());
        //TODO Obtener de un input hidden
        input["productId"] = parseInt($("#productId").val());;
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
                $.alert(data["message"], {
                    type: 'success',
                });
                $("#total-products").text(data["totalProducts"]);
                $("#add-to-cart").prop("disabled", false);
            },
            error: function (e) {
                var json = JSON.parse(e.responseText);
                $.alert(json["message"], {
                    type: 'danger',
                });
                $("#add-to-cart").prop("disabled", false);
            }
        });
    }
});