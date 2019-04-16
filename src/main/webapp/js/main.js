$(document).ready(function () {
    $(".cart-product-remove").click(function (event) {

        var elementId = $(this).attr('id');
        // extrae del  id="remove-from-cart-${cart.product.id}" del boton de la papelera el id del producto
        var cartId = parseInt(elementId.substring(17));
        event.preventDefault();

        removeFromCart(cartId);
        $(document).ajaxStop(function () {
            window.location.reload();
        });


    });
    $(".product-rating").click(function (event) {

        var elementId = $(this).attr('id');
        // extrae del  id="product-rating-${product.id}"}" del boton de la papelera el id del producto
        var productId = parseInt(elementId.substring(15));
        event.preventDefault();
        addRating(productId);
        /*  $(document).ajaxStop(function () {
              window.location.reload();
          });*/


    });


    $("#buy-form").submit(function (event) {
        event.preventDefault();
        addToCart();
    });

    $(".select-qty").change(function (event) {


        var elementId = $(this).attr('id');
        // extrae del  id="select-qty-${cart.id}"del selector de cantidad el id del producto
        var productId = parseInt(elementId.substring(11));
        event.preventDefault();

        updateCart(productId);
        $(document).ajaxStop(function () {
            window.location.reload();
        });


    });
    function addRating(productId) {

        var input = {};
        input["count"] = parseInt($("#exampleFormControlSelect1").val());
        input["productId"] = parseInt(productId);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/ajax/rating-product",
            data: JSON.stringify(input),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $.alert(data["message"], {
                    type: 'success',
                });

            },
            error: function (e) {
                var json = JSON.parse(e.responseText);
                $.alert(json["message"], {
                    type: 'danger',
                });

            }
        });

    }

    function addToCart() {
        var input = {};
        input["count"] = parseInt($("#input-qty").val());
        //TODO Obtener de un input hidden
        input["productId"] = parseInt($("#productId").val());
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

    function updateCart(cartId) {
        var input = {};
        input["count"] = parseInt($("#select-qty-" + cartId).val());
        input["cartId"] = parseInt(cartId);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/ajax/update-cart",
            data: JSON.stringify(input),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $.alert(data["message"], {
                    type: 'success',
                });

            },
            error: function (e) {
                var json = JSON.parse(e.responseText);
                $.alert(json["message"], {
                    type: 'danger',
                });

            }
        });

    }


    function removeFromCart(cartId) {

        var input = {};
        input["cartId"] =cartId;

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/ajax/remove-cart",
            data: JSON.stringify(input),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                $.alert(data["message"], {
                    type: 'success',
                });

            },
            error: function (e) {
                var json = JSON.parse(e.responseText);
                $.alert(json["message"], {
                    type: 'danger',
                });

            }
        });


    }

});