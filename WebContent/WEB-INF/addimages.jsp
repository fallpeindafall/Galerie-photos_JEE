<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
      <meta charset='utf-8'>
      <meta name='viewport' content='width=device-width, initial-scale=1'>
      <meta name="description" content="" />
        <meta name="author" content="" />
        <title> Galerie Photo</title>
        
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
      <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
      <link href='' rel='stylesheet'>
      <style> body {
     background-color: #eee
	}

 .form-control:focus {
     color: #495057;
     background-color: #fff;
     border-color: #80bdff;
     outline: 0;
     box-shadow: 0 0 0 0rem rgba(0, 123, 255, .25)
 }

.btn-primary:hover {
  color: #fff;
  background-color: #fec810;
  border-color: #fec503;
}
.btn-primary:focus, .btn-primary.focus {
  color: #fff;
  background-color: #fec810;
  border-color: #fec503;
  box-shadow: 0 0 0 0.2rem rgba(254, 216, 84, 0.5);
}
.btn-primary {
  color: #fff;
  background-color: #fed136;
  border-color: #fed136;
}
 .btn-secondary:focus {
     box-shadow: 0 0 0 0rem rgba(108, 117, 125, .5)
 }
.btn-primary:hover {
  color: #fff;
  background-color: #fec810;
  border-color: #fec503;
}
 .close:focus {
 color: #fff;
  background-color: #5a6268;
  border-color: #545b62;
  box-shadow: 0 0 0 0.2rem rgba(130, 138, 145, 0.5);
 }

 .mt-200 {
     margin-top: 200px
 }</style>
 <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
 <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
 <script type='text/javascript'>$(document).ready(function(){

	$('#smartwizard').smartWizard({
	selected: 0,
	theme: 'dots',
	autoAdjustHeight:true,
	transitionEffect:'fade',
	showStepURLhash: false,
	
	});
	
	});
</script>
<link href="css/styles.css" rel="stylesheet" />

        </head>
        <body oncontextmenu='return false' class='snippet-body'>
        <link href="https://res.cloudinary.com/dxfq3iotg/raw/upload/v1581152092/smartwizard/smart_wizard.min.css" rel="stylesheet" type="text/css" />
 <link href="https://res.cloudinary.com/dxfq3iotg/raw/upload/v1581152092/smartwizard/smart_wizard_theme_dots.min.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="https://res.cloudinary.com/dxfq3iotg/raw/upload/v1581152197/smartwizard/jquery.smartWizard.min.js"></script>
 
  <jsp:include page="inc/menuAjout.jsp"/>
         <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Welcome To Our Gallery App!</div>
                <div class="masthead-heading text-uppercase">Hope You'll Enjoy it! </div>
                <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" data-toggle="modal" data-target="#exampleModal">Add Pictures</a>
            </div>
        </header>
 
 
 <div class="container">
     <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
             <div class="modal-content">
                 <div class="modal-header">
                     <h5 class="modal-title" id="exampleModalLabel">Sharing new Pictures</h5> <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                 </div>
                 <div class="modal-body">
                     <div id="smartwizard">
                         <ul>
                             <li><a href="#step-1">Step 1<br /><small>Add or chose Album</small></a></li>
                             <li><a href="#step-2">Step 2<br /><small>Info Image</small></a></li>
                             <li><a href="#step-3">Step 3<br /><small>Uploading Pictures</small></a></li>
                             <li><a href="#step-4">Step 4<br /><small>Validation</small></a></li>
                         </ul>
                         <div>
                             <div id="step-1">
                                 <div class="row">
                            
              
                                 
                                     <div class="col-md-6"> 
                                     	<label >add a new album:</label>
                                     		<input type="text" class="form-control" placeholder="Name Album" required> 
                                     </div>
                                 	<div class="col-md-6"> 
                                     	<label for="albums" >Choose an existing album:</label>

											<select name="albums" id="albums"  class="form-control">
											  <option value="beach">Beach</option>
											  <option value="sky">Sky</option>
											</select>
                                      </div>
                                 </div>
                                  <div class="row mt-3">
                                 
                                     <div class="col-md-6"> 
                                         <label >Visibility</label>
                                     	<div class="form-check">
										  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios"  value="option1" checked>
										  <label class="form-check-label" for="exampleRadios2">
										    Public
										  </label>
										</div>
										<div class="form-check">
										  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
										  <label class="form-check-label" for="exampleRadios2" >
										    Private
										  </label>
										</div>
                                     	
                                     </div>
                                 </div>
                                
                             </div>
                             <div id="step-2">
                                 <div class="row">
                                 	  
                                 	
                                     <div class="col-md-6">
                                     <label>Keywords</label>
                                      <input type="text" class="form-control" placeholder="Keywords" required> </div>
                                 
                                 	 <div class="col-md-6"> 
                                 	 <label>Description</label>
                                     	<textarea class="form-control" placeholder="Description" required id="description" name="description" rows="4" cols="50">

										</textarea>
                                     </div>
                                 </div>
                                
                             </div>
                             <div id="step-3" class="">
                                 <div class="row" >
                                     <div class="col-md-6" class="form-control"> 
                                     	<label for="files">Upload images</label>
 									 <input type="file" id="files" name="files" multiple>
                                 </div>
                                </div>
                             </div>
                            <div id="step-4" class="">
                                 <div class="row" >
                                     <div class="col-md-6"> 
                                     	<label class="form-control"> Validation</label>
                                 </div>
                                </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
     </div>
 </div>
                            </body>
                        </html>