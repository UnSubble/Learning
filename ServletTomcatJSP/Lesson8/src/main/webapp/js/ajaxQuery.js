function sendAjaxQuery() {
	$.ajax({
		url: 'user.servlet',
		method: 'POST',
		data: {
			nameJava: $('#firstname').val()
		},
		success: function(responseText) {
			$('#ajaxGetUserServletResponse').text(responseText);
		}
	});
}