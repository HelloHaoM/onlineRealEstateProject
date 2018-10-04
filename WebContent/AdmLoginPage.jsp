<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online RealEstate</title>
<link rel='stylesheet' href='AdmLoginPage.css'/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="wrap">
                <p class="form-title">
                    Administrator Sign In
                </p>
                <p class="alter-info">
                	<%
						String info = (String) request.getAttribute("info");
						if(info != null)
							out.print(info);
					%>
                </p>
                <form class="login" action="AdmLoginController" method="post">
                <input type="text" name="username" placeholder="Username" required="required" />
                <input type="password" name="password" placeholder="Password" required="required" />
                <input type="submit" name="submit" value="login" class="btn btn-success btn-sm" />
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./Share/Footer.jsp"></jsp:include>
</body>

</html>