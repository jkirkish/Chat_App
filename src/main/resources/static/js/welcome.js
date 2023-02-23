
	var user = seesionStorage.getItem("user")
	if (user == null) {
		let name = prompt("Hello Sir, What is your name?", "Participant")
		while(name === '' || name == null) {
			name = prompt("Hello Sir, What is your name?", "Participant")
		}
		fetch('/user', {
			method: 'POST',
			body: name
		}).then(response => response.json())
          .then(user => {
        	  sessionStorage.setItem('user', JSON.stringify(user));
          })
	}else {
		user = JSON.parse(sessionStorage.getITEM("user"))
		console.log(user)		
	}
	
	