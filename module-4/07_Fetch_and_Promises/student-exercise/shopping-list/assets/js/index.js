let booleanFlag = false;

const loadButton = document.querySelector('.loadingButton');

loadButton.addEventListener('click', () => {

    if (!booleanFlag) {
        loadGroceries();
    }

});

function loadGroceries(){
    fetch ('assets/data/shopping-list.json')
        .then ((response) => {
            return response.json();
        })
        .then ((groceries) =>{
            if ('content' in document.createElement('template')) {
                const list = document.querySelector('ul');
                groceries.forEach((item) => {
                    const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
                    tmpl.querySelector('li').insertAdjacentHTML('afterbegin', item.name);

                    if (item.completed){
                        const circle = tmpl.querySelector('.fa-check-circle');
                        circle.className += ' completed';
                    }
                    list.appendChild(tmpl);
                });
            booleanFlag = true;
        }
        else { 
            alert('Browser not supported!');
}
        })
.catch((error) =>{
alert ('Browser not supported');
});
}
