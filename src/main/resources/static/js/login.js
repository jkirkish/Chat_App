var submitBtn = document.querySelector("#submitBtn")


let users = []
//function injected in the addEventlistener to make less lines of code
//https://idratherbewriting.com/events-and-listeners-javascript/
//https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API
/*events and listeners
onload //when the page loads
onclick //when a user clicks something
onmouseover //when a user mouses over something
onfocus //when a user puts the cursor in a form field
onblur //When a user leaves a form field
*/


username.addEventListener('blur', () => {
	let username = document.querySelector("#username")
	let password = document.querySelector("#password")
	
	var user = {
		"username":username.value,
		"password":password.value
		
	}
	
	fetch(`http://localhost:8080/users/exists`,{
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(user)
		})
		.then((response) => response.json())
		.then((data) => {
			console.log(data)
		})
})
	
