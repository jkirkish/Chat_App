let user = sessionStorage.getItem("user")
			
			switch(user){
			case null:
				let name = prompt("Hello Dude, Can I get your name please?", "Name right here")
				 
				while (name === '' || name == null) {
					name = prompt("Hello Dude, Please tell me your name?", "Name right here")
				}
				alert("Hello " + name + ", Please be respectful in the chatBox!!")
				fetch('/users', {
					method: 'POST',
					body: name
				}).then(response => response.json())
				.then(user => {
					sessionStorage.setItem('user', JSON.stringify(user));
				})
				
				break;
			default:
				user = JSON.parse(sessionStorage.getItem("user"))
				console.log(user)
			}