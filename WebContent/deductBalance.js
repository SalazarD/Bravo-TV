
function editCB(no){
		document.getElementById("nonEditableCB"+no).style.display = "none";
		document.getElementById("editableCB"+no).style.display = "inline";	
		document.getElementById("cbEdit"+no).value = document.getElementById("cbValue"+no).innerHTML
}
function confirmCB(no){
		document.getElementById("editableCB"+no).style.display = "none";
		document.getElementById("nonEditableCB"+no).style.display = "inline";
		var balance = document.getElementById("cbEdit"+no).value;
		if(balance !== ""){
		document.getElementById("cbValue"+no).innerHTML = balance;
		}
}
function editDB(no){
		document.getElementById("nonEditableDB"+no).style.display = "none";
		document.getElementById("editableDB"+no).style.display = "inline";	
		document.getElementById("dbEdit"+no).value = document.getElementById("dbValue"+no).innerHTML
}
function confirmDB(no){
		document.getElementById("editableDB"+no).style.display = "none";
		document.getElementById("nonEditableDB"+no).style.display = "inline";
		var balance = document.getElementById("dbEdit"+no).value;
		if(balance !== ""){
		document.getElementById("dbValue"+no).innerHTML = balance;
		}
}