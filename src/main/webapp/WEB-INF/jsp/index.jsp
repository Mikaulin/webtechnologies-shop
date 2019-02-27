
<%@ page language="java" %>
<%@ page import = "uned.webtechnologies.shop.inmemorydb.model.User"%>
<%@ page import = "uned.webtechnologies.shop.inmemorydb.fixtures.UserLoader"%>


<%@ include file = "_header.jsp"%>

<div class="container">

    <h1>Bienvenidos al Portal de ElectroHOME</h1>

    <p>Esto es una prueba</p>


    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="/img/promo01.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="/img/promo02.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="/img/promo03.jpg" alt="Third slide">
            </div>
        </div>
    </div>

</div>

<%@ include file = "_js.jsp"%>
<%@ include file = "_footer.jsp"%>
