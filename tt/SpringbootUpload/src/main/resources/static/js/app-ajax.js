$(document).ready(function() {
	$('#userName').blur(function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				console.log(responseText);
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});