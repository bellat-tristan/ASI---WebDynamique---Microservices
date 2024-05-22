function myfonction(){
    const GET_API_URL="http://localhost:8080/cards/listAll";
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
        if(card.enVente == true)
        {
            newContent = clone.firstElementChild.innerHTML
                .replace(/{{CardName}}/g, card.name)
                .replace(/{{CardDescription}}/g, card.description)
                .replace(/{{CardImage_src}}/g, card.imgUrl)
                .replace(/{{CardAffinity}}/g, card.affinity)
                .replace(/{{CardFamily}}/g, card.family)
                .replace(/{{Cardhp}}/g, card.hp)
                .replace(/{{CardEnergy}}/g, card.energy)
                .replace(/{{CardDefence}}/g, card.defence)
                .replace(/{{CardAttack}}/g, card.attack)
                .replace(/{{CardPrice}}/g, card.prix)
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
    console.log(source);
    let imageElement = document.querySelector("#imagePreview");
    imageElement.src = source;
}
function BuyCard(idCard)
{
    const POST_API_URL = `http://localhost:8080/cards/buy?idCard=${idCard}`;
    let context = {
        method: 'POST',
    };

    fetch(POST_API_URL, context)
        .then(response => {
            if (response.status === 201) {
                console.log("Card sale state updated successfully.");
                location.reload();
            } else {
                console.log("Failed to update card sale state.");
            }
        })
        .catch(error => console.error("Error:", error));
}