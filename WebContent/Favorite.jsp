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
    
    <script>
    	console.log('<%= session.getAttribute("favRes") %>');
	    var restaurant = JSON.parse('<%= session.getAttribute("favRes") %>');
	    console.log(restaurant);
    
    
    </script>



</head>

<body>

    <div class="container-fluid">
        <div class="row ">
            <div class="col-10">
                <div class="listTitle  text-center" style="margin-bottom: 150px;">Favorites List</div>
                <!-- content -->
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-10">
                            <!-- -->
                            <div class="alt box">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-10">
                                            <div>
                                                <h3>
                                                    The Habit Burger Grill
                                                </h3>
                                            </div>
                                            <div class="mt50">
                                                <h4>Distance: 2km</h4>
                                            </div>
                                        </div>
                                        <div class="col-2 mt50">
                                            <h3>$5 - $9</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- -->
                        </div>
                        <div class="col-2 mt-20">
                            <div>
                                <button class="btn btn-primary wth">Remove</button>
                            </div>
                            <div class="mt-10">
                                <button class="btn btn-primary wth">Move To...</button>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-10">
                            <!-- -->
                            <div class="box">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-10">
                                            <div>
                                                <h3>
                                                    The Habit Burger Grill
                                                </h3>
                                            </div>
                                            <div class="mt50">
                                                <h4>Distance: 2km</h4>
                                            </div>
                                        </div>
                                        <div class="col-2 mt50">
                                            <h3>$5 - $9</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- -->
                        </div>
                        <div class="col-2 mt-20">
                            <div>
                                <button class="btn btn-primary wth">Remove</button>
                            </div>
                            <div class="mt-10">
                                <button class="btn btn-primary wth">Move To...</button>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-10">
                            <!-- -->
                            <div class=" alt box">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-10">
                                            <div>
                                                <h3>
                                                    The Habit Burger Grill
                                                </h3>
                                            </div>
                                            <div class="mt50">
                                                <h4 style="float: left;margin-right: 70px;">Prep Time: 5 mins</h4>
                                                <h4>Cook Time: 10 mins</h4>
                                                <div style="clear:both"></div>
                                            </div>
                                        </div>
                                        <div class="col-2 mt-20">
                                            <h3>$5 - $9</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- -->
                        </div>
                        <div class="col-2 mt-20">
                            <div>
                                <button class="btn btn-primary wth">Remove</button>
                            </div>
                            <div class="mt-10">
                                <button class="btn btn-primary wth">Move To...</button>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-10">
                            <!-- -->
                            <div class="box">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-10">
                                            <div>
                                                <h3>
                                                    The Habit Burger Grill
                                                </h3>
                                            </div>
                                            <div class="mt50">
                                                <h4 style="float: left;margin-right: 70px;">Prep Time: 5 mins</h4>
                                                <h4>Cook Time: 10 mins</h4>
                                                <div style="clear:both"></div>
                                            </div>
                                        </div>
                                        <div class="col-2 mt-20">
                                            <h3>$5 - $9</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- -->
                        </div>
                        <div class="col-2 mt-20">
                            <div>
                                <button class="btn btn-primary wth">Remove</button>
                            </div>
                            <div class="mt-10">
                                <button class="btn btn-primary wth">Move To...</button>
                            </div>
                        </div>
                    </div>


                </div>



                <!-- end of content-->
            </div>
            <div col="col-2">
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
                    <button class="btn btn-secondary wth">Back to Results</button>
                </div>
                <div class="mt-20">
                    <button class="btn btn-secondary wth">Return to Search</button>
                </div>

            </div>
        </div>


    </div>

</body>

</html>