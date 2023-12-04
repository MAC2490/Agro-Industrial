<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

    if (!empty($_POST['id']) and !empty($_POST['nombre']) and !empty($_POST['descripcion']) and !empty($_POST['tiempocosecha'] and !empty($_POST['estado'])) ) {

        $id = $_POST['id'];
        $nombre = $_POST['nombre'];
        $descripcion = $_POST['descripcion'];
        $tiempoCosecha = $_POST['tiempocosecha'];
        $estado = $_POST['estado'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO cultivos (id_cultivo, nombre, descripcion, tiempo_cosecha, estado) VALUES (:id,:nom, :descr, :tiemp, :esta) ");

            $consulta->bindParam(':id', $id);
            $consulta->bindParam(':nom', $nombre);
            $consulta->bindParam(':descr', $descripcion);
            $consulta->bindParam(':tiemp', $tiempoCosecha);
            $consulta->bindParam(':esta', $estado);
            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CULTIVO##INSERT"
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CULTIVO##INSERT"
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
