document.getElementById("inscriptionForm").addEventListener("submit", function (e) {
    e.preventDefault();

    // Récupérer les valeurs du formulaire
    let nom = document.getElementById("nom").value;
    let prenom = document.getElementById("prenom").value;
    let classe = document.getElementById("classe").value;
    let ecole = document.getElementById("ecole").value;
    let serie = document.getElementById("serie").value;
    let adresse = document.getElementById("adresse").value;
    let telephone = document.getElementById("telephone").value;

    // Envoyer les données au serveur Flask
    fetch("/ajouter", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nom, prenom, classe, ecole, serie, adresse, telephone
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            ajouterLigneTableau(nom, prenom, classe, ecole, serie, adresse, telephone);
            document.getElementById("inscriptionForm").reset(); // Effacer le formulaire
        } else {
            alert("Erreur lors de l'inscription.");
        }
    })
    .catch(error => console.error("Erreur:", error));
});

// Fonction pour ajouter une ligne dans le tableau HTML
function ajouterLigneTableau(nom, prenom, classe, ecole, serie, adresse, telephone) {
    let tableBody = document.getElementById("tableBody");
    let newRow = tableBody.insertRow();

    newRow.innerHTML = `
        <td>${nom}</td>
        <td>${prenom}</td>
        <td>${classe}</td>
        <td>${ecole}</td>
        <td>${serie}</td>
        <td>${adresse}</td>
        <td>${telephone}</td>
        <td><button onclick="supprimerLigne(this)">Supprimer</button></td>
    `;
}

// Fonction pour supprimer une ligne
function supprimerLigne(btn) {
    let row = btn.parentNode.parentNode;
    let nom = row.cells[0].innerText; // Récupérer le nom pour supprimer dans le fichier Excel

    fetch("/supprimer", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nom })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            row.remove(); // Supprime la ligne du tableau
        } else {
            alert("Erreur lors de la suppression.");
        }
    })
    .catch(error => console.error("Erreur:", error));
}
