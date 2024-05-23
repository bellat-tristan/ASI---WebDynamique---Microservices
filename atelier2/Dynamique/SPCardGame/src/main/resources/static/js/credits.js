// credits.js

async function updateCredits() {
    const username = localStorage.getItem('username');

    if (!username) {
        console.log('No user is logged in.');
        return;
    }

    try {
        // Envoyer une requête pour récupérer les crédits de l'utilisateur
        const response = await fetch(`/users/credits/${username}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('credits', data.credits);
            document.getElementById('credits').innerText = `${data.credits}`;
        } else {
            console.error('Failed to fetch credits. Response status:', response.status);
        }
    } catch (error) {
        console.error('Error fetching credits:', error);
    }
}

// Appeler la fonction updateCredits à chaque chargement de la page
document.addEventListener('DOMContentLoaded', updateCredits);
