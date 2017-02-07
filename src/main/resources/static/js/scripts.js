$(function() {	
	/*if(("input[id*=Date], .datepicker").length > 0) {
		$.fn.datepicker.defaults.format = 'M dd, yyyy';
		
		$("input[id*=Date], .datepicker").datepicker({
			//datesDisabled: ['06/05/2015', '06/07/2015'],
		 	daysOfWeekDisabled: [0,6],
			changeMonth: true,
			changeYear: true
//			dateFormat: 'M dd, yy'
		});
	}*/
	
	/**Toggle Checkbox for Sections**/
	$("input[class^='chkSections']").on('change', function() {
		var cls = $(this).attr('class');
		$('input.'+cls).not(this).prop('checked', false);  
	});
	
	/**Toggle Botton Expand for Blocks**/
	$("button.bcollapse").on('click', function() {
		$('button.bcollapse').not(this).each(function (index, value) { 
			var $tr = $(this).parents("tr").next('tr.bcollapse');
			if($tr && $tr.hasClass('in')) {
				$tr.removeClass('in');			
			}
		});
		
	});

});