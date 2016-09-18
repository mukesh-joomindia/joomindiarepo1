/**
 * 
 */





$(document).ready(function(){
	
	$("#formSubmit").click(function(e){
		alert($("input[name='firstname']").val());
		$.ajax({
		
			type: "POST", 
				url:"register",
				data:jQuery.param({
					 firstname : $("input[name='firstname']").val(),
					 lastname : $("input[name='lastname']").val(),
					 email : $("input[name='email']").val(),
					 password : $("input[name='password']").val(),
					 repass : $("input[name='repass']").val()
				}),
				success:function(responseText){
						$("#warnDiv").html(responseText);
				}});
	});
});
