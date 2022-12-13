var user = sessionStorage.getItem("user")
			
			switch(user){
			case null:
				var name = prompt("Hello Dude, Can I get your name please?", "Participant")
				 
				while (name === '' || name == null) {
					name = prompt("Hello Dude, Please tell me your name?", "Participant")
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