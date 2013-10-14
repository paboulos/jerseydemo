/**
 * @author Paul
 */
function out(outStr) // cheap and dirty output function
{
    document.getElementById("sales").innerHTML += "<br>" + outStr;
}

function onLoad(){
	var url = "rest/helloworld/list";
	var request = new XMLHttpRequest();
	out("Opening service...");
	request.onload = function() { updateSales( request ); };
	request.open("GET", url);
	request.setRequestHeader('Accept', 'application/json');
	out("Sending service request...");
	request.send(null);
    out("Done");
}
//{"aircraftType":[{"type":"B737","length":"42.1","seatingCapacity":"204"},{"type":"A330","length":"58.8","seatingCapacity":"253"}]}
function updateSales(request){
	if (request.status == 200 ||  request.status == 0){
		//out(request.responseText);
		var salesDiv = document.getElementById("sales");
		var sales = JSON.parse(request.responseText);
		var aircrafts = sales.aircraftType;
		for (var i=0; i<aircrafts.length; i++){
			var aircraft = aircrafts[i];
			var div = document.createElement("div");
			div.setAttribute("class","saleItem");
			div.innerHTML = aircraft.type + " " + aircraft.length + " " + aircraft.seatingCapacity;
			salesDiv.appendChild(div);
		}
	}else{
		out("Nothing");
	}
	
}