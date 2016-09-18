/**
 * 
 */


function passStrCheck(){
	
	var pass = document.querySelector("#pass");
	
	if( pass.value.length <= 8 ) {
        document.getElementById("passwarning").innerHTML="Password must be more than 8 character.";
    }
	
	
	
}

function termsValidation(){
	if(!(document.getElementById("termsCheck").checked)){
		alert('pls accept terms first');
	}
}