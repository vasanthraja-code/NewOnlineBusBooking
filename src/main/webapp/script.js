let click=0;
function signinBtnfn(){
		let email=document.getElementById("email").value;
		let password=document.getElementById("password").value;
		nameField.style.maxHeight="0";
		emailField.style.maxHeight="0";
		title.innerHTML="SIGN IN";
		let flag=signinBtn.classList.contains("disable");
		signupBtn.classList.add("disable");
		signinBtn.classList.remove("disable");
		if(!flag){
			callLoginServlet();
		}
		document.getElementById("phoneNumber").value="";
		document.getElementById("password").value="";
		click=1;
	}
	function signupBtnfn(){
		nameField.style.maxHeight="60px";
		emailField.style.maxHeight="60px";
		let userName=document.getElementById("Name").value;
		let email =document.getElementById("email").value;
		let phone=document.getElementById("phoneNumber").value;
		let password=document.getElementById("password").value;
		let check=document.forms["form"]["email"].value;
		title.innerHTML="SIGN UP";
		signinBtn.classList.add("disable");
		if(click ==0){
			if( isValidMobileNumber(phone) && isValidEmail(email) && !signupBtn.classList.contains("disable") ){
				callSignupServlet();
			}
		}
		signupBtn.classList.remove("disable");
		document.getElementById("Name").value="";
		document.getElementById("email").value="";
		document.getElementById("phoneNumber").value="";
		document.getElementById("password").value="";
		click=0;
		
		
	}
	function callSignupServlet(){
		var xhr=new XMLHttpRequest();
		xhr.open("POST", "http://localhost:8080/NewOnlineBusBooking/Signup",true);
		let userName=document.getElementById("Name").value;
		let email =document.getElementById("email").value;
		let phone=document.getElementById("phoneNumber").value;
		let password=document.getElementById("password").value;
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "alreadyUser"){
					alert("You are Already User....Please Sign in")
				}
				else if(response.trim() == "success"){
					alert("Signup successful");
				}
				
				else{
					alert("signup failed");
				}
			}
		}
		xhr.send("username="+userName+"&email="+email+"&phone="+phone+"&password="+password);
	}
	function showBuses(json){
		let show=document.getElementById("page2");
		show.style.display="block";
		let dataBody=document.getElementById("dataBody");
		console.log("inside showbus");
		for(let i=0;i<json.length;i++){
			let row=document.createElement("tr");
			let tableData0=document.createElement("td");
			tableData0.textContent=json[i].reservation_id;
			row.appendChild(tableData0);
			let tableData1=document.createElement("td");
			tableData1.textContent=json[i].journey_from;
			row.appendChild(tableData1);
			let tableData2=document.createElement("td");
			tableData2.textContent=json[i].journey_to;
			row.appendChild(tableData2);
			let tableData3=document.createElement("td");
			tableData3.textContent=json[i].reserved_date;
			row.appendChild(tableData3);
			let tableData4=document.createElement("td");
			tableData4.textContent=json[i].journey_date;
			row.appendChild(tableData4);
			let tableData5=document.createElement("td");
			tableData5.textContent=json[i].fare;
			row.appendChild(tableData5);
			
			dataBody.appendChild(row);
		}
		
		
	}
	function getBuses(json){
		let dataBody=document.getElementById("dataBusBody");
		console.log("insid showbus");
		for(let i=0;i<json.length;i++){
			console.log("inside for");
			let row=document.createElement("tr");
			let tableData0=document.createElement("td");
			tableData0.textContent=json[i].bus_id;
			row.appendChild(tableData0);
			let tableData1=document.createElement("td");
			tableData1.textContent=json[i].bus_name;
			row.appendChild(tableData1);
			let tableData2=document.createElement("td");
			tableData2.textContent=json[i].route_from;
			row.appendChild(tableData2);
			let tableData3=document.createElement("td");
			tableData3.textContent=json[i].route_to;
			row.appendChild(tableData3);
			let tableData4=document.createElement("td");
			tableData4.textContent=json[i].departure_date_time;
			row.appendChild(tableData4);
			let tableData5=document.createElement("td");
			tableData5.textContent=json[i].arrival_date_time;
			row.appendChild(tableData5);
			let tableData6=document.createElement("td");
			tableData6.textContent=json[i].total_seats;
			row.appendChild(tableData6);
			let tableData7=document.createElement("td");
			tableData7.textContent=json[i].available_seats;
			row.appendChild(tableData7);
			let tableData8=document.createElement("td");
			tableData8.textContent=json[i].journey_date;
			row.appendChild(tableData8);
			let tableData9=document.createElement("button");
			tableData9.textContent="View Seats";
			row.appendChild(tableData9);
			tableData9.onclick=function(){
				window.location.assign("SeatContainer.html")
			}
			dataBusBody.appendChild(row);
			let showBus=document.getElementById("page");
			showBus.style.display="block";
		}
		
		
	}
	function callLoginServlet(){
		var xhr=new XMLHttpRequest();
		xhr.open("POST","http://localhost:8080/NewOnlineBusBooking/Login",true);
		let phone=document.getElementById("phoneNumber").value;
		let password=document.getElementById("password").value;
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
					alert("LogIn successful");
					window.location.assign("SearchBus.html");
				}
				else if(response.trim() == "admin"){
					alert("Admin login");
				}
				else{
					alert("LogIn failed");
				}
		     }
		 }
		xhr.send("phone="+phone+"&password="+password);
	
	}
	function passengerDetails(){
		var xhr=new XMLHttpRequest();
		xhr.open("POST","http://localhost:8080/NewOnlineBusBooking/PassengerServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		let name=document.getElementById("name").value;
		let gender=document.getElementById("gender").value;
		let age=document.getElementById("age").value;
		let phone=document.getElementById("phone").value;
		
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
					alert("Passenger Added Successfully");
				}
				else{
					alert("Passenger adding Failed");
				}
		     }
		 }
		xhr.send("name="+name+"&gender="+gender+"&age="+age+"&phone="+phone);
		document.getElementById("name").value="";
		document.getElementById("gender").value="";
		document.getElementById("age").value="";
		document.getElementById("phone").value="";
		
	}
	function searchBuses(){
		let from=document.getElementById("from").value;
		let to=document.getElementById("to").value;
		let selectedDate=document.getElementById("date").value;
		console.log(selectedDate);
		document.getElementById("datechoosen").innerText=selectedDate;
		var xhr=new XMLHttpRequest();
		xhr.open("GET","http://localhost:8080/NewOnlineBusBooking/ReservationServlet?"+"from="+from+"&to="+to+"&date="+selectedDate,true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");

		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var jsonObject = JSON.parse(xhr.responseText);
				if(jsonObject.status){
					getBuses(jsonObject.data);
				}
				
				console.log(jsonObject);
		     }
		 }
		xhr.send();
		
		
	}
	function showAllBuses(){
		let from=document.getElementById("from").value;
		let to=document.getElementById("to").value;
		let date=document.getElementById("date").value;
		var xhr=new XMLHttpRequest();
		xhr.open("GET","http://localhost:8080/NewOnlineBusBooking/BusServlet?"+"from="+from+"&to="+to+"&date="+date,true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var jsonObject = JSON.parse(xhr.responseText);
				if(jsonObject.status){
						
					getBuses(jsonObject.data);
				}
				
				console.log(jsonObject);
		     }
		 }
		xhr.send();
		
	}
	function gotoSelectDate(){
		window.location.assign("SelectDate.html");
	}
	function isValidEmail(input){
		let regex=/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
		if(regex.test(input)){
			return true;
		}
		else{
			alert("Invalid Email Address");
			return false;
		}
	}
	function isValidMobileNumber(phoneNumber){
		let regex=/^[6-9][0-9]{9}/;
		if(regex.test(phoneNumber)){
			return true;
		}
		else{
			alert("Invalid phoneNumber ");
			return false;
		}
	}
	function adminLogin(){
		window.location.assign("Admin.html");	
	}
	function adminLoginBtnfn(){
		let email=document.getElementById("adminemail").value;
		let password=document.getElementById("adminpassword").value;
		var xhr=new XMLHttpRequest();
		xhr.open("POST","http://localhost:8080/NewOnlineBusBooking/AdminServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
					alert("Admin Login Successful");
					createAdmin();
				}
				else{
					alert("Admin Login Failed");
				}
		     }
		 }
		xhr.send("email="+email+"&password="+password);
		
		
	}
	function createAdmin(){
		let adminname=document.getElementById("adminname").value;
		let adminphonenumber=document.getElementById("adminphonenumber").value;
		let adminemail=document.getElementById("adminemail").value;
		let adminpassword=document.getElementById("adminpassword").value;
		var xhr=new XMLHttpRequest();
		xhr.open("POST","http://localhost:8080/NewOnlineBusBooking/CreateAdminServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
					alert("New Admin Created");
				}
				else{
					alert("New admin creation failed");
				}
				
			}
		}
		xhr.send("admin_name="+adminname+"&admin_phonenumber="+adminphonenumber+"&admin_email="+adminemail+"&admin_password="+adminpassword);
		
	}
	let distance="";
	let duration="";
	function calculateDistance(place1,place2){
		const obj1=place1;
        const obj2=place2;
        var xhr=new XMLHttpRequest();
		xhr.open("GET","https://api.distancematrix.ai/maps/api/distancematrix/json?origins="+obj1+"&destinations="+obj2
		+"&key=dvfejwt3vcHHzKYU3LbPPFEDhBS5oyiKe4wovMN2QYykeK4m9EPMKrAAy6gm5GJZ",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		distance="";
		duration="";
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=JSON.parse(xhr.responseText);
				distance =response.rows[0].elements[0].distance.text;
				duration =response.rows[0].elements[0].duration.text;
				//showDistanceDuration(place1,place2,distance,duration);
		     }
		 }
		xhr.send();
		
        
	}
	function showDistanceDuration(place1,place2,distance,duration){
		var xhr=new XMLHttpRequest();
		xhr.open("POST","http://localhost:8080/NewOnlineBusBooking/BusServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
					alert("New Admin Created");
				}
				else{
					alert("New admin creation failed");
				}
				
			}
		}
		xhr.send("origin="+place1+"&destination="+place2+"&distance="+distance);
		
	}
	
	/*function getDate(){
		
		gotoBookTicket();
		xhr.open("POST","http://localhost:8080/NewOnlineBusBooking/BusServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		xhr.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
					alert("happy");
				}
				else{
					alert("Your entry is Wrong");
				}
		     }
		 }
		xhr.send("date="+selectedDate);
		
	}*/