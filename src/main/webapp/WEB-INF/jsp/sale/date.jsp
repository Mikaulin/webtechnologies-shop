<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../shared/_header.jsp" %>


<div class="container">

    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <div class="input-group-prepend">
                <h4 class="mb-3">Informe de ventas </h4>
            </div>
        </div>
    </div>

    <div class="border-top my-3"></div>

    <div class="row">
        <div class="col-md-6 order-md-1">

            <div class="card mb-8 shadow-sm">

                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Elige un fecha: </h4>
                </div>

                <div class="card-body">


                    <form:form method="post" modelAttribute="date" action="informe">

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <input type="date" class="form-control" name="date" id="date" value="" required=""/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <button class="btn btn-lg btn-success btn-sm" type="submit">Generar Informe</button>
                            </div>
                        </div>
                    </form:form>


                </div>
            </div>
        </div>

        <div class="col-md-6 order-md-2 mb-4"></div>

    </div>


    <p>&nbsp;</p>


</div>

<p>&nbsp;</p>


<%@ include file="../shared/_js.jsp" %>
<%@ include file="../shared/_footer.jsp" %>
