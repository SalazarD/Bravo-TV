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
	if(document.getElementById('type').value == "SD"){
		document.getElementById("upgrade_charge").value = 0;
		document.getElementById("upgrade_charge").readOnly = true;
	}else {
		document.getElementById("upgrade_charge").disabled = false;
	}
	
}
function showHideRefundable(){
	var radios = document.getElementsByName('billing_type');

	for (var i = 0, length = radios.length; i < length; i++) {
	  if (radios[i].checked) {
	    if(radios[i].value == "postpaid"){
			document.getElementById("refundableDepositAmount").value = 0;
			document.getElementById("refundableDepositAmount").readOnly = true;
		}else {
			document.getElementById("refundableDepositAmount").readOnly = false;
		}
	  }
	}
}