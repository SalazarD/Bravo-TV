function addFeature(){
	var features = document.getElementById('Cfeatures').value;
	var hold = document.getElementById("featuresList");
	var checkbox = document.createElement('input');
 	checkbox.type = "checkbox";
 	checkbox.name = features;
 	checkbox.id = "features";

 	var label = document.createElement('label');
 	var tn = document.createTextNode(features);

 	label.htmlFor="features";
 	label.appendChild(tn); 
 	hold.appendChild(checkbox);
 	hold.appendChild(label);
};

function showHideUpgradationCharge(){
	if(document.getElementById('topBoxType').value == "Standard"){
		document.getElementById("upgradationCharge").disabled = true;
		document.getElementById("upgradationCharge").value = 0;
	}else {
		document.getElementById("upgradationCharge").disabled = false;
	}
	
}
function showHideRefundable(){
	var radios = document.getElementsByName('billingType');

	for (var i = 0, length = radios.length; i < length; i++) {
	  if (radios[i].checked) {
	    if(radios[i].value == "postpaid"){
			document.getElementById("refundableDepositAmount").disabled = true;
			document.getElementById("refundableDepositAmount").value = 0;
		}else {
			document.getElementById("refundableDepositAmount").disabled = false;
		}
	  }
	}
}