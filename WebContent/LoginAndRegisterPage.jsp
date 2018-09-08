<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online RealEstate</title>
<link rel='stylesheet' href='LoginAndRegisterPage.css'/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="pr-wrap">
                <div class="register-body">
                    <label>Register </label>
                    <form class="register" action="/onlinerealestateproject/LoginAndRegisterController" method="post"> 
                    	<input type="text" name="register-firstname" placeholder="First Name" required="required" />
                    	<input type="text" name="register-lastname" placeholder="Last Name" required="required" />
                    	<input type="text" name="register-username" placeholder="Username" required="required" />
                    	<input type="password" name="register-password" placeholder="Password" required="required" />
                    	<input type="submit" name="submit" value="register" class="register-submit btn btn-success btn-sm" />
                    </form>  
                </div>
            </div>
            <div class="wrap">
                <p class="form-title">
                    Sign In
                </p>
                <p class="alter-info">
                	<%
						String info = (String) request.getAttribute("info");
						if(info != null)
							out.print(info);
					%>
                </p>
                <form class="login" action="/onlinerealestateproject/LoginAndRegisterController" method="post">
                <input type="text" name="username" placeholder="Username" required="required" />
                <input type="password" name="password" placeholder="Password" required="required" />
                <input type="submit" name="submit" value="login" class="btn btn-success btn-sm" />
                <div class="remember-register">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" />
                                    Remember Me
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 register-content">
                            <a href="javascription:void(0)" class="register-btn">Register an Account</a>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./Share/Footer.jsp"></jsp:include>
</body>

<script>
	$(document).ready(function () {
    	$('.register-btn').click(function(event) {
      		$(".pr-wrap").toggleClass("show-register");
    	}); 
    
    	$('.register-submit').click(function(event) {
    		$(".pr-wrap").removeClass("show-register");
    	}); 
	});
</script>
</html>