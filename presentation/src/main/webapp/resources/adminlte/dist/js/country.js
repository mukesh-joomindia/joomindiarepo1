/**
 * 
 */


function saveCountry(){
	var countryname = document.getElementById("countryName").value;
	var iso = document.getElementById("isonumber").value;
	var url = "webservice/address/country/";
	var http_request = new XMLHttpRequest();
	http_request.open("POST", "webservice/address/country/", true);
	http_request.setRequestHeader("Content-type", "application/json");
	http_request.onreadystatechange = function(){
		
        if (http_request.readyState == 4 && http_request.status == 200 ){
           // Javascript function JSON.parse to parse JSON data
        	var json = JSON.parse(xhr.responseText);
            console.log(json.email + ", " + json.password)

           // jsonObj variable now contains the data structure and can
           // be accessed as jsonObj.name and jsonObj.country.
           
           
        }
     }
		
	var data = JSON.stringify({"name":countryname,"iso":iso});
     http_request.send(data);
}

function createURL() {
    document.getElementsByName("");
	return Math.PI;
}
