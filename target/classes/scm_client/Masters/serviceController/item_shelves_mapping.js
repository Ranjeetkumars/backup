$(document).ready(function() {
	loadRackDetails();
	loadStore();
});

function openModalBox() {
	alert('openModalBox  javascript function is executed');
	$('#rackShelves').modal('show');
	$("#save_disable").attr("disabled", false);
	$("#reset_disable").attr("disabled", false);
	$("#update_disable").attr("disabled", true);

}