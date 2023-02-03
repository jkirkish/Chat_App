startMessaging().then((message1) => {
	console.log("Message executed!")
	console.log(message1)
	
})
function startMessaging(){
	return new Promise((resolve,reject)=> {
var textBox = document.getElementById('messageBox')	
textBox.addEventListener('keyup', (e) => {
	switch(e.keyCode){
		case 13:
		        let message = {
                "text": textBox.value,
                "channelId": channelId,
                "user": user,
                "createdDate": new Date()
        }
        let messageText = textBox.value
        textBox.value = ''
        fetch('/messages', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(message)
        }).then(response => {retrieveMessages()})
        return false
		resolve("Done")
	}
})
})
}
function retrieveMessages () {
    let messageContainer = document.querySelector(".communication-container")
    fetch(`/messages/${channelId}`)
    .then(response => response.json())
    .then(messages => {
       messageContainer.innerHTML = ''
        messages.forEach(message => {
           messageContainer.innerHTML += `<div>
			  <span class="timestamp">${message.user.name}:
			   </span>
	<span class="message">${message.text}</span>
			</div>`
		})
	})
}setInterval(retrieveMessages, 500)		   