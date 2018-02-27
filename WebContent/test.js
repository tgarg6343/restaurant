function getData(){
	
   var xhttp = new XMLHttpRequest();
   var link = "https://developers.zomato.com/api/v2.1/search?apikey=81230e201ba9041b31fe0ad8471dd7d2&entity_id=1&entity_type=city&q=Delhi&start=0&count=5";
   
   xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
    	   
    	  
         var x=xhttp.responseText;
         document.getElementById("result").innerHTML = xhttp.responseText;
         document.write(xhttp.responseText); 
      }
   };
   xhttp.open("GET", link, true);
   xhttp.send();
}
