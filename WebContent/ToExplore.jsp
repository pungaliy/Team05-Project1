<!DOCTYPE html><html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Favorites</title>

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
    
    



</head>

<body>

    <div class="container-fluid">
        <div class="row ">
            <div class="col-10">
                <div class="listTitle text-center" style="margin-bottom: 150px;">To Explore List</div>
                <!-- content -->
                <div class="container-fluid" id="list">
                

                </div>



                <!-- end of content-->
            </div>
            <div col="col-2">
                <form action="/ToList" method="get">
                    <div class="mt-20">
                        <select name="list" class="btn bg-secondary wth">
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
                    <button class="btn btn-secondary wth">Back to Results</button>
                </div>
                <div class="mt-20">
                    <button class="btn btn-secondary wth">Return to Search</button>
                </div>

            </div>
        </div>
    </div>
    
    <script>
    
function mv(list2, itemType, index){
    	
    	console.log("moving");
    	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				console.log("return");
				var user = JSON.parse(removeToken('<%= session.getAttribute("user") %>'));
				
	            console.log(user);
	            location.reload();
			}
		}
		xhttp.open("POST", "MoveListServlet?list1=explore&list2=" + list2 + "&itemType=" + itemType + "&index=" + index, true);
		xhttp.send();
    	
		return false;
    
    }
    
	function rm(itemType, index){
    	
    	console.log("remove");
    	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				console.log("return");
				var user = JSON.parse(removeToken('<%= session.getAttribute("user") %>'));
				var check = '<%= session.getAttribute("check") %>';
				var type = '<%= session.getAttribute("type") %>';
				var list = '<%= session.getAttribute("list") %>';
				var index = '<%= session.getAttribute("index") %>';
				console.log(type);
				console.log(list);
				console.log(index);
				console.log(check);
	            console.log(user);
	            location.reload();
			}
		}
		//changethis
		xhttp.open("POST", "RemoveListServlet?list=explore&itemType=" + itemType + "&index=" + index, true);
		xhttp.send();
    	
		return false;
    
    }
    
    function removeToken(tmp){
		tmp = tmp.replace(/\\n/g, "\\n")  
        .replace(/\\'/g, "\\'")
        .replace(/\\"/g, '\\"')
        .replace(/\\&/g, "\\&")
        .replace(/\\r/g, "\\r")
        .replace(/\\t/g, "\\t")
        .replace(/\\b/g, "\\b")
        .replace(/\\f/g, "\\f");
		// remove non-printable and other non-valid JSON chars
		return tmp.replace(/[\u0000-\u0019]+/g,""); 
	}
    
    	
	    var restaurant = JSON.parse('<%= session.getAttribute("expRes") %>');
	    var recipe = JSON.parse(removeToken('<%= session.getAttribute("expRec") %>'));
	    console.log(restaurant);
	    console.log(recipe);
	    
	    var num = 0;
	    var i;
	    var li = document.getElementById('list');
	    var alt = "alt";
	    for(i = 0;i < restaurant.length; i++){
	    	var res = restaurant[i];
	    	if(num % 2 == 0){
	    		alt = "alt";
	    	}
	    	else{
	    		alt = "";
	    	}
	    	li.innerHTML += 
	    	    "<div class=\"row\"><div class=\"col-10\"><!-- --><div class=\"" + alt + "\">"
	    	    +
	    	    createRestaurant(res.name, res.rating, res.distance.toFixed(3), res.price, res.uniqueID, num)
	    	    + "</div><!-- --></div><div class=\"col-2 mt-20\"><div><button class=\"btn btn-primary wth\" onclick=\"rm(\'restaurant\',\'"+ i +"\')\">Remove</button>"
    	    + "</div><div class=\"mt-10\"><div class=\"dropdown\"><button class=\"btn btn-primary wth dropdown-toggle\" data-toggle=\"dropdown\">"
			+ "Move To...</button><div class=\"dropdown-menu\"><button class=\"dropdown-item\" onclick=\"mv(\'favorite\',\'restaurant\',\'"+ i +"\');\">Favorite </button>"
			+ "<button class=\"dropdown-item\" onclick=\"mv(\'not\',\'restaurant\',\'"+ i +"\');\"> Do Not Show </button></div></div></div></div></div>";
				num += 1;
				
				
	    }
	    
	    for(i = 0;i < recipe.length; i++){
	    	var rec = recipe[i];
	    	if(num % 2 == 0){
	    		alt = "alt";
	    	}
	    	else{
	    		alt = "";
	    	}
	    	li.innerHTML += "<div class=\"row\"><div class=\"col-10\"><!-- --><div class=\"" + alt + "\">"
    	    + createRecipe(rec.recipeName, rec.rating, rec.prepTime, rec.cookTime, rec.price, num)
    	    + "</div><!-- --></div><div class=\"col-2 mt-20\"><div><button class=\"btn btn-primary wth\" onclick=\"rm(\'recipe\',\'"+ i +"\')\">Remove</button>"
    	    + "</div><div class=\"mt-10\"><div class=\"dropdown\"><button class=\"btn btn-primary wth dropdown-toggle\" data-toggle=\"dropdown\">"
			+ "Move To...</button><div class=\"dropdown-menu\"><button class=\"dropdown-item\" onclick=\"mv(\'favorite\',\'recipe\',\'"+ i +"\');\">Favorite</button>"
			+ "<button class=\"dropdown-item\" onclick=\"mv(\'not\',\'recipe\',\'"+ i +"\');\"> Do Not Show</button></div></div></div></div></div>";
			num += 1;
			
			
	    }
	    
	    
	    
function createRecipe(name, star, prep, cook, price, num){
            
            var div1 = document.createElement('div');
            
            
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
            //recList.appendChild(div1);
            return div1.innerHTML;
            
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
     		return div1.innerHTML;
        	
        }
    
    
    </script>

</body>

</html>
