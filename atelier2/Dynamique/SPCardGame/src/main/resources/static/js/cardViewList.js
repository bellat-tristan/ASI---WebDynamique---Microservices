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
    let template = document.querySelector("#cardTemplate");

    for(const card of cardlist){
        let clone = document.importNode(template.content, true);

        newContent= clone.firstElementChild.innerHTML
            .replace(/{{cardviewTitle}}/g, card.name)
            .replace(/{{cardDescription}}/g, card.description)
            .replace(/{{cardviewImg}}/g, card.imgUrl)
            .replace(/{{cardAffinity}}/g, card.affinity)
            .replace(/{{cardFamily}}/g, card.family)
            .replace(/{{cardHp}}/g, card.hp)
            .replace(/{{cardEnergie}}/g, card.energy)
            .replace(/{{cardDefence}}/g, card.defence)
            .replace(/{{cardAttack}}/g, card.attack)
            .replace(/{{cardPrix}}/g, card.prix);
        clone.firstElementChild.innerHTML= newContent;

        let cardContainer= document.querySelector("#cardListContainer");
        cardContainer.appendChild(clone);
    }
}

function err_callback(error){
    console.log(error);
}
