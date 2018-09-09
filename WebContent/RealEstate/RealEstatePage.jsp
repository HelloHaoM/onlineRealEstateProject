<%@page import="onlinerealestateproject.domain.Client"%>
<%@page import="onlinerealestateproject.domain.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*, onlinerealestateproject.datasource.*, onlinerealestateproject.datasource.imp.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='RealEstatePage.css'/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<title>Real Estate Inspection</title>
</head>
<body>

<%
	String userName = request.getParameter("userName");
	String id = request.getParameter("id");
	String navHref = "./LoginAndRegisterPage.jsp";
	if(userName == null){
		ClientMapper clientMapper = new ClientMapperImpl();
		userName = clientMapper.find(Integer.parseInt(id)).getUserName();
	}
	if(userName != null)
		navHref = "./InspectionCart/InspectionCartPage.jsp";
		
%>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#page-top">Online RealEstate</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                    <% 
                    	if(userName != null){
                    %>
                    		<li class="page-scroll">
                    		<a href="../InspectionCart/InspectionCartPage.jsp?id=<%= id %>">
                    		<% out.print(userName);
                    	}
                    %></a>
        			<% 	
        				if(userName == null){ %>
                			<li class="page-scroll">
                			<a href="../LoginAndRegisterPage.jsp">
                			<% out.print(userName);
                		}
                	%></a>
        					
                    
                
                <li class="page-scroll">
                    <a href="../LoginAndRegisterPage.jsp">Log Out</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<header id="page-top">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-text">
                    <span class="name">Online RealEstate</span>
                    <hr class="star-light">
                    <p class="description">Book Inspection</p>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="content-wrapper">
    <section class="primary" id="portfolio">
        <div class="container-fluid">
        <div class="container container-pad" id="property-listings">
            
            <div class="row">
              <div class="col-md-12 title-col">
                <h1 class="title">Online RealEstate Inspection</h1>
                <p class="description">Detailed Information of house or apartment</p>
              </div>
            </div>
            
            <div class="row">
                <div class="col-sm-6"> 
                
                <% 
                	ApartmentMapper apartmentMapper = new ApartmentMapperImpl();
                	ArrayList<Apartment> apartList = apartmentMapper.findAllApartments();
           			for(int i = 0; i < apartList.size() / 2; i++){
           				System.out.println(apartList.get(i).getApartmentName());
           		%>
           			<!-- Begin Listing-->
                    <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                        <div class="media">
                            <a class="pull-left" href="#" target="_parent">
                            <img alt="image" class="img-responsive" src="http://images.prd.mris.com/image/V2/1/Yu59d899Ocpyr_RnF0-8qNJX1oYibjwp9TiLy-bZvU9vRJ2iC1zSQgFwW-fTCs6tVkKrj99s7FFm5Ygwl88xIA.jpg"></a>

                            <div class="clearfix visible-sm"></div>

                            <div class="media-body fnt-smaller">
                                <a href="#" target="_parent"></a>

                                <h4 class="media-heading">
                                  <a href="#" target="_parent">$ <% out.print(apartList.get(i).getPrice()); %> <small class="pull-right"><% out.print(apartList.get(i).getLocation()); %></small></a></h4>


                                <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                    <li><% out.print(apartList.get(i).getAcreage()); %> SqFt</li>

                                    <li style="list-style: none">|</li>

                                    <li><% out.print(apartList.get(i).getStartRentTime()); %> To <% out.print(apartList.get(i).getEndRentTime()); %></li>
                                </ul>

                                <p class="hidden-xs">
                                	Building Name: <% out.print(apartList.get(i).getApartmentName()); %> 
                                </p>
                                <span class="fnt-smaller fnt-lighter fnt-arial text-right">                               
                                	<form class="realestate-order" action="../ApartmentController", method="post">
                                		<input type="hidden" name="client-id" value="<%= id %>"></input>
                                		<input type="hidden" name="apartment-id" value="<%= apartList.get(i).getapid() %>"></input>
                                		<input class="form-control" type="text" name="inspection-time" placeholder="Favourite Inspection Time ( hour:min dd-mm-yy )"></input>
                    					<input type="submit" name="book" value="Book" class="btn btn-success" ></input>
                    				</form>
                    			</span>

                            </div>
                        </div>
                    </div><!-- End Listing-->
           		<% 
           			}
                	
                %>

                </div>

                <div class="col-sm-6">  
                
                	<% 
                	
           				for(int i = apartList.size() / 2; i < apartList.size(); i++){
           					System.out.println(apartList.get(i).getApartmentName());
           			%>
           			<!-- Begin Listing-->
                    <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
                        <div class="media">
                            <a class="pull-left" href="#" target="_parent">
                            <img alt="image" class="img-responsive" src="http://images.prd.mris.com/image/V2/1/K12MLs4i-e2rsQ-rA6DoCwlysXSrEXZyHtCFkrOLsvK1y2mvbUrlmw5pMXX1laXlnY9_0VU82YeS3EucwIchtg.jpg"></a>

                            <div class="clearfix visible-sm"></div>

                            <div class="media-body fnt-smaller">
                                <a href="#" target="_parent"></a>

                                <h4 class="media-heading">
                                  <a href="#" target="_parent">$ <% out.print(apartList.get(i).getPrice()); %> <small class="pull-right"><% out.print(apartList.get(i).getLocation()); %></small></a></h4>


                                <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                    <li><% out.print(apartList.get(i).getAcreage()); %> SqFt</li>

                                    <li style="list-style: none">|</li>

                                    <li><% out.print(apartList.get(i).getStartRentTime()); %> To <% out.print(apartList.get(i).getEndRentTime()); %></li>
                                </ul>

                                <p class="hidden-xs">
                                	Building Name: <% out.print(apartList.get(i).getApartmentName()); %> 
                                </p>
                                <span class="fnt-smaller fnt-lighter fnt-arial text-right">                               
                                	<form class="realestate-order" action="../ApartmentController", method="post">
                                		<input type="hidden" name="client-id" value="<%= id %>"></input>
                                		<input type="hidden" name="apartment-id" value="<%= apartList.get(i).getapid() %>"></input>
                                		<input class="form-control" type="text" name="inspection-time" placeholder="Favourite Inspection Time ( hour:min dd-mm-yy )"></input>
                    					<input type="submit" name="book" value="Book" class="btn btn-success" ></input>
                    				</form>
                    			</span>

                            </div>
                        </div>
                    </div><!-- End Listing-->
           		<% 
           			}
                	
                %>
                </div><!-- End Col -->
            </div><!-- End row -->
        </div><!-- End container -->
    </div>
    </section>
</div>
</body>
<jsp:include page="../Share/Footer.jsp"></jsp:include>
</html>