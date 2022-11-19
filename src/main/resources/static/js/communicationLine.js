let textBox = document.getElementById('messageBox')
setInterval(retrieveMessages, 500)
textBox.addEventListener('keyup', (e) => {
    if (e.keyCode === 13) {
        let message = {
                "text": textBox.value,
                "channelId": channelId,
                "user": user,
                "createdDate": new Date()
        }
        let messageText = textBox.value
        console.log(`Send message ${messageText}`)
        textBox.value = ''
        fetch('/messages', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(message)
        }).then(response => {retrieveMessages()})
        return false
    }
})

function retrieveMessages () {
    let messageContainer = document.querySelector(".communication-container")
    fetch(`/messages/${channelId}`)
    .then(response => response.json())
    .then(messages => {
        messageContainer.innerHTML = ''
        messages.forEach(message => {
            messageContainer.innerHTML += `<div>
              <span class="timestamp">${message.user.name}: </span>
              <span class="message">${message.text}</span>
              <span class="message">:{${message.createdDate}}</span>
               <span class="message">Channel:${message.channelId}</span>
            </div>`
        })
    })
}setInterval(retrieveMessages, 500)