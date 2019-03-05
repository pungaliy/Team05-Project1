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

            restaurant = '<%= session.getAttribute("restaurantResults") %>';
            recipe = '<%= session.getAttribute("recipeResults") %>';
            url = '<%= session.getAttribute("imageURLs") %>';
            user = '<%= session.getAttribute("user") %>';

            console.log(restaurant);
            console.log(recipe);
            console.log(url);
            console.log(user);
        
            var min = 0;
            var max = 8;
            var ran = 0

            //set random angle to images
            for (let i = 1; i < 11; i++) {
                ran = Math.floor(Math.random() * (+max - +min)) + +min;
                setAngel(ran, i);
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