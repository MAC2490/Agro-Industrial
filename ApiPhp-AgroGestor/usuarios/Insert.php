<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';
    if (!empty($_POST['cedula']) and !empty($_POST['nombre']) and !empty($_POST['apellido']) ) {

        $cedula = $_POST['cedula'];
        $nombre = $_POST['nombre'];
        $apellido = $_POST['apellido'];
        $estado = $_POST['estado'];
        $rol = $_POST['rol'];
        $password = $_POST['password'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO usuarios (cedula, nombre, apellido, estado, rol, password) VALUES(:doc, :nom, :ape, :est, :rol, :pass) ");

            $consulta->bindParam(':doc', $cedula);
            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':ape', $apellido);
            $consulta->bindParam(':est', $estado);
            $consulta->bindParam(':rol', $rol);
            $consulta->bindParam(':pass', $password);

            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CLIENT##INSERT"
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CLIENT##INSERT"
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
