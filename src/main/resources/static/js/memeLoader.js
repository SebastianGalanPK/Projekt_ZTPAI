const memeContainer = document.querySelector('#meme-wrapper');

document.addEventListener('DOMContentLoaded', function() {
    // Tutaj możesz umieścić kod, który chcesz wykonać po załadowaniu pliku
  
    // Wywołaj funkcję
    loadAllMemes();
  });

function loadAllMemes() {
    const data = {search: this.value};

    fetch('/meme')
    .then(response => response.json())
    .then(data => {
        loadMemes(data);
    })
}

function loadMemes(memes){
    memes.forEach(meme => {
        createMeme(meme);
    });
}

function createMeme(meme){
    const template = document.querySelector("#meme-template");

    const clone = template.content.cloneNode(true);

    const container = clone.querySelector(".meme-container");
    container.setAttribute("id", meme.id);

    const header = clone.querySelector('.meme-header');

    const text = container.querySelector('.meme-text');
    text.innerHTML = meme.text;

    const community = header.querySelector('.community-name');
    community.innerHTML = meme.community.nickname;

    const user = header.querySelector('.user');

    const content = container.querySelector('.meme-content');
    const img = content.querySelector('img');
    img.src = "/uploads/"+meme.fileName;

    const user_name = user.querySelector('.user-name');
    user_name.innerHTML = meme.user.login;

    memeContainer.appendChild(clone);
    reloadButtons();
}