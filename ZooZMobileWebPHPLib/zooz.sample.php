<?php
	include_once 'lib/zooz.library.php';
	
	$isSandbox = true;
	
	$zoozLibrary = new ZooZLibrary("com.zooz.mobileweb.sample", "my-app-key", $isSandbox);
	
	try {
		
		if (isset($_REQUEST["cmd"]) && $_REQUEST["cmd"] == "openTrx") {
			
			$userDetails = new UserDetails();
			
			$userDetails->firstName = "Sharon";
			
			$userDetails->lastName = "Ben-Rabi";
			
			$zoozLibrary->userDetails = $userDetails;
		
			$sessionToken = $zoozLibrary->openTrx(0.99, 0, "USD");
		
			echo "var data = {'token' : '" . $sessionToken . "'}";
		
		} else {
		
			$zoozLibrary->verifyTrx($_REQUEST["transactionID"]);
		
			echo "<script>window.location = '/thankyou.html'</script>";
		}
		
	} catch (ZooZException $e) {
		error_log($e->getMessage());
		echo "<script>window.location = '/failed.html'</script>";
		
	}
	
	error_log("General error in zooz.sample.php");
	echo "<script>window.location = '/failed.html'</script>";
	
?>
