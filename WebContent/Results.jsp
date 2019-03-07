<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Results</title>

    <!-- maxcdn -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <!-- fav icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- style  -->
    <link href="./css/main.css?version=5" rel="stylesheet">

    <script>
    
    	var enter = '<%= session.getAttribute("enter") %>';
    	console.log(enter);
    	
    	var url;
    	var user;
    	
    
        function getResults() {

            var q = '<%= session.getAttribute("query") %>';
            document.getElementById('title').innerHTML = "Search Results for " + q + "";
            
            
            url = JSON.parse('<%= session.getAttribute("imageURLs") %>');
            
            //user = JSON.parse('<%= session.getAttribute("user") %>');
            //console.log(user);
            
            var min = 0;
            var max = 8;
            var ran = 0

            //set random angle to images
            for (let i = 1; i < 11; i++) {
            	var image = document.getElementById(i);
            	image.src = url[i - 1];
                ran = Math.floor(Math.random() * (+max - +min)) + +min;
                setAngel(image, ran, i);
            }
            
            

        }

        function setAngel(image, num, id) {
            if (num == 0) {
                image.classList.add("rt-45");
            } else if (num == 1) {
                image.classList.add("rt-35");
            } else if (num == 2) {
                image.classList.add("rt-25");
            } else if (num == 3) {
                image.classList.add("rt-15");
            } else if (num == 4) {
                image.classList.add("rt15");
            } else if (num == 5) {
                image.classList.add("rt25");
            } else if (num == 6) {
                image.classList.add("rt35");
            } else if (num == 7) {
                image.classList.add("rt45");
            }

            return;
        }
        
        function toSearch(){
        	window.location.href = "/Search.html";
        }
	    
	

    </script>

</head>

<body onload="getResults()">

    <div class="container-fluid">
        <div class="row text-center" style="padding-left: 100px;margin-top: 100px; margin-bottom: 100px;">
            <!-- image -->
            <div class="col-9">
                <div class="container" id="collage" style="
				    width: 50vw;
				    height: 40vh;
				">
                    <div class="row">
                        <img src="" class="googleImage " id="1">
                        <img src="" class="googleImage " id="2">
                        <img src="" class="googleImage " id="3">
                        <img src="" class="googleImage " id="4">
                        <img src="" class="googleImage " id="5">
                    </div>
                    <div class="row">
                        <img src="" class="googleImage " id="6">
                        <img src="" class="googleImage " id="7">
                        <img src="" class="googleImage " id="8">
                        <img src="" class="googleImage " id="9">
                        <img src="" class="googleImage " id="10">
                    </div>
                </div>
            </div>
            <!-- navbar -->
            <div class="col-3" style="padding-top: 50px;">
                <form action="/ToList"  method="get">
                    <div class="mt-20">
                        <select name="list" class="btn bg-secondary wth" id="list">
                            <option value="nil" selected>_______________________</option>
                            <option value="favorite">Favorite List</option>
                            <option value="explore">To Explore List</option>
                            <option value="not">Do Not Show List</option>
                        </select>
                    </div>
                    <div class="mt-20">
                        <button class="btn btn-secondary wth" type="submit">Manage List</button>
                    </div>
                </form>

                <div class="mt-20">
                    <button class="btn btn-secondary wth" onclick="toSearch();">Return to Search</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 text-center">
                <h1 id="title">
                </h1>
            </div>
        </div>
        <div class="row">
        	<!--  restaurant -->
            <div class="col-12 col-md-6" id="restList">
                
            </div>

            <!-- recipe -->

            <div class="col-12 col-md-6" id="recList">
      
            </div>
            
        </div>
    </div>
    
    <script>
    	
    	var restList = document.getElementById('restList');
	var recList = document.getElementById('recList');
		
    	
    	function create(){
    		

            //set restaurantt
            var restaurant = JSON.parse('<%= session.getAttribute("restaurantResults") %>');
            var recipe = JSON.parse('<%= session.getAttribute("recipeResults") %>');
            
            console.log(restaurant);
            console.log(recipe);
          
            var head = document.createElement('h2');
            head.classList.add('text-center');
            var u = document.createElement('u');
            u.innerHTML = "Restaurant";
            head.appendChild(u);
            
            restList.appendChild(head);
            
            var head2 = document.createElement('h2');
            head2.classList.add('text-center');
            var u2 = document.createElement('u');
            u2.innerHTML = "Recipe";
            head2.appendChild(u2);
            
            recList.appendChild(head2);
    	
    		
            //set restaurantt
            var restaurant = JSON.parse('<%= session.getAttribute("restaurantResults") %>');
            var recipe = JSON.parse('<%= session.getAttribute("recipeResults") %>');
            var query = '<%= session.getAttribute("query") %>';
            //var thisUser = JSON.parse('<%= session.getAttribute("user") %>');
            //console.log(thisUser);
            
            
         
            for (let num = 0; num < restaurant.length; num++){
            	var res = restaurant[num];
            	
            		createRestaurant(res.name, res.rating, res.distance.toFixed(3), res.price, res.uniqueID, num);
            
            }
            
            var color = 0;
            for (let num = 0; num < recipe.length; num++){
            	var rec = recipe[num];
            	
            		createRecipe(rec.recipeName, rec.rating, rec.prepTime, rec.cookTime, rec.price, num);
            
            }
          
            
    	}
    	
    	//delete box
    	
