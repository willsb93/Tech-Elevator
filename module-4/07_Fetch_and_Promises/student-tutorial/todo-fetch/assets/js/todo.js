fetch('data.json')
  .then((response) => {
    return response.json();
  })
  .then((todos) => {
    if('content' in document.createElement('template')) {
      const list = document.querySelector("ul");
      todos.forEach((todo) => {
        const tmpl = document.getElementById('tasks').content.cloneNode(true);
        tmpl.querySelector("li").insertAdjacentHTML('afterbegin',todo.task);
        if( todo.completed ) {
          const circleCheck = tmpl.querySelector('.fa-check-circle');
          const currentClass = circleCheck.className;
          circleCheck.className = currentClass + " completed";
        }
        list.appendChild(tmpl);
      });
    } else {
      console.error('Your browser does not support templates');
    }
  })
  .catch((err) => {console.error(err)});

