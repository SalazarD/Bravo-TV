
function edit_row(no){
	document.getElementById("edit_button"+no).style.display="none";
	document.getElementById("save_button"+no).style.display="block";
	
	var CB= document.getElementById("CB_row"+no);
	var DB= document.getElementById("DB_row"+no);
	
	var CB_data=CB.innerHTML;
	var DB_data=DB.innerHTML;
	
	CB.innerHTML="<input type='number' id='CB_value"+no+"' value='"+CB_data+"'>";
	DB.innerHTML="<input type='number' id='DB_value"+no+"' value='"+DB_data+"'>";
	
}
function save_row(no)
{
 var CB_val=document.getElementById("CB_value"+no).value;
 var DB_val=document.getElementById("DB_value"+no).value;
 

 document.getElementById("CB_row"+no).innerHTML=CB_val;
 document.getElementById("DB_row"+no).innerHTML=DB_val;

 document.getElementById("edit_button"+no).style.display="block";
 document.getElementById("save_button"+no).style.display="none";
}

