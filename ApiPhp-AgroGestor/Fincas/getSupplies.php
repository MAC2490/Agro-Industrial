<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';
    if (!empty($_POST['id'])) {
        $id = $_POST['id'];
        
        $list = $data_base->query("SELECT insumos.* FROM insumos JOIN insumos_x_cultivos ON (insumos.insumos_id = insumos_x_cultivos.id_insumo) WHERE insumos_x_cultivos.id_finca = $id");
        $data = $list->fetchAll();
        
        $response['list_supplies'] = $data;
        echo json_encode($response);
    }else{
        echo json_encode(404); // Datos vacios
    }

    
?>