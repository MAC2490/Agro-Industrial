<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include 'Conexion.php';

    if (!empty($_POST['name']) and !empty($_POST['address']) and !empty($_POST['user']) and !empty($_POST['url_img']) ) {

        $name = $_POST['name'];
        $address = $_POST['address'];
        $user = $_POST['user'];
        $img_url = $_POST['url_img'];

        try {
            if ($user == 'SA') {
                $consultation = $data_base->prepare("INSERT INTO fincas (nombre, direccion, img, id_usuario) VALUES( :nam, :addr, :img, null) ");   
                $consultation->bindParam(':nam', $name);
                $consultation->bindParam(':addr', $address);
                $consultation->bindParam(':img', $img_url);
            }else{
                $consultation = $data_base->prepare("INSERT INTO fincas (nombre, direccion, img, id_usuario) VALUES( :nam, :addr, :img, :user) ");   
                $consultation->bindParam(':nam', $name);
                $consultation->bindParam(':addr', $address);
                $consultation->bindParam(':user', $user);
                $consultation->bindParam(':img', $img_url);
            }
            
            $prossessed = $consultation->execute();

            if( $prossessed ){
                echo json_encode(100); // Se registro correcramente
            }else{
                echo json_encode(500); // No se pudo registrar
            }
        } catch (Exception $e) {
            echo json_encode(300); // Error de base de datos
        }
    }else{
        echo json_encode(404); // Datos vacios
    }
?>
