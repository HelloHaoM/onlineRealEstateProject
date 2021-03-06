<%@page import="onlinerealestateproject.datasource.imp.ApartmentMapperImpl"%>
<%@page import="onlinerealestateproject.datasource.ApartmentMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" import="java.util.*, java.lang.*, onlinerealestateproject.util.*, onlinerealestateproject.domain.*, onlinerealestateproject.datasource.*, onlinerealestateproject.datasource.imp.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apartment Detail</title>
<link rel='stylesheet' href='ApartmentFormPage.css'/>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<%
	String id = request.getParameter("id");
	//HttpSession session = request.getSession();
	//String id = session.getAttribute("userId").toString();
%>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Add a New Apartment</h1>
     </div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
        <form class="apart-detail" action="../NewApartmentFormController", method="post">
            <div class="table-responsive">
                <table class="table table-striped">

                    <tbody>
                    <tr>
                    	<td>Apartment Name:</td>
                    	<td>
                    		<input class="form-control" name="apartmentName" required="required"></input>
						</td>
                    </tr>
                    
                    <tr>
                    	<td>Apartment Location:</td>
                    	<td>
                    		<input class="form-control" name="location" required="required"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Apartment Acreage:</td>
                    	<td>
                    		<input class="form-control" type="number" name="acreage" required="required"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Apartment Price:</td>
                    	<td>
                    		<input class="form-control" type="number" name="price" required="required"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Availability:</td>
                    	<td>
                    		<input class="form-control" name="availability" required="required"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Start Time:</td>
                    	<td>
                    		<input class="form-control" name="startRentTime" required="required"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>End Time:</td>
                    	<td>
                    		<input class="form-control" name="endRentTime" required="required"></input>
                    	</td>
                    </tr>
                      	
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                	<input type="hidden" name="id" value="<%= id %>"></input>
                    <!-- <input type="submit" name="back" value="Back" class="btn btn-lg btn-block btn-light" ></input> -->
                    <a class="btn btn-lg btn-block btn-light" href="../RealEstate/RealEstatePage.jsp?id=<%= id %>">Back</a>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
<%--                 		<input type="hidden" name="id" value="<%=id%>"></input> --%>
                    	<input type="submit" name="create" value="Create" class="btn btn-lg btn-block btn-success text-uppercase" ></input>
                </div>
            </div>
        </div>
        </form> 
    </div>
</div>

</body>
</html>