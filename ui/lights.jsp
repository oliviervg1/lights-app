<script type="text/javascript">
$('#state').ready(function() {
	$.ajaxSetup({ cache: false }); // This part addresses an IE bug.  without it, IE will only load the first number and will never refresh
	setInterval(function() {
		$.ajax({
	        url: 'lights/getState.html',
	        success: function(data) {
	          $('#state').html(data);
	    	}
		});
	}, 1000); // the "1000" here refers to the time to refresh the div.  it is in milliseconds. 
});
</script>

<!--=============================================================-->
<section class="row-fluid">
	<div class="span12">
		
		<h1 class="lead" id="state"><i class="icon-spinner icon-spin"></i>Loading...</h1>
			
		<p>Bacon ipsum dolor sit amet frankfurter strip steak short loin pig venison ham filet mignon t-bone turkey ham hock turducken andouille sausage shankle. Filet mignon tail rump fatback t-bone bacon tri-tip cow beef ribs pig pancetta sirloin turducken short ribs. Filet mignon strip steak prosciutto ball tip drumstick spare ribs pork. Bacon chicken chuck leberkas ball tip. Frankfurter biltong capicola beef ribs pork loin t-bone.</p>
			
		<p>Venison hamburger jowl sirloin, prosciutto chicken leberkas tongue salami meatloaf capicola boudin t-bone swine. Bacon strip steak shankle, boudin corned beef biltong tenderloin sirloin short ribs swine short loin meatloaf ball tip leberkas. Short ribs short loin pork loin meatball salami. Fatback pig t-bone flank shankle kielbasa beef ribs turkey meatloaf.</p>
	</div>
	
	<div class="btn-centered btn-group">
		<a class="btn btn-large" href="lights/webMethod/turnOn">Turn On</a>
	  	<a class="btn btn-large" href="lights/webMethod/turnOff">Turn Off</a>
	</div>
</section>
