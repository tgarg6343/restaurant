

function getData(){
	
	var city=document.getElementById("cityid").value;
	var url = "https://developers.zomato.com/api/v2.1/search?apikey=81230e201ba9041b31fe0ad8471dd7d2&entity_id=1&entity_type=city&q="+city+"&start=0&count=5";
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", url, true);
	// xhttp.setRequestHeader("user-key","81230e201ba9041b31fe0ad8471dd7d2");
	xhttp.send();
	// document.getElementById("result").innerHTML = "hello"
	// alert(Object.keys(obj.restaurants.length);
	 document.getElementById("result").innerHTML = "hello";
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var obj=JSON.parse(xhttp.responseText);
	    	var x="";
	    	for(var i=0;i<obj.restaurants.length;i++){
	    		x+=`
	    		<div class="card">
	    		<div class="card-block">
	    		<h4 class="card-title">${obj.restaurants[i].restaurant.name}</h4>
	    		<p class="card-text">${obj.restaurants[i].restaurant.location.address}<br>
	    		${obj.restaurants[i].restaurant.cuisines}<br>
	    		ratings:${obj.restaurants[i].restaurant.user_rating.aggregate_rating}<br>
	    		votes:${obj.restaurants[i].restaurant.user_rating.votes}
	    		</p>
	    		<button type="button" onclick="addFavourite()">Add to Favourite</button>
	    		</div>
	    		</div>
	    		`;
	    		}
	    	document.getElementById("result").innerHTML = x;
	    	}
	    };
}

function addFavourite(name,location,cuisines,rating,votes){
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       // Typical action to be performed when the document is ready:
	       document.getElementById("demo").innerHTML = xhttp.responseText;
	    }
	};
	xhttp.open("GET", "filename", true);
	xhttp.send();
	
	
}
