<?php
require_once './includes/config.inc.php';

class MySQLDataSource{
	
	private $db = null;
	
	function __construct(){
		$this->db = mysql_connect($config['db']['host'],$config['db']['user'],$config['db']['pass']);
		mysql_select_db($config['db']['name'],$this->db);
	}
	
	
	function __destruct(){
		try {
			$this->db->close();	
		} catch (Exception $e) {
			die("Mysql");
		}
	}
	
	function query($sql){
		if($this->db !== null){
			return $this->db->query($sql);
		}else{
			return false;
		}
	}
	
	
}

?>