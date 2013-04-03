<?php
	class ZooZException extends Exception {

		function __construct($message, $code, $previous) {
			parent::__construct($message, $code, $previous);
		}
		
		
	}
?>