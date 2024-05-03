// function myFunction() {
//     // Empêcher le formulaire d'être soumis normalement
//     event.preventDefault();

//     var form = document.querySelector('.ui.form');
//     console.log('Form:', form);


//     // Construire FormData à partir du formulaire
//     //var formData = new FormData(form);
//     var formData = {
//         "name": "string",
//         "description": "string",
//         "family": "string",
//         "affinity": "string",
//         "imgUrl": "string",
//         "smallImgUrl": "string",
//         "id": 0,
//         "energy": 0,
//         "hp": 0,
//         "defence": 0,
//         "attack": 0,
//         "price": 0,
//         "userId": 0
//       };
//     // Envoyer les données via AJAX
//     $.ajax({
//         method: 'POST',
//         url: 'http://tp.cpe.fr:8083/card', // Remplacez 'URL_DE_VOTRE_API' par l'URL réelle de votre API
//         data: formData,
//         contentType: false,
//         processData: false,
//         headers: { 'Content-Type': 'application/json' },
//         success: function (response) {
//             console.log('Données envoyées avec succès !');
//             // Réponse de l'API ou autres manipulations après l'envoi des données avec succès
//         },
//         error: function (xhr, status, error) {
//             console.error('Erreur lors de l\'envoi des données :', error);
//             // Gérer l'erreur d'envoi des données
//         }
//     });
// }
const method = 'POST'
const headers = {'Content-Type': 'application/json'}

document.addEventListener('DOMContentLoaded', function () {
    const cardForm = document.querySelector('.ui.form');

    if (!cardForm)
        return;

    cardForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = {};
        const fields = this.querySelectorAll(".field > input");

        fields.forEach(field => {
            formData[field.name] = (field.type === 'number') ? parseInt(field.value) : field.value;
        });

        fetch('http://tp.cpe.fr:8083/card', {
            method,
            headers,
            body: JSON.stringify(formData)
        }).then(response => {
            if (!response.ok) {
                throw new Error(response.status + ' ' + response.statusText);
            }
            return response.json();
        })
            .then(data => console.info(data))
            .catch(error => console.error('Error creating card: ' + error));
    });
});