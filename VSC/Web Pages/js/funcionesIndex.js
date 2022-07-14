function cargarElementoDinamicamente(url, elemento){
    
    let request = new XMLHttpRequest();
    
    //funcion asincrona con el false
    request.open("GET", url, false);
    
    //No necesita un HTMLBody
    request.send(null);
    
    elemento.innerHTML = request.responseText;
}

function cargarAltaUsuario(){

    let elemento = document.getElementById("contenidoDinamico");

    cargarElementoDinamicamente("altaUsuario.jsp", elemento);


}

function cargarLogin(){

    let elemento = document.getElementById("contenidoDinamico");

    cargarElementoDinamicamente("login.jsp", elemento);

}