<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

<<<<<<< HEAD
<<<<<<< HEAD
    if (!empty($_POST['cedula']) and !empty($_POST['nombre']) and !empty($_POST['apellido']) and !empty($_POST['estado']) and !empty($_POST['rol']) and !empty($_POST['password']) ) {

        $id_usuario = $_POST['id_usuario'];
        $cedula = $_POST['cedula'];
        $nombre = $_POST['nombre'];
        $apellido = $_POST['apellido'];
        $estado = $_POST['estado'];
        $rol = $_POST['rol'];
        $password = $_POST['password'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE usuarios SET cedula=:doc, nombre=:nom, apellido=:ape, estado=:est, rol=:rol, password=:pass WHERE id_usuario=:idu");

            $consulta->bindParam(':idu', $id_usuario);
            $consulta->bindParam(':doc', $cedula);
            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':ape', $apellido);
            $consulta->bindParam(':est', $estado);
            $consulta->bindParam(':rol', $rol);
            $consulta->bindParam(':pass', $password);
=======
=======
>>>>>>> origin/dev04
    if (!empty($_POST['cedula']) and !empty($_POST['nombres']) and !empty($_POST['apellidos']) ) {

        $documento = $_POST['cedula'];
        $nombres = $_POST['nombres'];
        $apellidos = $_POST['apellidos'];
        $telefono = $_POST['telefono'];
        $direccion = $_POST['direccion'];
        $email = $_POST['email'];

        try {
            $consulta = $base_de_datos->prepare("UPDATE personas SET nombres=:nom, apellidos=:ape, telefono=:tel, direccion=:dir, email=:ema WHERE cedula = :doc ");

            $consulta->bindParam(':doc', $documento);
            $consulta->bindParam(':nom', $nombres);
            $consulta->bindParam(':ape', $apellidos);
            $consulta->bindParam(':tel', $telefono);
            $consulta->bindParam(':dir', $direccion);
            $consulta->bindParam(':ema', $email);
<<<<<<< HEAD
>>>>>>> origin/dev03
=======
>>>>>>> origin/dev04
            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CLIENT##UPDATE"
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CLIENT##UPDATE"
                              ];
                echo json_encode($respuesta);
            }
        } catch (Exception $e) {
            $respuesta = [
                            'status' => false,
                            'mesagge' => "ERROR##SQL",
                            'exception' => $e
                          ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'mesagge' => "ERROR##DATOS##POST",
                        '$_GET' => $_GET,
                        '$_POST' => $_POST
                      ];
        echo json_encode($respuesta);
    }
?>
