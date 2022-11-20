var submitBtn = document.querySelector("#submitBtn")
console.log("submitBtn is: ")
console.log(submitBtn)

//function injected in the addEventlistener to make less lines of code
//https://idratherbewriting.com/events-and-listeners-javascript/
/*events and listeners
onload //when the page loads
onclick //when a user clicks something
onmouseover //when a user mouses over something
onfocus //when a user puts the cursor in a form field
onblur //When a user leaves a form field
*/
submitBtn.addEventListener('click', function(){
	console.log("I have been clicked")
	
/*
th:field="${user.username}"/> will already have an id
*/
var usernameTextBox = document.querySelector("#username")
usernameTextBox.addEventListener('focus',function(){
	console.log("The username textbox now has focus")
})
})

