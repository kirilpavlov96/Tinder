<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Tinder</title>

<!-- Bootstrap core CSS -->

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="fonts/css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="css/custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/maps/jquery-jvectormap-2.0.3.css" />
<link href="css/icheck/flat/green.css" rel="stylesheet" />
<link href="css/floatexamples.css" rel="stylesheet" type="text/css" />

<script src="js/jquery.min.js"></script>
<script src="js/nprogress.js"></script>


</head>


<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="sideMenu.jsp" />
			<jsp:include page="navMenu.jsp" />


			<div class="right_col" role="main">

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>User Profile</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">

								<div class="col-md-3 col-sm-3 col-xs-12 profile_left">

									<div class="profile_img">

										<!-- end of image cropping -->
										<div id="crop-avatar">
											<!-- Current avatar -->
											<div class="avatar-view" title="Change the avatar">
												<img src="images/img.jpg" alt="Avatar">
											</div>

											<!-- Cropping modal -->
											<div class="modal fade" id="avatar-modal" aria-hidden="true"
												aria-labelledby="avatar-modal-label" role="dialog"
												tabindex="-1">
												<div class="modal-dialog modal-lg">
													<div class="modal-content">
														<form class="avatar-form" action="crop.php"
															enctype="multipart/form-data" method="post">
															<div class="modal-header">
																<button class="close" data-dismiss="modal" type="button">&times;</button>
																<h4 class="modal-title" id="avatar-modal-label">Change
																	Avatar</h4>
															</div>
															<div class="modal-body">
																<div class="avatar-body">

																	<!-- Upload image and data -->
																	<div class="avatar-upload">
																		<input class="avatar-src" name="avatar_src"
																			type="hidden"> <input class="avatar-data"
																			name="avatar_data" type="hidden"> <label
																			for="avatarInput">Local upload</label> <input
																			class="avatar-input" id="avatarInput"
																			name="avatar_file" type="file">
																	</div>

																	<!-- Crop and preview -->
																	<div class="row">
																		<div class="col-md-9">
																			<div class="avatar-wrapper"></div>
																		</div>
																		<div class="col-md-3">
																			<div class="avatar-preview preview-lg"></div>
																			<div class="avatar-preview preview-md"></div>
																			<div class="avatar-preview preview-sm"></div>
																		</div>
																	</div>

																	<div class="row avatar-btns">
																		<div class="col-md-9">
																			<div class="btn-group">
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="-90" type="button"
																					title="Rotate -90 degrees">Rotate Left</button>
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="-15" type="button">-15deg</button>
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="-30" type="button">-30deg</button>
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="-45" type="button">-45deg</button>
																			</div>
																			<div class="btn-group">
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="90" type="button"
																					title="Rotate 90 degrees">Rotate Right</button>
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="15" type="button">15deg</button>
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="30" type="button">30deg</button>
																				<button class="btn btn-primary" data-method="rotate"
																					data-option="45" type="button">45deg</button>
																			</div>
																		</div>
																		<div class="col-md-3">
																			<button class="btn btn-primary btn-block avatar-save"
																				type="submit">Done</button>
																		</div>
																	</div>
																</div>
															</div>
															<!-- <div class="modal-footer">
                                                  <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
                                                </div> -->
														</form>
													</div>
												</div>
											</div>
											<!-- /.modal -->

											<!-- Loading state -->
											<div class="loading" aria-label="Loading" role="img"
												tabindex="-1"></div>
										</div>
										<!-- end of image cropping -->

									</div>
									<h3>Vancho Bozdugana</h3>

									<ul class="list-unstyled user_data">
										<li><i class="fa fa-map-marker user-profile-icon"></i>
											San Francisco, California, USA</li>

										<li><i class="fa fa-briefcase user-profile-icon"></i>
											Software Engineer</li>

										<li class="m-top-xs"><i
											class="fa fa-external-link user-profile-icon"></i> <a
											href="http://www.kimlabs.com/profile/" target="_blank">www.kimlabs.com</a>
										</li>
									</ul>

									<a class="btn btn-success"><i class="fa fa-edit m-right-xs"></i>Edit
										Profile</a> <br />

									<!-- start skills -->
									<h4>Skills</h4>
									<ul class="list-unstyled user_data">
										<li>
											<p>Web Applications</p>
											<div class="progress progress_sm">
												<div class="progress-bar bg-green" role="progressbar"
													data-transitiongoal="50"></div>
											</div>
										</li>
										<li>
											<p>Website Design</p>
											<div class="progress progress_sm">
												<div class="progress-bar bg-green" role="progressbar"
													data-transitiongoal="70"></div>
											</div>
										</li>
										<li>
											<p>Automation & Testing</p>
											<div class="progress progress_sm">
												<div class="progress-bar bg-green" role="progressbar"
													data-transitiongoal="30"></div>
											</div>
										</li>
										<li>
											<p>UI / UX</p>
											<div class="progress progress_sm">
												<div class="progress-bar bg-green" role="progressbar"
													data-transitiongoal="50"></div>
											</div>
										</li>
									</ul>
									<!-- end of skills -->
								</div>

								<div class="col-md-9 col-sm-9 col-xs-12">
									<h2>User Pictures</h2>
									<div class="col-md-55">
										<div class="thumbnail">
											<div class="image view view-first">
												<img style="width: 100%; display: block;" src="images/4.jpg"
													alt="image" />
												<div class="mask">
													<p>Your Text</p>
													<div class="tools tools-bottom">
														<a href="#"><i class="fa fa-link"></i></a> <a href="#"><i
															class="fa fa-pencil"></i></a> <a href="#"><i
															class="fa fa-times"></i></a>
													</div>
												</div>
											</div>
											<div class="caption">
												<p>Snow and Ice Incoming for the South</p>
											</div>
										</div>
									</div>
									<div class="col-md-55">
										<div class="thumbnail">
											<div class="image view view-first">
												<img style="width: 100%; display: block;" src="images/4.jpg"
													alt="image" />
												<div class="mask">
													<p>Your Text</p>
													<div class="tools tools-bottom">
														<a href="#"><i class="fa fa-link"></i></a> <a href="#"><i
															class="fa fa-pencil"></i></a> <a href="#"><i
															class="fa fa-times"></i></a>
													</div>
												</div>
											</div>
											<div class="caption">
												<p>Snow and Ice Incoming for the South</p>
											</div>
										</div>
									</div>
									<div class="col-md-55">
										<div class="thumbnail">
											<div class="image view view-first">
												<img style="width: 100%; display: block;" src="images/4.jpg"
													alt="image" />
												<div class="mask">
													<p>Your Text</p>
													<div class="tools tools-bottom">
														<a href="#"><i class="fa fa-link"></i></a> <a href="#"><i
															class="fa fa-pencil"></i></a> <a href="#"><i
															class="fa fa-times"></i></a>
													</div>
												</div>
											</div>
											<div class="caption">
												<p>Snow and Ice Incoming for the South</p>
											</div>
										</div>
									</div>
									<div class="col-md-55">
										<div class="thumbnail">
											<div class="image view view-first">
												<img style="width: 100%; display: block;" src="images/4.jpg"
													alt="image" />
												<div class="mask">
													<p>Your Text</p>
													<div class="tools tools-bottom">
														<a href="#"><i class="fa fa-link"></i></a> <a href="#"><i
															class="fa fa-pencil"></i></a> <a href="#"><i
															class="fa fa-times"></i></a>
													</div>
												</div>
											</div>
											<div class="caption">
												<p>Snow and Ice Incoming for the South</p>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<br />

				<jsp:include page="footer.jsp" />
			</div>
			<!-- /page content -->

		</div>

	</div>

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>

	
	<script>
		NProgress.done();
	</script>
	<!-- /datepicker -->
	<!-- /footer content -->
</body>

</html>
