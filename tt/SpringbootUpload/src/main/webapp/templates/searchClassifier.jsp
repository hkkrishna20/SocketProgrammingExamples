<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="https://raw.githubusercontent.com/twbs/bootstrap/master/docs/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="https://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs/dt-1.10.18/datatables.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/responsive/2.2.2/js/dataTables.responsive.min.js"></script>
<script
	src="https://cdn.datatables.net/responsive/2.2.2/js/responsive.bootstrap4.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.flash.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" />
<link
	href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css" />
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&subset=latin-ext"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css" />

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs/dt-1.10.18/datatables.min.css" />


<title>Search Classifier</title>
<style>
@import
	url('https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i')
	;
#wrapper{
    overflow:auto;
   
}

.inner_div{
    float:left;
    width:25%;
}
.dataTables_paginate{
display:flex;
align-items:left!important;
 float: center !important;
}
.dataTables_paginate a{
   color: black;
    display: block !important;
    float: left !important;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
}​

.dataTables_paginate a.active {
    background-color: #4CAF50;
    color: white;
}
.dataTables_paginate a:hover:not(.active) {background-color: #ddd;}
html, body {
	margin: 0px;
	padding: 0px;
 box-sizing: border-box;
 	max-height: 100%;

}


.dataTables_filter input {
    -webkit-appearance: button;
    -webkit-border-radius: 2px;
    -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
    -webkit-padding-end: 20px;
    -webkit-padding-start: 2px;
    -webkit-user-select: none;
    background-position: 97% center;
    background-repeat: no-repeat;
    border: 1px solid #AAA;
    font-size: inherit;
    margin: 20px;
    overflow: hidden;
    padding: 5px 10px;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 300px;
    color: #0000FF;
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;
    padding-left: 15px;
}

.dataTables_length select {
  	 font: 400 12px/1.3 "Helvetica Neue", sans-serif;
  -webkit-appearance: none;
  appearance: none;
  border: 2px solid hotpink;
  line-height: 1;
  outline: 0;
  border-color: hotpink;
  padding: 0.65em 2.5em 0.55em 0.75em;
  border-radius: 3px;
  background: linear-gradient(hotpink, hotpink) no-repeat,
              linear-gradient(-135deg, rgba(255,255,255,0) 50%, white 50%) no-repeat,
              linear-gradient(-225deg, rgba(255,255,255,0) 50%, white 50%) no-repeat,
              linear-gradient(hotpink, hotpink) no-repeat;
  background-size: 1px 100%, 20px 20px, 20px 20px, 20px 60%;
  background-position: right 20px center, right bottom, right bottom, right bottom;  
}

.dataTables_filter input {
	-webkit-appearance: button;
   -webkit-border-radius: 2px;
   -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
   -webkit-padding-end: 20px;
   -webkit-padding-start: 2px;
   -webkit-user-select: none;
   background-position: 97% center;
   background-repeat: no-repeat;
   border: 1px solid #AAA;
   color: #555;
   font-size: inherit;
   margin: 20px;
   overflow: hidden;
   padding: 5px 10px;
   text-overflow: ellipsis;
   white-space: nowrap;
   width: 300px;
   color: #fff;
   -webkit-border-radius: 20px;
   -moz-border-radius: 20px;
   border-radius: 20px;
   padding-left: 15px;
   
}
.dataTables_info {
    background-color: ;
}

body {
	font-family: 'Roboto', sans-serif !important;
	font-weight: 500 !important;
	font: 16px;
}

.autocomplete {
	/*the container must be positioned relative:*/
	position: relative;
	display: inline-block;
}

.custom-select {
	position: relative;
	font-family: Arial;
}

.custom-select select {
	display: none; /*hide original SELECT element:*/
}

.select-selected {
	background-color: DodgerBlue;
}
/*style the arrow inside the select element:*/
.select-selected:after {
	position: absolute;
	content: "";
	top: 14px;
	right: 10px;
	width: 0;
	height: 0;
	border: 6px solid transparent;
	border-color: #fff transparent transparent transparent;
}
/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
	border-color: transparent transparent #fff transparent;
	top: 7px;
}

