function myfonction(){
    const GET_API_URL="http://localhost:8080/cards/userCards";
    let context =   {
        method: 'GET'
    };

    fetch(GET_API_URL,context)
        .then(response => response.json())
        .then(response => callback(response))
        .catch(error => err_callback(error));
}

function callback(response){
    let cardlist = response;
    let template = document.querySelector("#row-template");

    for(const card of cardlist){
        let clone = document.importNode(template.content, true);
        if(card.enVente == false)
        {
            newContent = clone.firstElementChild.innerHTML
                .replace(/{{CardName}}/g, card.name)
                .replace(/{{CardDescription}}/g, card.description)
                .replace(/{{CardImage_src}}/g, card.imgUrl)
                .replace(/{{CardAffinity}}/g, card.affinity)
                .replace(/{{CardFamily}}/g, card.family)
                .replace(/{{Cardhp}}/g, card.hp)
                .replace(/{{CardEnergy}}/g, card.energy)
                .replace(/{{CardDefence}}/g, card.defense)
                .replace(/{{CardAttack}}/g, card.attack)
                .replace(/{{CardPrice}}/g, card.prix)
                .replace(/{{enVente}}/g, card.enVente)
                .replace(/{{sellButton}}/g, "Sell")
                .replace(/{{CardId}}/g, card.id);
            clone.firstElementChild.innerHTML = newContent;

            let cardContainer = document.querySelector("#table-body");
            cardContainer.appendChild(clone);
        }
        else{
            newContent = clone.firstElementChild.innerHTML
                .replace(/{{CardName}}/g, card.name)
                .replace(/{{CardDescription}}/g, card.description)
                .replace(/{{CardImage_src}}/g, card.imgUrl)
                .replace(/{{CardAffinity}}/g, card.affinity)
                .replace(/{{CardFamily}}/g, card.family)
                .replace(/{{Cardhp}}/g, card.hp)
                .replace(/{{CardEnergy}}/g, card.energy)
                .replace(/{{CardDefence}}/g, card.defense)
                .replace(/{{CardAttack}}/g, card.attack)
                .replace(/{{CardPrice}}/g, card.prix)
                .replace(/{{enVente}}/g, card.enVente)
                .replace(/{{sellButton}}/g, "Remove")
                .replace(/{{CardId}}/g, card.id);
            clone.firstElementChild.innerHTML = newContent;

            let cardContainer = document.querySelector("#table-body");
            cardContainer.appendChild(clone);
        }
    }
}

function err_callback(error){
    console.log(error);
}

function PreviewCard(source)
{
    let imageElement = document.querySelector("#imagePreview");
    imageElement.src = source;
}

function sellCard(idCard, state) {
    if(state == 'false') {
        state = true;
        const POST_API_URL = `http://localhost:8080/cards/sell?idCard=${idCard}&state=${state}`;
        let context = {
            method: 'POST',
        };

        fetch(POST_API_URL, context)
            .then(response => {
                if (response.status === 204) {
                    console.log("Card sale state updated successfully.");
                    location.reload()
                } else {
                    console.log("Failed to update card sale state.");
                }
            })
            .catch(error => console.error("Error:", error));
    }
    else
    {
        state = false;
        const POST_API_URL = `http://localhost:8080/cards/sell?idCard=${idCard}&state=${state}`;
        let context = {
            method: 'POST',
        };

        fetch(POST_API_URL, context)
            .then(response => {
                if (response.status === 204) {
                    console.log("Card sale state updated successfully.");
                    location.reload()
                } else {
                    console.log("Failed to update card sale state.");
                }
            })
            .catch(error => console.error("Error:", error));
    }

}