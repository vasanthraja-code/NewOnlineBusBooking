let count=document.querySelector('#count');
let total=document.querySelector('#total');
let seatContainer=document.querySelector('.container-seat');
let allSeatsAvailable=document.querySelectorAll('.seat:not(.Booked)');
let ticketPrice= 500;
	seatContainer.addEventListener('click',function(e){
	if(e.target.classList.contains('seat') && !(e.target.classList.contains('Booked'))){
		e.target.classList.toggle('Selected');
		updatePriceandCount();
	}
});
function updatePriceandCount(){
	let seatsSelected = document.querySelectorAll('.container-seat .Selected');
	count.innerText=seatsSelected.length;
	total.innerText=seatsSelected.length*ticketPrice;
	let selectedIndex=[...seatsSelected].map((s)=>{
		return [...allSeatsAvailable].indexOf(s);
	});
	console.log(selectedIndex);
}