.autocomplete {
	/*the container must be positioned relative:*/
	position: relative;
	display: inline-block;
}

input {
	border: 1px solid transparent;
	background-color: #f1f1f1;
	padding: 10px;
	font-size: 16px;
}

input[type=text] {
	background-color: #f1f1f1;
	width: 100%;
}

input[type=submit] {
	background-color: DodgerBlue;
	color: #fff;
	cursor: pointer;
}

.autocomplete-items {
	position: absolute;
	border: 1px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

.autocomplete-items div:hover {
	/*when hovering an item:*/
	background-color: #e9e9e9;
}

.autocomplete-active {
	/*when navigating through the items using the arrow keys:*/
	background-color: DodgerBlue !important;
	color: #ffffff;
}

div.background {
	border: 1px solid white;
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	width: 100%;
	margin: auto;
	padding-top: 2%;
	padding-left: 2%;
}

select.form-control.input-sm {
	background: #00a1ff !important;
	border: 0px !important;
	border-radius: 0px !important;
	color: #FFF !important;
	font-weight: 500 !important;
	font-size: 13px !important;
	font-family: 'Roboto', sans-serif;
	-webkit-box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
	-moz-box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
	box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
}

.pagination>li>a, .pagination>li>span {
	background: #00a1ff !important;
	border: 0px !important;
	border-radius: 0px !important;
	color: #FFF !important;
	font-weight: 500 !important;
	font-size: 13px !important;
	font-family: 'Roboto', sans-serif;
	-webkit-box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
	-moz-box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
	box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
}

.table-striped>tbody>tr:nth-of-type(odd) {
	background-color: #00a1ff !important;
	color: #FFF !important;
	font-size: 13px !important;
	font-family: 'Roboto', sans-serif;
	font-weight: 500 !important;
}

table {
  table-layout:fixed;
}
table td {
  word-wrap: break-word;
  max-width: 400px;
}
tr.even {
	background: #bfbfbf !important;
	color: #000 !important;
	font-size: 13px !important;
	font-weight: 500 !important;
	font-family: 'Roboto', sans-serif;
}

th.sorting, .sorting_asc {
	font-family: 'Roboto', sans-serif;
	font-weight: 500 !important;
	border: 1px solid #93CE37;
	border-bottom: 3px solid #9ED929;
	background: rgb(48, 179, 255); /* Old browsers */
	background: -moz-linear-gradient(top, rgba(48, 179, 255, 1) 0%,
		rgba(0, 161, 255, 1) 100%); /* FF3.6-15 */
	background: -webkit-linear-gradient(top, rgba(48, 179, 255, 1) 0%,
		rgba(0, 161, 255, 1) 100%); /* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to bottom, rgba(48, 179, 255, 1) 0%,
		rgba(0, 161, 255, 1) 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#30b3ff',
		endColorstr='#00a1ff', GradientType=0); /* IE6-9 */
	-webkit-border-top-left-radius: 5px;
	-webkit-border-top-right-radius: 5px;
	-moz-border-radius: 5px 5px 0px 0px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

table#table {
	border: 0px !important;
}

input.form-control.input-sm {
	background: #00a1ff !important;
	border: 0px !important;
	border-radius: 0px !important;
	color: #FFF !important;
	font-weight: 500 !important;
	font-size: 13px !important;
	font-family: 'Roboto', sans-serif;
	-webkit-box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
	-moz-box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
	box-shadow: 0px 0px 18px 0px rgba(0, 0, 0, 0.18);
}

/*style the items (options), including the selected item:*/
.select-items div, .select-selected {
	color: #ffffff;
	padding: 8px 16px;
	border: 1px solid transparent;
	border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
	cursor: pointer;
}
/*style items (options):*/
.select-items {
	position: absolute;
	background-color: DodgerBlue;
	top: 100%;
	left: 0;
	right: 0;
	z-index: 99;
}
/*hide the items when the select box is closed:*/
.select-hide {
	display: none;
}
table.dataTable thead .sorting_asc_disabled:after,
table.dataTable thead .sorting_desc_disabled:after {
    color: #eee;
}
 
table.dataTable thead .sorting:after {
  opacity: 0.2;
  content: "\e150";
  /* sort */
}
table.dataTable thead .sorting_asc:after {
  content: "\e155";
  /* sort-by-attributes */
}
table.dataTable thead .sorting_desc:after {
  content: "\e156";
  /* sort-by-attributes-alt */
}
.select-items div:hover, .same-as-selected {
	background-color: rgba(0, 0, 0, 0.1);
}

.navbar, .dropdown-menu {
	background-color: #CC3333;
	/* background: rgba(255, 255, 255, 0.25); */
	border: none;
}

.nav>li>a, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover,
	.dropdown-menu>li>a, .dropdown-menu>li {
	border-bottom: 3px solid transparent;
}

.nav>li>a:focus, .nav>li>a:hover, .nav .open>a, .nav .open>a:focus, .nav .open>a:hover,
	.dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover {
	border-bottom: 3px solid transparent;
	background: none;
}

.navbar a, .dropdown-menu>li>a, .dropdown-menu>li>a:focus,
	.dropdown-menu>li>a:hover, .navbar-toggle {
	color: #fff;
}

.dropdown-menu {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.nav li:hover:nth-child(8n+1), .nav li.active:nth-child(8n+1) {
	border-bottom: #C4E17F 3px solid;
}

.nav li:hover:nth-child(8n+2), .nav li.active:nth-child(8n+2) {
	border-bottom: #F7FDCA 3px solid;
}

.nav li:hover:nth-child(8n+3), .nav li.active:nth-child(8n+3) {
	border-bottom: #FECF71 3px solid;
}

.nav li:hover:nth-child(8n+4), .nav li.active:nth-child(8n+4) {
	border-bottom: #F0776C 3px solid;
}

.nav li:hover:nth-child(8n+5), .nav li.active:nth-child(8n+5) {
	border-bottom: #DB9DBE 3px solid;
}

.nav li:hover:nth-child(8n+6), .nav li.active:nth-child(8n+6) {
	border-bottom: #C49CDE 3px solid;
}

.nav li:hover:nth-child(8n+7), .nav li.active:nth-child(8n+7) {
	border-bottom: #669AE1 3px solid;
}

.nav li:hover:nth-child(8n+8), .nav li.active:nth-child(8n+8) {
	border-bottom: #62C2E4 3px solid;
}

.navbar-toggle .icon-bar {
	color: #fff;
	background: #fff;
}
/* TOP HEADER
-------------------------------------------------- */
.navbar.top-bar {
	border-radius: 0;
	padding: 16px 0;
	z-index: 16;
	background-color: #CC3333;
}

.navbar-toggler {
	border: 1px solid #fff;
	color: #eee;
	position: absolute;
	right: 21px;
}

.sps {
	padding: 1em .5em;
	position: fixed;
	top: 0;
	left: 0;
	transition: all 0.25s ease;
	width: 100%;
}

.sps--abv {
	background-color: transparent;
	color: #000;
}

.sps--blw {
	background-color: #fff;
	color: #fff;
}

.top-bar a.navbar-brand {
	color: #fff;
	font-size: 26px;
	font-weight: 800;
	padding: 5px 0 0 10px;
	text-transform: uppercase;
}

.sps--blw.top-bar a.navbar-brand {
	color: #000;
}

.top-bar a.navbar-brand span {
	color: #0297ff;
}

.top-bar .nav-link {
	color: #fff;
	font-size: 16px;
	font-weight: 500;
	padding: 12px 18px !important;
}

.sps--blw.top-bar .nav-link {
	color: #000
}

.top-bar .navbar-nav .nav-item {
	margin: 0
}

.top-bar .nav-link:hover, .top-bar .nav-item.active a {
	color: #fff;
	border-bottom: 2px solid #fff;
	border-radius: 0;
}

.sps--blw.top-bar .nav-link:hover, .sps--blw.top-bar .nav-item.active a
	{
	color: #0297ff;
	border-bottom: none;
	border-radius: 0;
}

#footer {
	background-color: #696969;
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 100px;
}

#footer h5 {
	padding-left: 10px;
	border-left: 3px solid #eeeeee;
	padding-bottom: 6px;
	margin-bottom: 20px;
	color: #ffffff;
}

