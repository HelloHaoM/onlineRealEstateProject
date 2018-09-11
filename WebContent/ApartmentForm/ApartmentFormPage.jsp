<%@page import="onlinerealestateproject.datasource.imp.ApartmentMapperImpl"%>
<%@page import="onlinerealestateproject.datasource.ApartmentMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*, onlinerealestateproject.util.*, onlinerealestateproject.domain.*, onlinerealestateproject.datasource.*, onlinerealestateproject.datasource.imp.*"%>
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
	int id = Integer.parseInt(request.getParameter("id"));
	int apid = Integer.parseInt(request.getParameter("apid"));
	UnitofWorkApartment.newCurrent();
	ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
	
	Apartment apartment = apartmentMapper.find(apid);
	
	String info = (String) request.getAttribute("info");
	if(info != null){
%>
	<script type="text/javascript">alert("<%= info %>")</script>
<% 
	}
%>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Detail Apartment Information</h1>
     </div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
        <form class="apart-detail" action="../ApartmentFormController", method="post">
            <div class="table-responsive">
                <table class="table table-striped">

                    <tbody>
                    <tr>
                    	<td>Apartment Name:</td>
                    	<td>
                    		<input class="form-control" name="apartmentName" value="<%= apartment.getApartmentName() %>" ></input>
						</td>
                    </tr>
                    
                    <tr>
                    	<td>Apartment Location:</td>
                    	<td>
                    		<input class="form-control" name="location" value="<%= apartment.getLocation() %>" ></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Apartment Acreage:</td>
                    	<td>
                    		<input class="form-control" name="acreage" value="<%= apartment.getAcreage() %>"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Apartment Price:</td>
                    	<td>
                    		<input class="form-control" name="price" value="<%= apartment.getPrice() %>"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Availability:</td>
                    	<td>
                    		<input class="form-control" name="availability" value="<%= apartment.getAvailability() %>"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>Start Time:</td>
                    	<td>
                    		<input class="form-control" name="startRentTime" value="<%= apartment.getStartRentTime() %>"></input>
                    	</td>
                    </tr>
                    
                    <tr>
                    	<td>End Time:</td>
                    	<td>
                    		<input class="form-control" name="endRentTime" value="<%= apartment.getEndRentTime() %>"></input>
                    	</td>
                    </tr>
                      	
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                	<input type="hidden" name="id" value="<%=id%>"></input>
                	<input type="hidden" name="apid" value="<%=apid%>"></input>
                    <input type="submit" name="back" value="Back" class="btn btn-lg btn-block btn-light" ></input>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
<%--                 		<input type="hidden" name="id" value="<%=id%>"></input> --%>
                    	<input type="submit" name="confirm" value="Confirm" class="btn btn-lg btn-block btn-success text-uppercase" ></input>
                </div>
            </div>
        </div>
        </form> 
    </div>
</div>

</body>
</html>