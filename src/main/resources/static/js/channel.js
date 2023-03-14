var textBox = document.querySelector("#messageBox")


	
textBox.addEventListener('keyup', (e) => {
	if(e.keyCode === 13){
		let message = {
				"text": textBox.value,
				"channelId": channelId,
				"user": user,
				"createdDate": new Date()
		}
		let messageText = textBox.value 
		console.log(`Send message ${messageText} `)
		textBox.value = ''
		fetch(`/messages`, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(message)
		}).then(response => {retrieveMessages().then(() => {
			console.log("Message retrieved")
		})})
		return false
	}
})

		
function retrieveMessages(){
	return new Promise((resolve, reject)=> {
	let messageContainer = document.querySelector(".message-container")
	fetch(`/messages/${channelId}`)
	.then(response => response.json())
	.then(messages => {
		messageContainer.innerHTML = ''
		messages.forEach(message => {
			messageContainer.innerHTML += `<div>
			<span class="timestamp">${message.user.name}: </span>
		  	  <span class="message">${message.text}</span>
			</div>`
			resolve("Got message")
			reject("No message")
		})
	})
})
}
setInterval(retrieveMessages, 500)

