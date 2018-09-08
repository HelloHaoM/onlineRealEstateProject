<%@page import="onlinerealestateproject.domain.Apartment"%>
<%@page import="onlinerealestateproject.domain.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*, onlinerealestateproject.*, onlinerealestateproject.datasource.*, onlinerealestateproject.datasource.imp.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='InspectionCartPage.css'/>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Inspection Cart</title>
</head>
<body>
<%
	int uid = Integer.parseInt(request.getParameter("id"));
	System.out.println(uid);
	
	String info = (String) request.getAttribute("info");
	if(info != null){
%>
	<script type="text/javascript">alert("<%= info %>")</script>
<% 
	}
%>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">RealEstate Inspection Cart</h1>
     </div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Apartment</th>
                            <th scope="col">Available</th>
                            <th scope="col" class="text-center">Inspection Time</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    	<%
                    		OrderMapper orderMapper = new OrderMapperImpl();
                    		ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
                    		ArrayList<Order> orderList = orderMapper.findAllOrders(uid);
                    		
                    		for(Order order : orderList){
                    			Apartment apartment = apartmentMapper.find(order.getApid());
                    	%>
                    		<tr>
                    		<td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                    		<td><%= apartment.getApartmentName() %></td>
                            <td><%= apartment.getAvailability() %></td>
                            <form action="../InspectionCartController" method="post">
                            	<td><input class="form-control" type="text" name="inspection-time" value="<%= order.getInspEndTime() %>" /></td>
                            	<td class="text-right">
                            	<input type="hidden" name="id" value="<%= order.getUid() %>"></input>
                            	<input type="hidden" name="order-id" value="<%= order.getOid() %>"></input>
                            	<input class="btn btn-sm btn-success" type="submit" name="update" value="Update"> </input>
                          		<input class="btn btn-sm btn-danger" type="submit" name="delete" value="Delete"> </input> 
                          		</td>
                          	</form>
                            </tr>
                    	<% 
                    		}
                    		
                    	%>
  <!--                       <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <td>Product Name Dada</td>
                            <td>In stock</td>
                            <td><input class="form-control" type="text" value="1" /></td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr> -->
                        
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                	<form class="cart-back" action="../InspectionCartController" method="post">
                		<input type="hidden" name="id" value="<%= uid %>"></input>
                    	<input type="submit" name="back" value="Back" class="btn btn-lg btn-block btn-light" ></input>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                	<form class="cart-confirm" action="../InspectionCartController" method="post">
                		<input type="hidden" name="id" value="<%= uid %>"></input>
                    	<input type="submit" name="confirm" value="Confirm" class="btn btn-lg btn-block btn-success text-uppercase" ></input>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>