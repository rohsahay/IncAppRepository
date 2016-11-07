function formValidateNew(){
	var x = null;
	var y = null;
    var re = /^\w+$/;
    
    x=document.forms["login_form"]["cec_id"].value;
	y=document.getElementById("pass").value;
    
		  
	console.log("the value of x= "+x);
	console.log("the value of y= "+y);

	if ( x == "" | y == "" ){
	//validation for empty filed
		   console.log("All Fields must be filled");
		   window.alert("All Fields must be filled");
		   return false;
	}
    else if(x.length >=9 | y.length >=9 ){
       //validation for length of the fields
       console.log("CEC or Password cannot exceed 8 characters");
       window.alert("CEC or Password cannot exceed 8 characters");
       return false;
    }
    else if(!re.test(x)){
       //validation for special characters in filed
       window.alert("Username must contain only letters, numbers and underscores!");
       return false;
    }
    else{
       console.log("All validations are successfully met")
       return true;
    }
}