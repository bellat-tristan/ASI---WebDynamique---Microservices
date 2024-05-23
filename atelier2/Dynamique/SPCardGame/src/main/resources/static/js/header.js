
document.addEventListener("DOMContentLoaded", function() {

    // Retrieve user data from local storage
    const username = localStorage.getItem("username");
    const credits = localStorage.getItem("credits");
    // Populate elements with user data
    const creditsElement = document.getElementById("credits");
    const pageTitleElement = document.getElementById("pageTitle");
    const userNameElement = document.getElementById("nameofuser");

    // Extract current page name from URL
    var page = window.location.pathname.split("/").pop();

    // Update element contents
    creditsElement.innerHTML = credits || "0";
    pageTitleElement.innerHTML = page;
    userNameElement.innerHTML = username || "Connectez-vous";
})
