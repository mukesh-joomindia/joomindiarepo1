<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="resources/js/jQuery.AjaxFileUpload.js"></script>
<style>
#picture {
      width: 300px;
      height: 300px;
      background: url(/usr/data/mukesh/software/AdminLTE-master/dist/img/user8-128x128.jpg) no-repeat;
      background-size: 300px 300px;
      border: 10px solid #fff;
      position: relative;    
      -webkit-box-sizing: border-box;
      -moz-box-sizing: border-box;
      -ms-box-sizing: border-box;
       box-sizing: border-box;
       -webkit-box-shadow: 5px 5px 5px #111;
       box-shadow: 5px 5px 5px #111;     
               }
.pic_transform {
        transition-duration: 0.5s;            
        -webkit-transition-duration: 0.5s; 
        -moz-transition-duration: 0.5s;    
        -o-transition-duration: 0.5s;
         overflow: hidden;
         height: 0px;
                         }
#picture:hover .pic_transform {
          height: 50px;
                          }
.text_display {
        transform-origin: top;               
        transition-duration: 0.5s;               
        -webkit-transform-origin: top;       
        -webkit-transition-duration: 0.5s;   
        -moz-transform-origin: top;           
        -moz-transition-duration: 0.5s;       
        -o-transform-origin: top;    
        -o-transition-duration: 0.5s;
        font-size: 16px;
        font-family: Arial;       
        font-weight: normal;
        text-align:center;
        color: #FFF;       
                     }
#picture:hover .text_display {
         background: rgba(0, 0, 0, 0.5);   
         color: #fff;   
         height:50px;   
                      }
                      
</style>
</head>
<body>
<div id="picture">
    <div class="pic_transform">
        <div class="text_display">
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  edit pic
</button>
        </div>
    </div>
</div>


<!-- modal-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
     <div class="modal-body">
        	<label for="exampleInputFile">Upload Photo</label>
      <form action="uploadfile" method="post" enctype="multipart/form-data">
      	  	 	<input type="file" name="file" />
      	      	<div class="modal-footer">
       	    	 <button type="submit" class="btn btn-primary">Save changes</button>
     	</div>
     	<div id="uploadmsg"></div>
      </form>
     </div>
    </div>
  </div>
</div>

</body>
</html>