#footer a {
	color: #ffffff;
	text-decoration: none !important;
	background-color: transparent;
	-webkit-text-decoration-skip: objects;
}

#footer ul.social li {
	padding: 3px 0;
}

#footer ul.social li a i {
	margin-right: 5px;
	font-size: 25px;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

#footer ul.social li:hover a i {
	font-size: 30px;
	margin-top: -10px;
}

#footer ul.social li a, #footer ul.quick-links li a {
	color: #ffffff;
}

#footer ul.social li a:hover {
	color: #eeeeee;
}

#footer ul.quick-links li {
	padding: 3px 0;
	-webkit-transition: .5s all ease;
	-moz-transition: .5s all ease;
	transition: .5s all ease;
}

#footer ul.quick-links li:hover {
	padding: 3px 0;
	margin-left: 5px;
	font-weight: 700;
}

#footer ul.quick-links li a i {
	margin-right: 5px;
}

#footer ul.quick-links li:hover a i {
	font-weight: 700;
}

@media ( max-width :767px) {
	#footer h5 {
		padding-left: 0;
		border-left: transparent;
		padding-bottom: 10px;
		margin-bottom: 10px;
	}
}

div.fixed {
	position: fixed;
	bottom: 0;
	right: 0;
	left: 100%;
	border: 3px solid #73AD21;
}
</style>
<script>
	function autocomplete(inp, arr) {
		/*the autocomplete function takes two arguments,
		the text field element and an array of possible autocompleted values:*/
		var currentFocus;
		/*execute a function when someone writes in the text field:*/
		inp
				.addEventListener(
						"input",
						function(e) {
							var a, b, i, val = this.value;
							/*close any already open lists of autocompleted values*/
							closeAllLists();
							if (!val) {
								return false;
							}
							currentFocus = -1;
							/*create a DIV element that will contain the items (values):*/
							a = document.createElement("DIV");
							a.setAttribute("id", this.id + "autocomplete-list");
							a.setAttribute("class", "autocomplete-items");
							/*append the DIV element as a child of the autocomplete container:*/
							this.parentNode.appendChild(a);
							/*for each item in the array...*/
							for (i = 0; i < arr.length; i++) {
								/*check if the item starts with the same letters as the text field value:*/
								if (arr[i].substr(0, val.length).toUpperCase() == val
										.toUpperCase()) {
									/*create a DIV element for each matching element:*/
									b = document.createElement("DIV");
									/*make the matching letters bold:*/
									b.innerHTML = "<strong>"
											+ arr[i].substr(0, val.length)
											+ "</strong>";
									b.innerHTML += arr[i].substr(val.length);
									/*insert a input field that will hold the current array item's value:*/
									b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
									/*execute a function when someone clicks on the item value (DIV element):*/
									b
											.addEventListener(
													"click",
													function(e) {
														/*insert the value for the autocomplete text field:*/
														inp.value = this
																.getElementsByTagName("input")[0].value;
														/*close the list of autocompleted values,
														(or any other open lists of autocompleted values:*/
														closeAllLists();
													});
									a.appendChild(b);
								}
							}
						});
		/*execute a function presses a key on the keyboard:*/
		inp.addEventListener("keydown", function(e) {
			var x = document.getElementById(this.id + "autocomplete-list");
			if (x)
				x = x.getElementsByTagName("div");
			if (e.keyCode == 40) {
				/*If the arrow DOWN key is pressed,
				increase the currentFocus variable:*/
				currentFocus++;
				/*and and make the current item more visible:*/
				addActive(x);
			} else if (e.keyCode == 38) { //up
				/*If the arrow UP key is pressed,
				decrease the currentFocus variable:*/
				currentFocus--;
				/*and and make the current item more visible:*/
				addActive(x);
			} else if (e.keyCode == 13) {
				/*If the ENTER key is pressed, prevent the form from being submitted,*/
				e.preventDefault();
				if (currentFocus > -1) {
					/*and simulate a click on the "active" item:*/
					if (x)
						x[currentFocus].click();
				}
			}
		});
		function addActive(x) {
			/*a function to classify an item as "active":*/
			if (!x)
				return false;
			/*start by removing the "active" class on all items:*/
			removeActive(x);
			if (currentFocus >= x.length)
				currentFocus = 0;
			if (currentFocus < 0)
				currentFocus = (x.length - 1);
			/*add class "autocomplete-active":*/
			x[currentFocus].classList.add("autocomplete-active");
		}
		function removeActive(x) {
			/*a function to remove the "active" class from all autocomplete items:*/
			for (var i = 0; i < x.length; i++) {
				x[i].classList.remove("autocomplete-active");
			}
		}
		function closeAllLists(elmnt) {
			/*close all autocomplete lists in the document,
			except the one passed as an argument:*/
			var x = document.getElementsByClassName("autocomplete-items");
			for (var i = 0; i < x.length; i++) {
				if (elmnt != x[i] && elmnt != inp) {
					x[i].parentNode.removeChild(x[i]);
				}
			}
		}
		/*execute a function when someone clicks in the document:*/
		document.addEventListener("click", function(e) {
			closeAllLists(e.target);
		});
	}

	/*An array containing all the fungiCAZymes names :*/
	var fungiCAZymes = [ "AA2_cyt", "AA", "AA10", "AA11", "AA11_dist", "AA12",
			"AA12_dist", "AA13", "AA14", "AA1", "AA1_1", "AA1_2", "AA1_3",
			"AA1_dist", "AA2", "AA2_dist", "AA3", "AA3_1", "AA3_2", "AA3_3",
			"AA3_4", "AA3_dist", "AA4", "AA5", "AA5_1", "AA5_2", "AA5_dist",
			"AA6", "AA7", "AA7_dist", "AA8", "AA8_dist", "AA9", "AA9_dist",
			"CBM", "CBM10", "CBM12", "CBM13", "CBM14", "CBM16", "CBM18",
			"CBM19", "CBM1", "CBM20", "CBM21", "CBM22", "CBM24", "CBM25",
			"CBM26", "CBM29", "CBM2", "CBM32", "CBM35", "CBM38", "CBM3",
			"CBM42", "CBM43", "CBM48", "CBM4", "CBM50", "CBM51", "CBM52",
			"CBM5", "CBM61", "CBM63", "CBM66", "CBM67", "CBM6", "CBM71",
			"CBM8", "CBM9", "CE", "CE11", "CE12", "CE13", "CE14", "CE15",
			"CE16", "CE1", "CE2", "CE3", "CE4", "CE5", "CE6", "CE7", "CE8",
			"CE9", "DOC", "DOC2", "EXPN", "GH", "GH103", "GH105", "GH106",
			"GH108", "GH10", "GH110", "GH114", "GH115", "GH116", "GH11",
			"GH120", "GH121", "GH124", "GH125", "GH127", "GH128", "GH12",
			"GH130", "GH131", "GH132", "GH133", "GH134", "GH135", "GH136",
			"GH139", "GH13", "GH13_10", "GH13_11", "GH13_14", "GH13_15",
			"GH13_1", "GH13_20", "GH13_22", "GH13_23", "GH13_25", "GH13_26",
			"GH13_28", "GH13_30", "GH13_31", "GH13_32", "GH13_37", "GH13_3",
			"GH13_40", "GH13_4", "GH13_5", "GH13_6", "GH13_8", "GH13_dist",
			"GH13_m42", "GH13_m46", "GH140", "GH141", "GH142", "GH143",
			"GH145", "GH146", "GH14", "GH151", "GH152", "GH15", "GH16", "GH17",
			"GH18", "GH19", "GH1", "GH20", "GH23", "GH24", "GH25", "GH26",
			"GH27", "GH28", "GH29", "GH2", "GH30", "GH30_1", "GH30_3",
			"GH30_5", "GH30_7", "GH30_dist", "GH31", "GH32", "GH33", "GH35",
			"GH36", "GH37", "GH38", "GH39", "GH3", "GH42", "GH43", "GH44",
			"GH45", "GH46", "GH47", "GH48", "GH49", "GH4", "GH51", "GH52",
			"GH53", "GH54", "GH55", "GH57", "GH5", "GH5_11", "GH5_12",
			"GH5_13", "GH5_15", "GH5_16", "GH5_1", "GH5_22", "GH5_23",
			"GH5_24", "GH5_27", "GH5_28", "GH5_2", "GH5_30", "GH5_31",
			"GH5_34", "GH5_36", "GH5_40", "GH5_41", "GH5_49", "GH5_4",
			"GH5_50", "GH5_51", "GH5_5", "GH5_7", "GH5_8", "GH5_9", "GH5_dist",
			"GH62", "GH63", "GH64", "GH65", "GH67", "GH6", "GH71", "GH72",
			"GH73", "GH74", "GH75", "GH76", "GH77", "GH78", "GH79", "GH7",
			"GH81", "GH84", "GH85", "GH88", "GH89", "GH8", "GH91", "GH92",
			"GH93", "GH94", "GH95", "GH97", "GH99", "GH9", "GT", "GT101",
			"GT10", "GT11", "GT12", "GT13", "GT14", "GT15", "GT17", "GT18",
			"GT1", "GT20", "GT21", "GT22", "GT23", "GT24", "GT25", "GT28",
			"GT2", "GT31", "GT32", "GT33", "GT34", "GT35", "GT37", "GT39",
			"GT3", "GT41", "GT43", "GT45", "GT47", "GT48", "GT49", "GT4",
			"GT50", "GT51", "GT54", "GT55", "GT57", "GT58", "GT59", "GT5",
			"GT60", "GT61", "GT62", "GT64", "GT65", "GT66", "GT68", "GT69",
			"GT6", "GT71", "GT76", "GT77", "GT7", "GT81", "GT8", "GT90",
			"GT91", "GT9", "Myosin_motor", "PL", "PL10", "PL10_dist", "PL11",
			"PL11_2", "PL14", "PL14_1", "PL14_3", "PL14_4", "PL14_5",
			"PL14_dist", "PL15", "PL15_dist", "PL1", "PL1_10", "PL1_2",
			"PL1_4", "PL1_6", "PL1_7", "PL1_9", "PL1_dist", "PL20",
			"PL20_dist", "PL22", "PL22_2", "PL26", "PL27", "PL3", "PL3_2",
			"PL3_dist", "PL4", "PL4_1", "PL4_3", "PL4_5", "PL4_dist", "PL7",
			"PL7_4", "PL7_dist", "PL8", "PL8_4", "PL9", "PL9_1", "PL9_3","Cellulose Degrading","Hemicellulose Degrading","Lignin Degrading","Pectin Degrading","Starch Degrading","Inulin" ];
	$( window ).resize(function() {
		  footerAlign();
		});	
	function footerAlign() {
		  $('footer').css('display', 'block');
		  $('footer').css('height', 'auto');
		  var footerHeight = $('footer').outerHeight();
		  $('body').css('padding-bottom', footerHeight);
		  $('footer').css('height', footerHeight);
		}


	$(document)
			.ready(
					function() {
						 footerAlign();
						$("#myInputIdButton")
								.click(
										function() {
											var orderCriteria = $(
													"#orderCriteria").val();
											var myInput = $("#myInput").val();
											var Url = 'searchClassifier/'
													+ orderCriteria + '/'
													+ myInput;
											$
													.ajax({
														type : "GET",
														url : Url,
														async : false,
														dataType : "json",
														headers : {
															'Accept' : 'application/json',
															'Content-Type' : 'text/plain'
														},
														success : function(
																response) {
															var result = jQuery
																	.parseJSON(JSON
																			.stringify(response));
														/* 	alert(JSON
																	.stringify(response)); */
															var col = [];
															for (var i = 0; i < result.length; i++) {
																for ( var key in result[i]) {
																	if (col
																			.indexOf(key) === -1) {
																		col
																				.push(key);
																	}
																}
															}
															var table = document
																	.createElement("table");
															table.setAttribute(
																	'id',
																	'table');
															// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
															var thead = document
																	.createElement("thead");
															table
																	.appendChild(thead);
															var tr = document
																	.createElement("tr");
															thead
																	.appendChild(tr)// TABLE ROW.
															var th0 = document
																	.createElement("th");
															th0.innerHTML = "SL.NO";
															tr.appendChild(th0);
															for (var i = 0; i < col.length; i++) {
																var th = document
																		.createElement("th");

																var string = col[i];
																var newString = string
																		.indexOf('_') == 0 ? string
																		.substring(1)
																		: string;
																th.innerHTML = newString;
																tr
																		.appendChild(th);
															}
															// ADD JSON DATA TO THE TABLE AS ROWS.
															var tbody = document
																	.createElement("tbody");

															for (var i = 0; i < result.length; i++) {
																var tr1 = document
																		.createElement("tr");
																var td0 = document
																		.createElement("td");
																td0.innerHTML = "0";

																tr1
																		.appendChild(td0);
																for (var j = 0; j < col.length; j++) {
																	var td = document
																			.createElement("td");
																	td.innerHTML = result[i][col[j]];

																	tr1
																			.appendChild(td);

																}
																tbody
																		.appendChild(tr1);

															}
															table
																	.appendChild(tbody);

															// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
															var divContainer = document
																	.getElementById("ajaxGetUserServletResponse");
															divContainer.innerHTML = "";
															divContainer
																	.appendChild(table);
															var t = $('#table')
																	.DataTable(
																			{
																				"fixedHeader" : {
																					"header" : true,
																					"footer" : false
																				},
																				"autoWidth": true,
																				"processing" : true,
																				"fixedColumns" : {
																					"leftColumns" : 1,
																					"rightColumns" : 1
																				},
																				"sScrollY" : true,
																				"scrollX" : true,
																				"scrollCollapse" : true, 
																				"scrollY":        '50vh',
																				"scrollX": true,
																				"lengthMenu" : [
																						[
																								10,
																								25,
																								50,
																								100,
																								200,
																								-1 ],
																						[
																								10,
																								25,
																								50,
																								100,
																								200,
																								"All" ] ],
																				dom : 'lBfrtip',
																				buttons : [
																						/* 'pageLength', */
																						{
																							extend : 'copy',
																							className : 'btn btn-primary red glyphicon glyphicon-duplicate'
																						},
																						{
																							extend : 'csv',
																							className : 'btn btn-primary orange  glyphicon glyphicon-save-file'
																						},
																						{
																							extend : 'excel',
																							className : 'btn btn-primary green glyphicon glyphicon-list-alt'
																						},
																						{
																							extend : 'pdf',
																							className : 'btn btn-primary glyphicon glyphicon-file'
																						},
																						{
																							extend : 'print',
																							className : 'btn btn-primary glyphicon glyphicon-print'
																						} ],
																						
																					           
																				"order" : [ [
																						1,
																						'asc' ] ]
															/* 					,
																				 responsive: {
																			            details: {
																			                display: $.fn.dataTable.Responsive.display.modal( {
																			                    header: function ( row ) {
																			                        var data = row.data();
																			                        return 'Details for '+data[0]+' '+data[1];
																			                    }
																			                } ), 
																			                renderer: $.fn.dataTable.Responsive.renderer.tableAll( {
																			                    tableClass: 'table'
																			                } )
																			            }
																			        }
 */																			});   

															t
																	.on(
																			'order.dt search.dt',
																			function() {
																				t
																						.column(
																								0,
																								{
																									search : 'applied',
																									order : 'applied'
																								})
																						.nodes()
																						.each(
																								function(
																										cell,
																										i) {
																									cell.innerHTML = i + 1;
																								});
																			})
																	.draw();
															
														}
													});
										});
					});
