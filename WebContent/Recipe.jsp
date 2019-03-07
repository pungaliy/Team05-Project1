<!DOCTYPE html><html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Recipe</title>

    <!-- maxcdn -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    

    <!-- style  -->
    <link href="./css/main.css?version=5" rel="stylesheet">
    
    <script>
    	function toResult(){
    		window.location.href = "/Results.jsp";
    	}
    </script>
   

</head>

<body>

    <div class="container-fluid">
        <div class="row ">
            <div class="col-10">
                <div class="listTitle" style="margin-bottom: 50px;" id="title"></div>
               </div>
               <div col="col-2">
                <div class="mt-20">
                    <a href="javascript:window.print();"><button class="btn btn-secondary wth" >Printable View</button></a>
                </div>
                <div class="mt-20">
                    <button class="btn btn-secondary wth" onclick="toResult();">Back to Results</button>
                </div>
                <form action="" onsubmit="return add();" method="get" id="myform">
                    <div class="mt-20">
                        <select name="list" class="btn bg-secondary wth" id="list">
                            <option value="nil" selected>_______________________</option>
                            <option value="favorite">Favorite List</option>
                            <option value="explore">To Explore List</option>
                            <option value="not">Do Not Show List</option>
                        </select>
                    </div>
                    <div class="mt-20">
                        <button class="btn btn-secondary wth" type="submit">Add to List</button>
                    </div>
                </form>

            </div>
           </div>
    
      
      <div class="row">
      
                <!-- content -->
                <img id="image" src="" width="200">
                <div style="font-size: 20px;">
                    <div class="mt-20" id="prep">
                        
                    </div>
                    <div class="mt-20" id="cook">
              
                    </div>
                    <div class="mt-20" id="ingredients">

                    </div>
                    <div class="mt-20" id="instructions">
 
                    </div>
                </div>



            <!-- end of content -->
	</div>

	</div>
    
    
        <script>
        
      //adding
    	function add(){
    		console.log("adding");
    		var list = document.getElementById("list").value;
    		if(list == null || list == "nil"){
    			return false;
    		}
    		else{
    			var xhttp = new XMLHttpRequest();
    			xhttp.onreadystatechange = function(){
    				if(this.readyState == 4 && this.status == 200){
    					console.log("return");
    					var tmp = '<%= session.getAttribute("user") %>';
    		            var user = JSON.parse(tmp);
    		            console.log(user);
    				}
    			}
    			xhttp.open("POST", "AddToServlet?id=" + id + "&item=r&list=" + list, true);
        		xhttp.send();
    		}
    		
    		return false;
    		
    	}
      
      
    	var form = document.getElementById("myform"); 
    	function handleForm(event) { 
    		event.preventDefault(); 
    	} 
    	form.addEventListener('submit', handleForm);
      
    var link = window.location.href;
	var url = new URL(link);
	var id = url.searchParams.get("id");
	console.log(id)
	
	var tmp = '<%= session.getAttribute("recipeResults") %>'; 
    var recipe = JSON.parse(tmp);
	var current = recipe[id];
	console.log(current);
	
	document.getElementById('title').innerHTML = current.recipeName;

	document.getElementById('prep').innerHTML = "Prep Time: " + current.prepTime;
	document.getElementById('cook').innerHTML = "Cook Time: " + current.cookTime;
	document.getElementById('image').src = current.imageLink;
	var ingre = document.getElementById('ingredients');
	var u = document.createElement('u');
	u.innerHTML = "Ingredients: ";
	ingre.appendChild(u);
	var ul = document.createElement('ul');
	for(var i = 0; i < current.ingredients.length; i++){
		var li = document.createElement("li");
		li.innerHTML = current.ingredients[i];
		ingre.appendChild(li);
	}
	
	var instr = document.getElementById('instructions');
	var u2 = document.createElement('u');
	u2.innerHTML = "Instructions:";
	
	instr.appendChild(u2);
	var ul = document.createElement('ol');
	for(var i = 0; i < current.instructions.length; i++){
		var li = document.createElement("li");
		li.innerHTML = current.instructions[i];
		instr.appendChild(li);
	}
	

    
    </script>

</body>

</html>
