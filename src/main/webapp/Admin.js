function adminAddBusRoute(){
	let stopPointsCount=document.getElementById("stopPoints").value;
	let addLocationsDiv=document.querySelector(".addLocations");
	 addLocationsDiv.innerHTML = "";
    let originLabel = document.createElement("label");
    originLabel.textContent = "Origin Point: ";
    let originInput = document.createElement("input");
    originInput.type = "text";
    originInput.name = "Origin";
    originInput.value=document.getElementById("origin").value;
    addLocationsDiv.appendChild(originLabel);
    addLocationsDiv.appendChild(originInput);
    addLocationsDiv.appendChild(document.createElement("br"));
	
	for(let i=1;i<=stopPointsCount;i++){
		let label=document.createElement("label");
		label.textContent= "Stop Point " + i + ": ";
		let input = document.createElement("input");
        input.type = "text";
        input.placeholder = "Enter Stop Point " + i;
        input.name = "stopPoint" + i;
        input.id="stop"+i;
        addLocationsDiv.appendChild(label);
        addLocationsDiv.appendChild(input);
        addLocationsDiv.appendChild(document.createElement("br"));
	}
	let destinationLabel = document.createElement("label");
    destinationLabel.textContent = "Destination   : ";
    let destinationInput = document.createElement("input");
    destinationInput.type = "text";
    destinationInput.name = "Destination";
    destinationInput.value=document.getElementById("destination").value;
    addLocationsDiv.appendChild(destinationLabel);
    addLocationsDiv.appendChild(destinationInput);
    addLocationsDiv.appendChild(document.createElement("br"));
    if(adminAddBus()){
		callAdminAddBusRoute();
	}
    
    
	
}
function showOptions(){
	let show1=document.getElementById("roles");
		show1.style.display="block";
		window.location.assign("AdminAddBus.html");
		adminAddBusRoute();
}

function adminAddBus(){
	
	let bus_name=document.getElementById("busNameId").value;
    let origin=document.getElementById("origin").value;
    let destination=document.getElementById("destination").value;
    let departure_time=document.getElementById("departure").value;
    let arrival_time=document.getElementById("arrival").value;
    let total_seats=document.getElementById("totalSeatCount").value;
    let available_seats=document.getElementById("availableSeatCount").value;
	let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/NewOnlineBusBooking/AdminAddBusServlet", true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
                	console.log("Bus added successful");
                	alert("Bus Added Successfully");
                	return true;
            	} 
            	else{
					alert("Error in adding bus");
				}
        }
    };
    
    

    xhr.send("bus_name="+bus_name+"&route_from="+origin+"&route_to="+destination+"&departure_time="+departure_time+"&arrival_time="+arrival_time+
    "&total_seats="+total_seats+"&available_seats="+available_seats);
    document.getElementById("busNameId").value="";
	document.getElementById("origin").value="";
	document.getElementById("destination").value="";
	document.getElementById("departure").value="";
	document.getElementById("arrival").value="";
	document.getElementById("totalSeatCount").value="";
	document.getElementById("availableSeatCount").value="";
}
let callcount=0;
let busId=22;
function callAdminAddBusRoute(){
	callcount++;
	busId++;
	let stops=document.getElementById("stopPoints").value;
    let origin=document.getElementById("origin").value;
    let destination=document.getElementById("destination").value;
    let arrayOfStops=[];
    arrayOfStops.push(origin);
    for(let i=1;i<=stops;i++){
		arrayOfStops.push(document.getElementById("stop" + i).value)
	}
	arrayOfStops.push(destination);
	
	let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/NewOnlineBusBooking/AdminBusRoutesServlet", true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200){
				var response=xhr.responseText;
				if(response.trim() == "success"){
                	console.log("Request successful");
                	alert("route added");
            	} 
            	else{
					alert("Route not addes");
				}
        }
    };

    xhr.send("route_id="+callcount+"&json="+JSON.stringify(arrayOfStops)+"bus_id="+busId);
	
}

