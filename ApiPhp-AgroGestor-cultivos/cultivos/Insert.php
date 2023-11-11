<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

    if (!empty($_POST['nombre']) and !empty($_POST['descripcion']) and !empty($_POST['tiempoCosecha'] and !empty($_POST['estado'])) ) {

        $nombre = $_POST['nombre'];
        $descripcion = $_POST['descripcion'];
        $tiempoCosecha = $_POST['tiempoCosecha'];
        $estado = $_POST['estado'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO cultivos ( nombre, descripcion, tiempo_cosecha, estado) VALUES(:nom, :descr, :tiemp, :esta) ");

            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':descr', $descripcion);
            $consulta->bindParam(':tiemp', $tiempoCosecha);
            $consulta->bindParam(':esta', $estado);
            
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
