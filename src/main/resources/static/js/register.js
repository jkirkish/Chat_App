var usernameTextbox = document.getElementById('username')



usernameTextbox.addEventListener('blur', () => {
	var user = {
			'username': usernameTextbox.value,
	}
	fetch('/users/exists', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	})
	.then( (responseEntity) => responseEntity.json() )
	.then( (data) => {
		if (data === true) {
			// this users already exists!
			console.log("username already exists")
			usernameTextbox.focus()
			usernameTextbox.select()
		    	showErrorAnimation().then((message2) => {
				// animation is completed at this point
				console.log("We're now in the callback function")
				console.log(message2)
				usernameTextbox.style.backgroundColor = 'rgb(255,255,255)'
			})
		}
	})
})

function showErrorAnimation () {
	return new Promise( (resolve, reject) => {
		console.log("We're in the showErrorAnimation function")
		var i = 0

		var animationInterval = setInterval(() => {
			i++
			usernameTextbox.style.backgroundColor = `rgb(${i}, 0, 0)`
				if (i >= 255) {
					clearInterval(animationInterval);
					resolve("Done executing animation code")
				}
		}, 1)
	})
}