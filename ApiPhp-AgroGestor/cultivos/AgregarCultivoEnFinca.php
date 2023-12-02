<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

    if (!empty($_POST['id_cultivo']) and !empty($_POST['id_finca']) ) {

        $id_cultivo = $_POST['id_cultivo'];
        $id_finca = $_POST['id_finca'];


        try {
            $consulta = $base_de_datos->prepare("INSERT INTO cultivos_finca (id_finca, id_cultivo) VALUES (:idfinca, :idcultivo) ");

            $consulta->bindParam(':idfinca', $id_finca);
            $consulta->bindParam(':idcultivo', $id_cultivo);

            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CULTIVO_AGREGADO_FINCA##INSERT"
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
