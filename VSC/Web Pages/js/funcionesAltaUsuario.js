/**
 * Vacia los campos del formulario
 */
function vaciaFormulario(){
    let avisoContrasena = document.querySelector(".alert");
    let btnEnviarDatos = document.getElementById("btnEnviarDatos");
    avisoContrasena.innerHTML = "Todos los campos son requeridos";
    avisoContrasena.classList.remove("alert-danger");
    avisoContrasena.classList.remove("alert-warning");
    avisoContrasena.classList.remove("alert-success");
    avisoContrasena.classList.add("alert-primary");
    btnEnviarDatos.disabled = true;
}
/**
 * Genera un correo con los campos de nombre y apellido
 */
function usuarioAutomatico(){

    //Inicializar variables
    let dni = document.getElementById("txtDni");
    let nombre = document.getElementById("txtNombre");
    let apellido = document.getElementById("txtApellidos");
    let usuarioAutomatico = document.getElementById("txtUsuarioAutomatico");
    let nombreCompleto = nombre.value +"."+ apellido.value.slice(0,4);
    
    //Retorna nombreCompleto
    usuarioAutomatico.value = nombreCompleto.toLowerCase()+"@empresa.com";

    if (nombre.value.length == 0 || apellido.value.length == 0){
        usuarioAutomatico.value = "";
    }
}

/**
 * Verifca los campos de contraseña
 */
function verificaConstrasena(){
    
    let pass = document.getElementById("txtContrasena");
    let passConfirm = document.getElementById("txtConfirmaContrasena");
    let avisoContrasena = document.querySelector(".alert");
    let btnEnviarDatos = document.getElementById("btnEnviarDatos");

    //Boton desabilitado
    btnEnviarDatos.disabled = true;

    if (pass.value.length == 0 || passConfirm.value.length == 0){

        avisoContrasena.innerHTML = "Las contraseñas no pueden quedar vacias";
        avisoContrasena.classList.remove("alert-primary");
        avisoContrasena.classList.add("alert-warning");
        btnEnviarDatos.disabled = true;
    }
    else if(pass.value != passConfirm.value){
        
        avisoContrasena.innerHTML = "La contraseña no coincide";
        avisoContrasena.classList.remove("alert-primary");
        avisoContrasena.classList.add("alert-danger");
        btnEnviarDatos.disabled = true;
    }
    else if (pass.value.length < 6){
        avisoContrasena.innerHTML = "La contraseña debe tener más de 6 caracteres";
        avisoContrasena.classList.remove("alert-primary");
        avisoContrasena.classList.remove("alert-danger");
        avisoContrasena.classList.add("alert-warning");
        btnEnviarDatos.disabled = true;
    }
    else{
        avisoContrasena.innerHTML = "Contraseña valida";
        avisoContrasena.classList.remove("alert-primary");
        avisoContrasena.classList.remove("alert-danger");
        avisoContrasena.classList.remove("alert-warning");
        avisoContrasena.classList.add("alert-success");
        btnEnviarDatos.disabled = false;
    }
}