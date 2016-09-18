/**
 * 
 */

function doRegister()
{
	var xmlhttp;
	var firstName = document.getElementsByName("firstname");
	var lastname = document.getElementsByName("lastname");
	var email = document.getElementsByName("email");
	var password = document.getElementsByName("password");
	var repass = document.getElementsByName("repass");
	
	if(validateInput(firstName,lastname,email,password,repass)){

		if(window.XMLHttpRequest){
			this.xmlhttp = new XMLHttpRequest();
		}
		else{
			this.xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		this.xmlhttp.open("post","/register",true);
		this.xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		this.xmlhttp.onreadystatechange = function() {
			if (this.xmlhttp.readyState == 4)
			{
			updatepage(this.xmlhttp.responseText);
			}
			/*else
			{ 
			updatepage(responsemsg,responsediv);

			}*/
		}
		
		this.xmlhttp.send(getquerystring(formname));
 }
}

function validateInput(firstName,lastname,email,repass){

	return true;
	
}

function getquerystring(formname) {
	
	
}


function updatepage(respText){
	
	documment.getElementById("warnDiv").innerHTML = respText;
	
}