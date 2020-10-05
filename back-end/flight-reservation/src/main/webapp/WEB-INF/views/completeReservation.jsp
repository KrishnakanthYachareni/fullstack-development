<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Finish Reservation</title>
</head>
<body>
	<pre>
	<h2>Complete Reservation:</h2>
	<br />Airline: ${flight.operatingAirlines}
	<br /> Departure City: ${flight.departureCity}
	<br /> Arrival City: ${flight.arrivalCity}
	<br />
	</pre>
	<form action="completeReservation" method="post">
		<pre>
	<h2>Passenger Information:</h2>
	First Name: <input type=text name="passengerFirstName" />
	Last Name: <input type=text name="passengerLastName" />
	Email: <input type=text name="passengerEmail" />
	Phone: <input type=text name="passengerPhone" />
	
	<h2>Card Details</h2>
	Name On Card: <input type=text name="nameOnTheCard" />
	Card Number: <input type=text name="cardNumber" />
	Expiry Date: <input type=text name="expirationDate" />
	CVV(Security code): <input type=text name="securityCode" />
	<input type="hidden" name="flightId" value="${flight.id}" />
	<input type="submit" value="confirm" />
	</pre>
	</form>
</body>
</html>