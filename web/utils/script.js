document.addEventListener("DOMContentLoaded", function() {
    // Su código para ejecutar ya que DOM está cargado y listo

    let res = document.getElementById('content');
    
    // INI - AJAX
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'Servlet_pagination', true);
    
    xhr.addEventListener('load', e => {
        const data = JSON.parse(e.target.responseText);
        console.log(data);
        draw(data);
    });
    
    // FIN - AJAX
    
    xhr.send();
    
    function draw(data){
        for(let obt of data){
            const container = document.createElement('div');
            container.setAttribute("Class","c");
            const title = document.createElement('div');
            title.setAttribute("Class","c2");
            const content = document.createElement('div');
            content.setAttribute("Class","c3");

            title.textContent = obt.id_p;
            content.textContent = obt.no_p;

            container.appendChild(title);
            container.appendChild(content);

            res.appendChild(container);
        }
    }
    
});


