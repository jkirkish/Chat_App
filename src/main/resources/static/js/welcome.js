
		let user = sessionStorage.getItem("user")

		if (user == null) {
			let nameOfUser = prompt("What's your name?", "Participant")
					while (nameOfUser === '' || nameOfUser == null) {
						nameOfUser = prompt("What's your name?", "Participant")
					}
			fetch('/users', {
				method: 'POST',
				body: nameOfUser
			}).then(response => response.json())
			.then(user => {
				sessionStorage.setItem('user', JSON.stringify(user));
			})
		} else {
			user = JSON.parse(sessionStorage.getItem("user"))
					console.log(user)
		}
	