</script>
</head>
<nav
	class="navbar navbar-expand-lg mb-4 top-bar navbar-static-top sps sps--abv">
	<div class="container container-fluid">
		<a class="navbar-brand mx-auto" href="home">Ranking<span>Enzymes</span></a>
	</div>
</nav>
<div class="row"
	style="padding-top: 80px !important; padding-bottom: 25px !important; padding-left: 40px !important;">
</div>
<div class="wrapper container-fluid">
	<div class="row ">

		<div class="col-md-2 col-lg-2 col-sm-2 col-xs-2 inner_div">

			<!-- 			<form class="form-horizontal" id="searchCazymes-form"
					name="searchCazymes-form" role="form" autocomplete="off"
					 method="post">
	 -->
			<div style="margin-left: 2% !important;" class="autocomplete  absolute" role="menu">
				<div class="form-group ">
					<label for="filter">Order By</label> <select id="orderCriteria"
						name="orderCriteria" class="form-control">
						<option value="" selected>Choose here</option>
						<option value="asc">Ascending Order</option>
						<option value="desc">Descending Order</option>
					</select>
				</div>
				<div class="form-group">
					<label for="contain">Contains the words</label> <input id="myInput"
						class="form-control" type="text" name="cAzymes"
						placeholder="Search Genome" />
				</div>
				<div class="form-group">
					<input type="submit" id="myInputIdButton" name="myInputIdButton"
						class="btn btn-primary icon icon-search glyphicon glyphicon-search"
						aria-hidden="true" />
				</div>
			</div>
			<!-- 				</form>
 -->
		</div>
		<script>
			autocomplete(document.getElementById("myInput"), fungiCAZymes);
		</script>
		<div class="col-md-10 col-lg-10 col-sm-10 col-xs-10 inner_div " align="left">
			<div id="ajaxGetUserServletResponse"></div>
		</div>
	</div>
