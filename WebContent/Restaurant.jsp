<!DOCTYPE html><html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Restaurant</title>

    <!-- maxcdn -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- style  -->
    <link href="./css/main.css?version=5" rel="stylesheet">


</head>

<body>

    <div class="container-fluid">
        <div class="row ">
            <div class="col-10">
                <div class="listTitle" style="margin-bottom: 50px;" id="title"></div>
                <!-- content -->
                <div style="font-size: 40px;">
                    <div class="mt-20" id="phone">
                       
                    </div>
                    <div class="mt-20" style="width: 300px;font-size: 18px;">
                    	<h3>Website:</h3>
                        <a id="link" href=""></a>
                    </div>
                    <div class="mt-20" style="width: 300px;font-size: 18px;">
                    	<h3>Address:</h3>
                      <a href="" id="address">
                      	
                      </a>
                    </div>
                </div>


            </div>



            <!-- end of content-->

            <div col="col-2">
                <div class="mt-20">
                    <button class="btn btn-secondary wth">Printable View</button>
                </div>
                <div class="mt-20">
                    <button class="btn btn-secondary wth">Back to Results</button>
                </div>
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
                        <button class="btn btn-secondary wth" type="submit">Add to List</button>
                    </div>
                </form>

            </div>
        </div>


    </div>
    
    <script>
	
		var link = window.location.href;
		var url = new URL(link);
		var id = url.searchParams.get("id");
		console.log(id)
		
		var restaurant = JSON.parse('<%= session.getAttribute("restaurantResults") %>');
		var current;
		for(var i = 0; i < restaurant.length; i++){
			if(restaurant[i].uniqueID == id){
				current = restaurant[i];
			}
		}
		console.log(current);
		
		document.getElementById('title').innerHTML = current.name;
		document.getElementById('phone').innerHTML = current.phoneNumber;
		document.getElementById('link').href = current.websiteLink;
		document.getElementById('link').innerHTML = current.websiteLink;
		document.getElementById('address').href = current.googleMapsLink;
		document.getElementById('address').innerHTML = current.address;

	
	</script>

</body>

</html>
