function myFunction(){
    const GET_API_URL="http://tp.cpe.fr:8083/cards"; 
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
    let template = document.querySelector("#selectedCard");

    for(const card of cardlist){
        const elem = document.getElementById("recherche");
        if(card.name == elem.value)
        {
            let clone = document.importNode(template.content, true);

            newContent= clone.firstElementChild.innerHTML
                        .replace(/{{Name}}/g, card.name)
                        .replace(/{{smallImgUrl}}/g, card.smallImgUrl)
                        .replace(/{{image_src}}/g, card.imgUrl)
                        .replace(/{{hp}}/g, card.hp)
                        .replace(/{{energy}}/g, card.energy)
                        .replace(/{{defence}}/g, card.defence)
                        .replace(/{{attack}}/g, card.attack)
                        .replace(/{{price}}/g, card.price);
            clone.firstElementChild.innerHTML= newContent;
    
            let cardContainer= document.querySelector("#gridContainer");
            cardContainer.appendChild(clone);
        }
        else{}
    }
}

function err_callback(error){
    console.log(error);
}







