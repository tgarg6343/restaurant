function getData(){
	var url = "https://developers.zomato.com/api/v2.1/search?apikey=81230e201ba9041b31fe0ad8471dd7d2&entity_id=1&entity_type=city&q=Delhi&start=0&count=5";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       // Typical action to be performed when the document is ready:
	       document.getElementById("result").innerHTML = xhttp.responseText;
	    }
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}