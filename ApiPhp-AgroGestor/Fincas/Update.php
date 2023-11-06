<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

    if ( !empty($_POST['farm_id']) and !empty($_POST['name']) and !empty($_POST['address']) and !empty($_POST['user']) and !empty($_POST['url_img']) ) {

        $name = $_POST['name'];
        $address = $_POST['address'];
        $user = $_POST['user'];
        $img_url = $_POST['url_img'];

        try {
            $consultation = $data_base->prepare("UPDATE fincas SET nombre = :nam, direccion = :addr, img = :img, id_usuario = :user ");

            $consultation->bindParam(':nam', $name);
            $consultation->bindParam(':addr', $address);
            $consultation->bindParam(':user', $user);
            $consultation->bindParam(':img', $img_url);
            
            $prossessed = $consultation->execute();

            if( $prossessed ){
                $response = [
                                'status' => true,
                                'mesagge' => "OK##CLIENT##UPDATE"
                            ];
                echo json_encode($response);
            }else{
                $response = [
                                'status' => false,
                                'mesagge' => "ERROR##CLIENT##UPDATE"
                              ];
                echo json_encode($response);
            }
        } catch (Exception $e) {
            $response = [
                            'status' => false,
                            'mesagge' => "ERROR##SQL",
                            'exception' => $e
                          ];
            echo json_encode($response);
        }
    }else{
        $response = [
                        'status' => false,
                        'mesagge' => "ERROR##DATOS##POST",
                        '$_GET' => $_GET,
                        '$_POST' => $_POST
                      ];
        echo json_encode($response);
    }
?>
