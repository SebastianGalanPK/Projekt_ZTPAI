const memeContainer = document.querySelector('#meme-wrapper');

document.addEventListener('DOMContentLoaded', function() {
    loadMemes("/meme");
  });

var roleID;

function loadMemes(fetchValue) {
    checkUserRole();

    const data = {search: this.value};

    memeContainer.innerHTML="";

    fetch(fetchValue)
    .then(response => response.json())
    .then(data => {
        loadAllMemes(data);

        loadVariablesAfterFetch();
    })
}

function loadAllMemes(memes){
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

    const removeButton = clone.querySelector('.remove-button');

    if (roleID !== 0) {
      removeButton.style.display = 'none';
    }

    memeContainer.appendChild(clone);
    reloadButtons();
}

function checkUserRole() {
  const url = '/user';

  fetch(url)
    .then(response => response.json())
    .then(user => {
      roleID = user.role.id;
    })
    .catch(error => {
      roleID = 1;
    });
}