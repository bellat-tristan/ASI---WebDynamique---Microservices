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
                .replace(/{{smallImgUrl}}/g, card.smallImgUrl)
                .replace(/{{CardImage_src}}/g, card.imgUrl)
                .replace(/{{CardAffinity}}/g, card.affinity)
                .replace(/{{CardFamily}}/g, card.family)
                .replace(/{{Cardhp}}/g, card.hp)
                .replace(/{{CardEnergy}}/g, card.energy)
                .replace(/{{CardDefence}}/g, card.defence)
                .replace(/{{CardAttack}}/g, card.attack)
                .replace(/{{CardPrice}}/g, card.prix);
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
function SellCard()
{

}