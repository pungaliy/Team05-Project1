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
    	
    	var restaurant;
    	var recipe;
    	var url;
    	var user;
    
        function getResults() {

            restaurant = JSON.parse('<%= session.getAttribute("restaurantResults") %>');
            var tmp = '<%= session.getAttribute("recipeResults") %>';
         // preserve newlines, etc - use valid JSON
            tmp = tmp.replace(/\\n/g, "\\n")  
                           .replace(/\\'/g, "\\'")
                           .replace(/\\"/g, '\\"')
                           .replace(/\\&/g, "\\&")
                           .replace(/\\r/g, "\\r")
                           .replace(/\\t/g, "\\t")
                           .replace(/\\b/g, "\\b")
                           .replace(/\\f/g, "\\f");
            // remove non-printable and other non-valid JSON chars
            tmp = tmp.replace(/[\u0000-\u0019]+/g,""); 
            var recipe = JSON.parse(tmp);
            //url = JSON.parse('<%= session.getAttribute("imageURLs") %>');
            user = JSON.parse('<%= session.getAttribute("user") %>');

            console.log(restaurant);
            //console.log(url);
            console.log(recipe);
            
            var min = 0;
            var max = 8;
            var ran = 0

            //set random angle to images
            for (let i = 1; i < 11; i++) {
                ran = Math.floor(Math.random() * (+max - +min)) + +min;
                setAngel(ran, i);
            }
            
            //set restaurantt
            for (res in restaurant){
            	
            }

        }

        function setAngel(num, id) {
            if (num == 0) {
                document.getElementById(id).classList.add("rt-45");
            } else if (num == 1) {
                document.getElementById(id).classList.add("rt-35");
            } else if (num == 2) {
                document.getElementById(id).classList.add("rt-25");
            } else if (num == 3) {
                document.getElementById(id).classList.add("rt-15");
            } else if (num == 4) {
                document.getElementById(id).classList.add("rt15");
            } else if (num == 5) {
                document.getElementById(id).classList.add("rt25");
            } else if (num == 6) {
                document.getElementById(id).classList.add("rt35");
            } else if (num == 7) {
                document.getElementById(id).classList.add("rt45");
            }

            return;
        }
	    
	function test(){
            
            var top = document.getElementById('restList');
            var head = document.createElement('h2');
            head.classList.add('text-center');
            var u = document.createElement('u');
            u.innerHTML = "Restaurant";
            head.appendChild(u);
            
            var div1 = document.createElement('div');
            div1.className = "alt box";
            
            var div2 = document.createElement('div');
            div2.classList.add("container");
            
            var div3 = document.createElement('div');
            div2.classList.add("row");
            
            var div4 = document.createElement('div');
            div2.classList.add("col-11");
            
            var div5 = document.createElement('div');
            var h1 = document.createElement('h3');
            h1.style.cssText = 'float: left;margin-right: 70px;';
            h1.innerHTML = "STRING HERE"
            var h2 = document.createElement('h4');
            h2.innerHTML = "STAR HERE" + "&#9734";
            div5.appendChild(h1);
            div5.appendChild(h2);
            
            var div6 = document.createElement('div');
            div6.classList.add("mt50");
            var h3 =  document.createElement('h4');
            h3.style.cssText = 'float: left;margin-right: 70px;';
            h3.innerHTML = "Prep Time: " + "PREP HERE";
            var clear = document.createElement('div');
            clear.style.clear = "both";
            div6.appendChild(h3);
            div6.appendChild(clear);
            
            div4.appendChild(div5);
            div4.appendChild(div6);
            
            var div7 = document.createElement('div');
            div7.className = " col-1 mt50";
            var dollar = document.createElement('h3');
            dollar.innerHTML = "DOLLAR";
            
            div3.appendChild(div4);
            div3.appendChild(div7);
            
            div2.appendChild(div3);
            div1.appendChild(div2);
            
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
                        <img src="img/hamburgers.jpg" class="googleImage rt-25" id="1">
                        <img src="img/hamburgers.jpg" class="googleImage rt-25" id="2">
                        <img src="img/hamburgers.jpg" class="googleImage rt45" id="3">
                        <img src="img/hamburgers.jpg" class="googleImage rt-35" id="4">
                        <img src="img/hamburgers.jpg" class="googleImage rt45" id="5">
                    </div>
                    <div class="row">
                        <img src="img/hamburgers.jpg" class="googleImage rt-15" id="6">
                        <img src="img/hamburgers.jpg" class="googleImage rt35" id="7">
                        <img src="img/hamburgers.jpg" class="googleImage rt-35" id="8">
                        <img src="img/hamburgers.jpg" class="googleImage rt35" id="9">
                        <img src="img/hamburgers.jpg" class="googleImage rt-15" id="10">
                    </div>
                </div>
            </div>
            <!-- navbar -->
            <div class="col-3" style="padding-top: 50px;">
                <form action="" method="get">
                    <div class="mt-20">
                        <select name="list" class="btn bg-secondary wth">
                            <option value="nil" selected>_______________________</option>
                            <option value="Favorite">Favorite List</option>
                            <option value="ToExplore">To Explore List</option>
                            <option value="DoNotShow">Do Not Show List</option>
                        </select>
                    </div>
                    <div class="mt-20">
                        <button class="btn btn-secondary wth" type="submit">Manage List</button>
                    </div>
                </form>

                <div class="mt-20">
                    <button class="btn btn-secondary wth">Return to Search</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 text-center">
                <h1>
                    Search Results for 'Hamburger'
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-6">
                <h2 class="text-center"><u>Restaurant</u></h2>
                <!-- restaurant -->
                
                
          <!-- 
          
           -->
                
                <div class="alt box">
                    <div class="container">
                        <div class="row">
                            <div class="col-11">
                                <div>
                                    <h3 style="float: left;margin-right: 70px;">The Habit Burger Grill</h3>
                                    <h4>5 &#9734;</h4>
                                </div>
                                <div class="mt50">
                                    <h4 style="float: left;margin-right: 70px;">Prep Time: 5 mins</h4>
                                    <div style="clear:both"></div>
                                </div>
                            </div>
                            <div class="col-1 mt50">
                                <h3>$$</h3>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <!-- end of restaurant -->
                <div class="box">
                    <div class="container">
                        <div class="row">
                            <div class="col-11">
                                <div>
                                    <h3 style="float: left;margin-right: 70px;">The Habit Burger Grill</h3>
                                    <h4>5 &#9734;</h4>
                                </div>
                                <div class="mt50">
                                    <h4 style="float: left;margin-right: 70px;">Prep Time: 5 mins</h4>
                                    <div style="clear:both"></div>
                                </div>
                            </div>
                            <div class="col-1 mt50">
                                <h3>$$</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- recipe -->

            <div class="col-12 col-md-6">
                <h2 class="text-center"><u>Recipe</u></h2>
                <div class="box">
                    <div class="container">
                        <div class="row">
                            <div class="col-11">
                                <div>
                                    <h3 style="float: left;margin-right: 70px;">The Habit Burger Grill</h3>
                                    <h4>5 &#9734;</h4>
                                </div>
                                <div class="mt50">
                                    <h4 style="float: left;margin-right: 20px;">Prep Time: 5 mins</h4>
                                    <h4>Cook Time: 10 mins</h4>
                                    <div style="clear:both"></div>
                                </div>
                            </div>
                            <div class="col-1 mt-20">
                                <h3>$$</h3>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end of recipe -->
                <div class="alt box">
                    <div class="container">
                        <div class="row">
                            <div class="col-11">
                                <div>
                                    <h3 style="float: left;margin-right: 70px;">The Habit Burger Grill</h3>
                                    <h4>5 &#9734;</h4>
                                </div>
                                <div class="mt50">
                                    <h4 style="float: left;margin-right: 20px;">Prep Time: 5 mins</h4>
                                    <h4>Cook Time: 10 mins</h4>
                                    <div style="clear:both"></div>
                                </div>
                            </div>
                            <div class="col-1 mt-20">
                                <h3>$$</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>
