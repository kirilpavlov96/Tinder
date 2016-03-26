
<%@page
	import="com.mysql.jdbc.interceptors.SessionAssociationInterceptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Tinder</title>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="fonts/css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/maps/jquery-jvectormap-2.0.3.css" />
<link href="css/icheck/flat/green.css" rel="stylesheet" />
<link href="css/floatexamples.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-2.2.2.js"
	integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="
	crossorigin="anonymous"></script>

<script src="js/jquery.min.js"></script>
<script src="js/nprogress.js"></script>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	height: auto;
	margin: auto;
}
</style>
</head>


<body class="nav-md">
	<div class="container body">

		<div class="main_container">

			<jsp:include page="sideMenu.jsp" />

			<jsp:include page="navMenu.jsp" />


			<div class="right_col" role="main">

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="dashboard_graph">

							<div class="row x_title">
								<h2>Matching</h2>
								<div class="col-md-6"></div>
							</div>

							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="mainWrapper">
									<div class="imageWrapper">
										<div class="container">
											<br>
											<div id="myCarousel" class="carousel slide"
												data-ride="carousel">
												<!-- Indicators -->
												<ol class="carousel-indicators">
													<li data-target="#myCarousel" data-slide-to="0"
														class="active"></li>
													<li data-target="#myCarousel" data-slide-to="1"></li>
													<li data-target="#myCarousel" data-slide-to="2"></li>
													<li data-target="#myCarousel" data-slide-to="3"></li>
												</ol>

												<!-- Wrapper for slides -->
												<div class="carousel-inner" role="listbox">
													<div class="item active">
														<img src="images/prod1.jpg" alt="1" width="460"
															height="345">
													</div>

													<div class="item">
														<img src="images/prod2.jpg" alt="2" width="460"
															height="345">
													</div>

													<div class="item">
														<img src="images/prod3.jpg" alt="3" width="460"
															height="345">
													</div>

													<div class="item">
														<img src="images/prod4.jpg" alt="4" width="460"
															height="345">
													</div>
												</div>

												<!-- Left and right controls -->
												<a class="left carousel-control" href="#myCarousel"
													role="button" data-slide="prev"> <span
													class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
													<span class="sr-only">Previous</span>
												</a> <a class="right carousel-control" href="#myCarousel"
													role="button" data-slide="next"> <span
													class="glyphicon glyphicon-chevron-right"
													aria-hidden="true"></span> <span class="sr-only">Next</span>
												</a>
											</div>
										</div>
										<button onclick="worker()" class="LDButton"
											style="float: right;" type="button">Dislike</button>
										<button onclick="worker()" class="LDButton"
											style="float: left;" type="button">Like</button>
									</div>
								</div>
							</div>

							<div class="clearfix"></div>
						</div>
					</div>

				</div>
				<br />

				<jsp:include page="footer.jsp" />
			</div>
			<!-- /page content -->

		</div>

	</div>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>

	<script>
		NProgress.done();
	</script>
	<script type="text/javascript">
		function worker() {
			$.ajax({
				url : 'LikeDislikeService',
				type: 'POST',
				data: {action:'Like'}
			}).done(function(response){
				console.log(response);
			});
		};
	</script>
</body>

</html>
