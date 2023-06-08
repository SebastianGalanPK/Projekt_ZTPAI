communityButtons = document.querySelectorAll(".cm-button");
starButtons = document.querySelectorAll(".cm-star-button");

function selectCommunity(){
    const button = this;

    const container = button.parentElement;
    const id = container.getAttribute("id");

    fetch('/community/'+id).then(function (){
       loadMemes('/community/'+id);
    });
}

function toggleCommunityFavourite() {
  const button = this;
  const container = button.parentElement;
  const id = container.getAttribute("id");

  fetch('/community/' + id, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ id: id }) // Przykładowe dane JSON, które można przekazać w ciele żądania POST
  })
    .then(function () {
      if (button.style.color == "yellow") {
        button.setAttribute('style', 'color: white');
      } else {
        button.setAttribute('style', 'color: yellow');
      }
    })
    .catch(function (error) {
      console.error('Wystąpił błąd podczas wysyłania żądania POST:', error);
    });
}

function reloadButtons(){
    communityButtons = document.querySelectorAll(".cm-button");
    communityButtons.forEach(item => item.addEventListener("click", selectCommunity));

    starButtons = document.querySelectorAll(".cm-star-button");
    starButtons.forEach(item=>item.addEventListener("click", toggleCommunityFavourite));
}
communityButtons.forEach(item => item.addEventListener("click", selectCommunity));
starButtons.forEach(item=>item.addEventListener("click", toggleCommunityFavourite));