</div>
<div class="row"
	style="padding-top: 80px !important; padding-bottom: 25px !important; padding-left: 40px !important;">
</div>

<footer>
	<section id="footer" class="footer">
		<div class="container footer_contents">
			<div class="row text-center text-xs-center text-sm-left text-md-left">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<ul class="list-unstyled quick-links">
						<li><a href="team"><i class="home"></i>Team</a></li>
						<li><a href="about"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="metapage"><i class="about"></i>Metadata Page
								of Website</a></li>
						<li><a href="landInLogin"><i class="landInLogin"></i>Login</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<ul class="list-unstyled quick-links">
						<li><a href="team"><i class="home"></i>Team</a></li>
						<li><a href="about"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="metapage"><i class="about"></i>Metadata Page
								of Website</a></li>
						<li><a href="landInLogin"><i class="landInLogin"></i>Login</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<ul class="list-unstyled quick-links">
						<li><a href="team"><i class="home"></i>Team</a></li>
						<li><a href="about"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="metapage"><i class="about"></i>Metadata Page
								of Website</a></li>
						<li><a href="landInLogin"><i class="landInLogin"></i>Login</a></li>
					</ul>
				</div>
			</div>

			<div class="row" align="center">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4"></div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<div class="row" align="center">
						<ul class="list-unstyled list-inline social text-center">
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-facebook"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-twitter"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-instagram"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"><i
									class="fa fa-google-plus"></i></a></li>
							<li class="list-inline-item"><a href="javascript:void();"
								target="_blank"><i class="fa fa-envelope"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4"></div>
			</div>
		</div>

	</section>
	</footer>
</body>
</html>