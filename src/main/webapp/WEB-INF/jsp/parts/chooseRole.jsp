<%--
  Created by IntelliJ IDEA.
  User: immrdg
  Date: 04/02/24
  Time: 3:38 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body text-center">
                    <h3 class="card-title">Choose Your Role For ${page}</h3>
                    <p class="card-text">Are you a tenant or an owner?</p>
                    <a href="#" class="btn btn-primary btn-lg btn-block" onclick="redirectTo('pg/${page.toLowerCase()}')">Tenant</a>
                    <a href="#" class="btn btn-success btn-lg btn-block" onclick="redirectTo('owner/${page.toLowerCase()}')">Owner</a>
                </div>
            </div>
        </div>
    </div>
</div>