function createRecipe(name, star, prep, cook, price, num){
            
            var div1 = document.createElement('div');
            if(num % 2 == 0){
            	div1.className = "";
            }
            else{
            	div1.className = "alt ";
            }
            
            var div2 = document.createElement('div');
            div2.classList.add("container");
            
            var div3 = document.createElement('div');
            div3.classList.add("row");
            
            var div4 = document.createElement('div');
            div4.classList.add("col-11");
            
            var div5 = document.createElement('div');
            var h1 = document.createElement('h3');
            h1.innerHTML = name;
            
            var link = document.createElement('a');
            link.href = "/Recipe.jsp?id=" + num;
            link.appendChild(h1);
            
            div5.appendChild(link);
            
            var newDiv = document.createElement('div');
            var h2 = document.createElement('h4');
            if(star == 0){
            	h2.innerHTML = "no rating";
            }
            else{
            	h2.innerHTML = star + "&#9734";
            }
            newDiv.appendChild(h2);
            
            
            var div6 = document.createElement('div');
            var h3 =  document.createElement('h4');
            h3.innerHTML = "Prep Time: " + prep;
            h3.style.cssText = "float: left; margin-right: 20px;";
            var h4 =  document.createElement('h4');
            h4.innerHTML = "Cook Time: " + cook;
            var clear = document.createElement('div');
            clear.cssText = "clear: both";
            div6.appendChild(h3);
            div6.appendChild(h4);
            div6.appendChild(clear);
          
            
            div4.appendChild(div5);
            div4.appendChild(newDiv);
            div4.appendChild(div6);
            
            var div7 = document.createElement('div');
            div7.className = " col-1 mt50";
            var dollar = document.createElement('h3');
            if(price == null){
            	dollar.innerHTML = "$";
            }
            else{
            	dollar.innerHTML = price;
            }
            div7.appendChild(dollar);
            
            div3.appendChild(div4);
            div3.appendChild(div7);
            
            div2.appendChild(div3);
            div1.appendChild(div2);
            recList.appendChild(div1);
            
        }
        
        function createRestaurant(name, star, dist, price, id, num){
        	
        	var div1 = document.createElement('div');
            if(num % 2 == 0){
            	div1.className = "alt ";
            }
            else{
            	div1.className = "";
            }
            
            var div2 = document.createElement('div');
            div2.classList.add("container");
            
            var div3 = document.createElement('div');
            div3.classList.add("row");
            
            var div4 = document.createElement('div');
            div4.classList.add("col-10");
            
            var div5 = document.createElement('div');
            var h1 = document.createElement('h3');
            h1.innerHTML = name;
            
            var link = document.createElement('a');
            link.href = "/Restaurant.jsp?id=" + id;
            link.appendChild(h1);
            
            div5.appendChild(link);
          
            
            var newDiv = document.createElement('div');
            var h2 = document.createElement('h4');
            if(star == 0){
            	h2.innerHTML = "no rating";
            }
            else{
            	h2.innerHTML = star + "&#9734";
            }
            newDiv.appendChild(h2);
            
           
            var div6 = document.createElement('div');
            var h3 =  document.createElement('h4');
            h3.innerHTML = "Distance: " + dist + " m";
            div6.appendChild(h3);
          
            
            div4.appendChild(div5);
            div4.appendChild(newDiv);
            div4.appendChild(div6);
            
            var div7 = document.createElement('div');
            div7.className = " col-2 mt50";
            var dollar = document.createElement('h3');
            if(price == null){
            	dollar.innerHTML = "$";
            }
            else{
            	dollar.innerHTML = price;
            }
            div7.appendChild(dollar);
            
            div3.appendChild(div4);
            div3.appendChild(div7);
            
            div2.appendChild(div3);
            div1.appendChild(div2);
            restList.appendChild(div1);
        	
        }
    
    
create();
    
    </script>

</body>

</html>
