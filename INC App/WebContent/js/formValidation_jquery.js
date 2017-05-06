$("document").ready(function(){
	
	$("#login_form").submit(function(){
		var x = $('#cec').val();
		var y = $('#pass').val();
		var re = /^\w+$/;
		
		console.log("the value of x= "+x);
		console.log("the value of y= "+y);
		
		if ( x == "" | y == "" ){
			//validation for empty filed
				   console.log("All Fields must be filled");
				   alert("All Fields must be filled");
				   return false;
			}
		    else if(x.length >=9 | y.length >=9 ){
		       //validation for length of the fields
		       console.log("CEC or Password cannot exceed 8 characters");
		       alert("CEC or Password cannot exceed 8 characters");
		       return false;
		    }
		    else if(!re.test(x)){
		       //validation for special characters in filed
		       alert("Username must contain only letters, numbers and underscores!");
		       return false;
		    }
		    else{
		       console.log("All validations are successfully met")
		       return true;
		    } 
	});
});